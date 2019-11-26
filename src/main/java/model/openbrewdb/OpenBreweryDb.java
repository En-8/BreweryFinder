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
    private Client client;
    private WebTarget breweryEndpoint;
    private List<Brewery> breweries;

    public OpenBreweryDb() {
        breweries = new ArrayList<>();
        client = ClientBuilder.newClient();
        breweryEndpoint = client.target("https://api.openbrewerydb.org/breweries{parameters}");
    }

    public List<Brewery> getBreweries(BreweryQuery query) {
        String queryParameters = buildQueryString(query);
        WebTarget getAllBreweries = breweryEndpoint.resolveTemplate("parameters", queryParameters);
        Response response = getAllBreweries.request("application/json").get();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Type listType = new TypeToken<List<Brewery>>() {}.getType(); // TODO figure out what this is actually doing
        breweries = gson.fromJson(response.readEntity(String.class), listType);

        return breweries;
    }

    public Brewery getBrewery(int id) {
        return null;
    }

    private String buildQueryString(BreweryQuery query) {
        StringBuilder queryString = new StringBuilder();

        queryString.append('?');
        for (Map.Entry<String, String> queryParameter : query.searchParameters.entrySet()) {
            queryString.append(queryParameter.getKey());
            queryString.append('=');
            queryString.append(queryParameter.getValue());
            queryString.append('&');
        }

        // TODO insert sorting parameters

        queryString.append("page=");
        queryString.append(query.pageNumber);
        queryString.append('&');
        queryString.append("per_page=");
        queryString.append(query.entitiesPerPage);

        System.out.println(queryString.toString());
        return queryString.toString();
    }
}
