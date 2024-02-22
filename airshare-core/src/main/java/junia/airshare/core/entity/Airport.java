package junia.airshare.core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Airport extends GenericEntity {

    private String name;

    private String country;

    private String city;

    @OneToMany(mappedBy = "departureAirport")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Flight> departureFlights;

    @OneToMany(mappedBy = "arrivalAirport")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Flight> arrivalFlights;

    public Airport(String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public Airport() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Flight> getDepartureFlights() {
        return departureFlights;
    }

    public void setDepartureFlights(List<Flight> departureFlights) {
        this.departureFlights = departureFlights;
    }

    public List<Flight> getArrivalFlights() {
        return arrivalFlights;
    }

    public void setArrivalFlights(List<Flight> arrivalFlights) {
        this.arrivalFlights = arrivalFlights;
    }
}
