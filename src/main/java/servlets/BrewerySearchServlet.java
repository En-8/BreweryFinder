package servlets;

import model.openbrewdb.*;

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
        List<Brewery> breweries = new ArrayList<>();
        BreweryQueryBuilder builder = new BreweryQueryBuilder();
        BreweryQuery query = builder.searchBy(new StateSearchSpec(), "wisconsin").build();
        log(query.toString());
        breweries = openBreweryDb.getBreweries(query);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        for (Brewery brewery : breweries) {
            writer.print("<h1>" + brewery.getName() + "</h1>");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
