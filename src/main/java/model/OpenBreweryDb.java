package model;

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

public class OpenBreweryDb implements BreweryDAO {
    private Client client;
    private WebTarget breweryEndpoint;
    private List<Brewery> breweries;

    public OpenBreweryDb() {
        breweries = new ArrayList<>();
        client = ClientBuilder.newClient();
        breweryEndpoint = client.target("https://api.openbrewerydb.org/breweries{parameters}");
    }

    public List<Brewery> getAllBreweries(int pageNumber) {
        String queryParameters = "?page=" + pageNumber + "&per_page=50";
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
}
