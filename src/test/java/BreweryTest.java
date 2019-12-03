import model.openbrewdb.Brewery;
import org.junit.*;
import java.net.*;
import java.util.*;

import static org.junit.Assert.*;

public class BreweryTest {
    static private Brewery testBrewery;

    @BeforeClass
    public static void testSetUp() {
        testBrewery = new Brewery();
    }

    @Test
    public void testIdGetSet() {
        testBrewery.setId(1);
        int id = testBrewery.getId();
        assertEquals(generateFailureMessage("id"), 1, id);
    }

    @Test
    public void testNameGetSet() {
        testBrewery.setName("testName");
        String name = testBrewery.getName();
        assertEquals(generateFailureMessage("name"), "testName", name);
    }

    @Test
    public void testStreetAddressGetSet() {
        testBrewery.setStreet("123 Test Lane");
        String address = testBrewery.getStreet();
        assertEquals(generateFailureMessage("address"), "123 Test Lane", address);
    }

    @Test
    public void testCityGetSet() {
        testBrewery.setCity("Madison");
        String city = testBrewery.getCity();
        assertEquals(generateFailureMessage("city"), "Madison", city);
    }

    @Test
    public void testStateGetSet() {
        testBrewery.setState("Wisconsin");
        String state = testBrewery.getState();
        assertEquals(generateFailureMessage("state"), "Wisconsin", state);
    }

    @Test
    public void testPostalCodeGetSet() {
        testBrewery.setPostalCode("53703");
        String postalCode = testBrewery.getPostalCode();
        assertEquals(generateFailureMessage("postal code"), "53703", postalCode);
    }

    @Test
    public void testCountryGetSet() {
        testBrewery.setCountry("USA");
        String country = testBrewery.getCountry();
        assertEquals(generateFailureMessage("country"), "USA", country);
    }

    @Test
    public void testLongitudeGetSet() {
        testBrewery.setLongitude(123.456);
        double longitude = testBrewery.getLongitude();
        assertEquals(123.456, longitude, 0);
    }

    @Test
    public void testLatitudeGetSet() {
        testBrewery.setLatitude(123.456);
        double latitude = testBrewery.getLatitude();
        assertEquals(123.456, latitude, 0);
    }

    @Test
    public void testPhoneNumberGetSet() {
        testBrewery.setPhone("123-456-7890");
        String phoneNumber = testBrewery.getPhone();
        assertEquals(generateFailureMessage("phone number"), "123-456-7890", phoneNumber);
    }

    @Test
    public void testWebsiteURLSetException() throws MalformedURLException {
        String testWebsiteURL = "http://localhost:8080/";
        testBrewery.setWebsiteUrl(testWebsiteURL);
        String websiteURL = testBrewery.getWebsiteUrl();
        assertEquals(generateFailureMessage("website URL"), testWebsiteURL, websiteURL);
    }

    @Test
    public void testLastUpdatedGetSet() {
        Date testDate = new Date();
        testBrewery.setUpdatedAt(testDate);
        Date date = testBrewery.getUpdatedAt();
        assertEquals(generateFailureMessage("last updated date"), testDate, date);
    }

    @Test
    public void testTagsGetSet() {
        List<String> testList = new ArrayList<>();
        testList.add("dog-friendly");
        testList.add("patio");
        testList.add("tours");
        testBrewery.setTagList(testList);
        List<String> tags = testBrewery.getTagList();
        assertSame(generateFailureMessage("tag list"), testList, tags);
    }

    private String generateFailureMessage(String testParameter) {
        return "FAILURE - Fetched " + testParameter + " does not match set " + testParameter;
    }
}