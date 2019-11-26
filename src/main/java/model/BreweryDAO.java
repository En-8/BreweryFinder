package model;

import model.openbrewdb.Brewery;
import model.openbrewdb.BreweryQuery;

import java.util.*;

public interface BreweryDAO {
    List<Brewery> getBreweries(BreweryQuery query);
    Brewery getBrewery(int id);
}
