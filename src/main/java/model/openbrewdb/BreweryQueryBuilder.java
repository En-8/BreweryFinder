package model.openbrewdb;

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
        entitiesPerPage = 50; // TODO remove once implemented
        pageNumber = 1; // TODO remove once implemented
    }

    public BreweryQueryBuilder searchBy(SearchSpecification searchSpec, String searchTerm) {
        searchSpec.checkSearchTermValidity(searchTerm);
        searchParameters.put(searchSpec.getQueryParameter(), searchTerm);
        return this;
    }

    public BreweryQueryBuilder searchBy(SearchSpecification searchSpec, SearchOption searchOption) {
        searchParameters.put(searchSpec.getQueryParameter(), searchOption.getSearchOption());
        return this;
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
