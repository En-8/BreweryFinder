package model.openbrewdb;

public class CitySearchSpec implements SearchSpecification {
    private String queryParameter;

    public CitySearchSpec() {
        queryParameter = "by_city";
    }

    @Override
    public String getQueryParameter() {
        return queryParameter;
    }

    @Override
    public void checkSearchTermValidity(String searchTerm) {

    }
}
