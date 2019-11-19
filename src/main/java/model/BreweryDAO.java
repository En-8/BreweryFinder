package model;

import java.util.*;

public interface BreweryDAO {
    List<Brewery> getAllBreweries();
    Brewery getBrewery(int id);
}
