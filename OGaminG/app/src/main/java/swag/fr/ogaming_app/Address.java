package swag.fr.ogaming_app;

/**
 * Created by Hornet on 08/06/2017.
 */

public class Address {


    private String address_line;
    private String city;
    private String country;

    public Address() {
    }


    public Address(String address_line, String city, String country) {

        this.address_line = address_line;
        this.city = city;
        this.country = country;
    }


    public String getAddressLine() {
        return this.address_line;
    }

    public void setAddressLine(String addressLine) {
        this.address_line = addressLine;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}

