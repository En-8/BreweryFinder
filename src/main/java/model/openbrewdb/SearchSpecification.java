package model.openbrewdb;

public interface SearchSpecification {
    String getQueryParameter();
    boolean checkSearchTermValidity(String searchTerm);
}
