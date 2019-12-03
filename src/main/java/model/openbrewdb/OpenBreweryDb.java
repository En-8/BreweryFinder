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

public class OpenBreweryDb {
    private String endpointUrl;
    private List<Brewery> breweries;

    public OpenBreweryDb() {
        breweries = new ArrayList<>();
        endpointUrl = "https://api.openbrewerydb.org/breweries";
    }

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
