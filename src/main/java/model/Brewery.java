package model;

import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * This is the model class for a Brewery.
 */
public class Brewery {
    private int id;
    private String name;
    private String breweryType;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private double longitude;
    private double latitude;
    private String phone;
    private String websiteUrl; // TODO figure out how to get this stored as URL type (or is it fine as String?)
    private Date updatedAt;
    private List<String> tagList;

    /**
     * Instantiates a new Brewery.
     */
    public Brewery() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getBreweryType() {
        return breweryType;
    }

    /**
     * Sets type.
     *
     * @param breweryType the type
     */
    public void setBreweryType(String breweryType) {
        this.breweryType = breweryType;
    }

    /**
     * Gets street address.
     *
     * @return the street address
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets street address.
     *
     * @param street the street address
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets postal code.
     *
     * @return the postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets postal code.
     *
     * @param postalCode the postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets longitude.
     *
     * @param longitude the longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets latitude.
     *
     * @param latitude the latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone number.
     *
     * @param phone the phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets website url.
     *
     * @return the website url
     */
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    /**
     * Sets website url.
     *
     * @param websiteUrl the website url
     */
    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    /**
     * Gets last updated.
     *
     * @return the last updated
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets last updated.
     *
     * @param updatedAt the last updated
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Gets tags.
     *
     * @return the tags
     */
    public List<String> getTagList() {
        return tagList;
    }

    /**
     * Sets tags.
     *
     * @param tagList the tags
     */
    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }
}
