package model.openbrewdb;

public class NameSearchSpec implements SearchSpecification {
    private String queryParameter;

    public NameSearchSpec() {
        queryParameter = "by_name";
    }

    @Override
    public String getQueryParameter() {
        return queryParameter;
    }

    @Override
    public void checkSearchTermValidity(String searchTerm) {

    }
}
