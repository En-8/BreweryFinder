package model.openbrewdb;

public class TypeSearchSpec implements SearchSpecification {
    private String queryParameter;

    public TypeSearchSpec() {
        queryParameter = "by_type";
    }

    @Override
    public String getQueryParameter() {
        return queryParameter;
    }

    @Override
    public void checkSearchTermValidity(String searchTerm) {

    }
}
