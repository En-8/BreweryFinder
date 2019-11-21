package model;

import java.util.HashMap;
import java.util.Map;

public class BreweryQueryBuilder {
    private Map<String, String> searchParameters;
    private Map<String, SortDirection> sortParameters;
    private int entitiesPerPage;
    private int pageNumber;

    public BreweryQueryBuilder() {
        searchParameters = new HashMap<>();
        sortParameters = new HashMap<>();
    }

    public void searchBy(SearchSpecification searchSpec, String searchTerm) {
        searchParameters.put(searchSpec.getQueryParameter(), searchTerm);
    }

    public void sortBy(SearchSpecification searchSpec, SortDirection direction) {
        sortParameters.put(searchSpec.getQueryParameter(), direction);
    }

    public void perPage(int perPage) {
        entitiesPerPage = perPage;
    }

    public void pageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public BreweryQuery build() {
        return new BreweryQuery(this);
    }

    public Map<String, String> getSearchParameters() {
        return searchParameters;
    }

    public Map<String, SortDirection> getSortParameters() {
        return sortParameters;
    }

    public int getEntitiesPerPage() {
        return entitiesPerPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }
}
