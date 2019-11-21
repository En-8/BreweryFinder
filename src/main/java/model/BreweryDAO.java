package model;

import java.util.*;

public interface BreweryDAO {
    List<Brewery> getBreweries(BreweryQuery query);
    Brewery getBrewery(int id);
}
