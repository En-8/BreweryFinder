import model.Brewery;
import org.junit.*;
import java.net.*;
import java.util.*;

import static org.junit.Assert.*;

public class BreweryTest {
    static private Brewery mockBrewery;

    @BeforeClass
    public static void testSetUp() {
        mockBrewery = new Brewery();
    }

    @Test
    public void testIdGetSet() {
        mockBrewery.setId(1);
        int id = mockBrewery.getId();
        assertEquals(generateFailureMessage("id"), 1, id);
    }

    @Test
    public void testNameGetSet() {
        mockBrewery.setName("testName");
        String name = mockBrewery.getName();
        assertEquals(generateFailureMessage("name"), "testName", name);
    }

    @Test
    public void testStreetAddressGetSet() {
        mockBrewery.setStreet("123 Test Lane");
        String address = mockBrewery.getStreet();
        assertEquals(generateFailureMessage("address"), "123 Test Lane", address);
    }

    @Test
    public void testCityGetSet() {
        mockBrewery.setCity("Madison");
        String city = mockBrewery.getCity();
        assertEquals(generateFailureMessage("city"), "Madison", city);
    }

    @Test
    public void testStateGetSet() {
        mockBrewery.setState("Wisconsin");
        String state = mockBrewery.getState();
        assertEquals(generateFailureMessage("state"), "Wisconsin", state);
    }

    @Test
    public void testPostalCodeGetSet() {
        mockBrewery.setPostalCode("53703");
        String postalCode = mockBrewery.getPostalCode();
        assertEquals(generateFailureMessage("postal code"), "53703", postalCode);
    }

    @Test
    public void testCountryGetSet() {
        mockBrewery.setCountry("USA");
        String country = mockBrewery.getCountry();
        assertEquals(generateFailureMessage("country"), "USA", country);
    }

    @Test
    public void testLongitudeGetSet() {
        mockBrewery.setLongitude(123.456);
        double longitude = mockBrewery.getLongitude();
        assertEquals(123.456, longitude, 0);
    }

    @Test
    public void testLatitudeGetSet() {
        mockBrewery.setLatitude(123.456);
        double latitude = mockBrewery.getLatitude();
        assertEquals(123.456, latitude, 0);
    }

    @Test
    public void testPhoneNumberGetSet() {
        mockBrewery.setPhone("123-456-7890");
        String phoneNumber = mockBrewery.getPhone();
        assertEquals(generateFailureMessage("phone number"), "123-456-7890", phoneNumber);
    }

    @Test
    public void testWebsiteURLSetException() throws MalformedURLException {
        String testWebsiteURL = "http://localhost:8080/";
        mockBrewery.setWebsiteUrl(testWebsiteURL);
        String websiteURL = mockBrewery.getWebsiteUrl();
        assertEquals(generateFailureMessage("website URL"), testWebsiteURL, websiteURL);
    }

    @Test
    public void testLastUpdatedGetSet() {
        Date testDate = new Date();
        mockBrewery.setUpdatedAt(testDate);
        Date date = mockBrewery.getUpdatedAt();
        assertEquals(generateFailureMessage("last updated date"), testDate, date);
    }

    @Test
    public void testTagsGetSet() {
        List<String> testList = new ArrayList<>();
        testList.add("dog-friendly");
        testList.add("patio");
        testList.add("tours");
        mockBrewery.setTagList(testList);
        List<String> tags = mockBrewery.getTagList();
        assertSame(generateFailureMessage("tag list"), testList, tags);
    }

    private String generateFailureMessage(String testParameter) {
        return "FAILURE - Fetched " + testParameter + " does not match set " + testParameter;
    }
}