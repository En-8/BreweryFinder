package model.openbrewdb;

import java.util.Map;

public class BreweryQuery {
    public final Map<String, String> searchParameters;
    public final Map<String, SortDirection> sortParameters;
    public final int entitiesPerPage;
    public final int pageNumber;

    public BreweryQuery(BreweryQueryBuilder builder) {
        this.searchParameters = builder.getSearchParameters();
        this.sortParameters = builder.getSortParameters();
        this.entitiesPerPage = builder.getEntitiesPerPage();
        this.pageNumber = builder.getPageNumber();
    }

    public String toString() {
        StringBuilder queryString = new StringBuilder();

        queryString.append('?');
        for (Map.Entry<String, String> queryParameter : searchParameters.entrySet()) {
            queryString.append(queryParameter.getKey());
            queryString.append('=');
            queryString.append(queryParameter.getValue());
            queryString.append('&');
        }

        // TODO insert sorting parameters

        queryString.append("page=");
        queryString.append(pageNumber);
        queryString.append('&');
        queryString.append("per_page=");
        queryString.append(entitiesPerPage);

//        System.out.println(queryString.toString());
        return queryString.toString();
    }
}
