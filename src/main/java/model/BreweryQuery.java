package model;

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
}
