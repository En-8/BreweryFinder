package servlets;

import model.Brewery;
import model.OpenBreweryDb;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet (
        name = "brewerySearch",
        urlPatterns = {"/brewerySearch"}
)

public class BrewerySearchServlet extends HttpServlet {
    private OpenBreweryDb openBreweryDb;

    public void init() {
        openBreweryDb = new OpenBreweryDb();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        List<Brewery> breweries = new ArrayList<>();
        breweries = openBreweryDb.getAllBreweries();
    }
}
