package model;

import java.util.*;

public interface BreweryDAO {
    List<Brewery> getAllBreweries(int pageNumber);
    Brewery getBrewery(int id);
}
