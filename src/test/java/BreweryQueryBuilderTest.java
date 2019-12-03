import model.openbrewdb.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BreweryQueryBuilderTest {
    static private BreweryQueryBuilder builder;
    static private SearchSpecification searchSpec;
    static private SearchOption option;

    @BeforeClass
    public static void testSetUp() {
        builder = new BreweryQueryBuilder();
        searchSpec = new MockSearchSpecification("test");
        option = new MockSearchOption();
    }

    @Test
    public void testSearchByAddsParameter() {
        builder =  builder.searchBy(searchSpec, "testTerm");
        boolean containsParameter = builder.getSearchParameters().containsKey(searchSpec.getQueryParameter());
        assertTrue("FAILURE: Search parameter was not added.", containsParameter);
    }

    @Test
    public void testSearchByParameterValue() {
        builder =  builder.searchBy(searchSpec, "testTerm");
        String parameterValue = builder.getSearchParameters().get(searchSpec.getQueryParameter());
        assertEquals("FAILURE: Search parameter value was incorrect", "testTerm", parameterValue);
    }

    @Test
    public void testSearchByWithOption() {
        builder = builder.searchBy(searchSpec, option);
        String parameterValue = builder.getSearchParameters().get(searchSpec.getQueryParameter());
        assertEquals("FAILURE: Search parameter value was incorrect", "testOption", parameterValue);
    }


    static class MockSearchSpecification implements SearchSpecification {
        private String queryParameter;

        public MockSearchSpecification(String queryParameter) {
            this.queryParameter = queryParameter;
        }

        @Override
        public String getQueryParameter() {
            return queryParameter;
        }

        @Override
        public void checkSearchTermValidity(String searchTerm) throws BrewerySearchException {
        }
    }

    static class MockSearchOption implements SearchOption {
        @Override
        public String getSearchOption() {
            return "testOption";
        }
    }
}
