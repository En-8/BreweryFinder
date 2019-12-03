package model.openbrewdb;

public interface SearchSpecification {
    String getQueryParameter();
    void checkSearchTermValidity(String searchTerm) throws BrewerySearchException;
}
