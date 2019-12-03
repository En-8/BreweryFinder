package model.openbrewdb;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is the only way to obtain BreweryQuery objects
 * to send to the OpenBreweryDb service. The methods available
 * here will add various parameters to the Builder instance
 * and return the updated instance. Once all of the desired parameters
 * have been set, the build() method is used to generate a
 * BreweryQuery object with all of the desired parameters that is
 * ready to be sent to the OpenBreweryDb.
 * <p>
 * Typically, it is best to create a new builder instance for each
 * query to avoid unwanted parameters in your returned query; however,
 * it is possible to create multiple instances of a BreweryQuery
 * object from a single BreweryQueryBuilder.
 */
public class BreweryQueryBuilder {
    private Map<String, String> searchParameters;
    private Map<String, SortDirection> sortParameters;
    private int entitiesPerPage;
    private int pageNumber;


    /**
     * Instantiates a new Brewery query builder.
     */
    public BreweryQueryBuilder() {
        searchParameters = new HashMap<>();
        sortParameters = new HashMap<>();
    }


    /**
     * Adds a "search by" parameter to the builder instance.
     * The search specification object implements the SearchSpecification
     * interface and contains the information necessary
     * to search by a particular field, such as City or State, in addition
     * to checking the validity of a search term. You must choose
     * from the following supported fields to search by:
     *
     * <ul>
     *     <li>Brewery Name {@link NameSearchSpec}</li>
     *     <li>City {@link CitySearchSpec}</li>
     *     <li>State {@link StateSearchSpec}</li>
     *     <li>Type {@link TypeSearchSpec}</li>
     * </ul>
     *
     * Some search specs have set options that can be used rather than taking any
     * String as a value (e.g. {@link TypeSearchSpec}). These options are
     * defined in an Enum and must be passed in instead of a String search term.
     *
     * @param searchSpec the search spec
     * @param searchTerm the search term
     * @return the updated instance of the builder
     */
    public BreweryQueryBuilder searchBy(SearchSpecification searchSpec, String searchTerm) {
        try {
            searchSpec.checkSearchTermValidity(searchTerm);
            searchParameters.put(searchSpec.getQueryParameter(), searchTerm);
        } catch (BrewerySearchException brewerySearchException) {
            // TODO improve exception handling
            brewerySearchException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return this;
    }

    /**
     * Adds a "search by" parameter to the builder instance.
     * The search specification object implements the SearchSpecification
     * interface and contains the information necessary
     * to search by a particular field, such as City or State, in addition
     * to checking the validity of a search term. You must choose
     * from the following supported fields to search by:
     * <ul>
     *     <li>Brewery Name {@link NameSearchSpec}</li>
     *     <li>City {@link CitySearchSpec}</li>
     *     <li>State {@link StateSearchSpec}</li>
     *     <li>Type {@link TypeSearchSpec}</li>
     * </ul>
     *
     * Some search specs have set options that can be used rather than taking any
     * String as a value (e.g. {@link TypeSearchSpec}). These options are
     * defined in an Enum and must be passed in instead of a String search term.
     * @param searchSpec
     * @param searchOption
     * @return the updated instance of the builder
     */
    public BreweryQueryBuilder searchBy(SearchSpecification searchSpec, SearchOption searchOption) {
        searchParameters.put(searchSpec.getQueryParameter(), searchOption.getSearchOption());
        return this;
    }

    // TODO
    public BreweryQueryBuilder sortBy(SearchSpecification searchSpec, SortDirection direction) {
        sortParameters.put(searchSpec.getQueryParameter(), direction);
        return this;
    }

    // TODO
    public BreweryQueryBuilder perPage(int perPage) {
        entitiesPerPage = perPage;
        return this;
    }

    // TODO
    public BreweryQueryBuilder pageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public BreweryQuery build() {
        return new BreweryQuery(this);
    }

    /**
     * Gets search parameters.
     *
     * @return the search parameters
     */
    public Map<String, String> getSearchParameters() {
        return searchParameters;
    }

    /**
     * Gets sort parameters.
     *
     * @return the sort parameters
     */
    public Map<String, SortDirection> getSortParameters() {
        return sortParameters;
    }

    /**
     * Gets entities per page.
     *
     * @return the entities per page
     */
    public int getEntitiesPerPage() {
        return entitiesPerPage;
    }

    /**
     * Gets page number.
     *
     * @return the page number
     */
    public int getPageNumber() {
        return pageNumber;
    }
}
