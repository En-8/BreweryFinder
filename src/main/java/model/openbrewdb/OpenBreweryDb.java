package model.openbrewdb;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class is the main point of interaction where users can
 * request brewery data from the OpenBreweryDb web service.
 * To get the desired brewery information, build a {@link BreweryQuery} object
 * with the desired parameters using the {@link BreweryQueryBuilder}. Then,
 * pass the BreweryQuery object into this class via getBreweries() to get a
 * list of Brewery objects matching the query.
 * <p>
 * A getBreweryById() method has been provided, if needed. This will return a single
 * brewery of the given id. This requires the user to already know the id of their
 * desired brewery in the OpenBreweryDb database. IDs are part of the Brewery objects
 * returned from a getBreweries() request, so one could find the ID of their desired
 * brewery this way.
 */
public class OpenBreweryDb {
    private String endpointUrl;
    private List<Brewery> breweries;

    /**
     * Initializes the endpoint URL to the OpenBreweryDb service and the list of breweries.
     */
    public OpenBreweryDb() {
        breweries = new ArrayList<>();
        endpointUrl = "https://api.openbrewerydb.org/breweries";
    }

    /**
     * The central usage of this wrapper that is used to retrieve a list
     * of Brewery objects matching the parameters in a given BreweryQuery.
     *
     * @param query the query to send to the OpenBreweryDb service
     * @return a list of Brewery objects matching the parameters in the given query
     */
    public List<Brewery> getBreweries(BreweryQuery query) {
        Client client = ClientBuilder.newClient();
        WebTarget breweryEndpoint = client.target(endpointUrl);

        breweryEndpoint = configureWebTarget(query, breweryEndpoint);

        Response response = breweryEndpoint.request("application/json").get();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Type listType = new TypeToken<List<Brewery>>() {}.getType(); // TODO figure out what this is actually doing
        breweries = gson.fromJson(response.readEntity(String.class), listType);

        response.close();
        client.close();

        return breweries;
    }

    /**
     * Adds the parameters of the BreweryQuery to the WebTarget object
     * representing where the request for breweries will be sent.
     *
     * @param query the given query
     * @param breweryEndpoint the base URL of the service endpoint
     * @return a fully configured WebTarget
     */
    private WebTarget configureWebTarget(BreweryQuery query, WebTarget breweryEndpoint) {
        for (Map.Entry<String, String> queryParameter : query.searchParameters.entrySet()) {
            breweryEndpoint = breweryEndpoint.queryParam(queryParameter.getKey(), queryParameter.getValue());
        }
        for (Map.Entry<String, SortDirection> queryParameter : query.sortParameters.entrySet()) {

        }
        breweryEndpoint = breweryEndpoint.queryParam("page", query.pageNumber);
        breweryEndpoint = breweryEndpoint.queryParam("per_page", query.entitiesPerPage);
        return breweryEndpoint;
    }

    public Brewery getBrewery(int id) {
        return null;
    }

}
