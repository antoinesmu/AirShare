package junia.airshare.core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.Duration;
import java.util.Date;

@Entity
public class Flight extends GenericEntity {

    private Date departureDate;

    private Date arrivalDate;

    private int flightTime;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User userSubmitting;

    @ManyToOne
    private Airport departureAirport;

    @ManyToOne
    private Airport arrivalAirport;

    public Flight() {
    }

    public Flight(Date departureDate, Date arrivalDate, int flightTime) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightTime = flightTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    public User getUserSubmitting() {
        return userSubmitting;
    }

    public void setUserSubmitting(User userSubmitting) {
        this.userSubmitting = userSubmitting;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
}
