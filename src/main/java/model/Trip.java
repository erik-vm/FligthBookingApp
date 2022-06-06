package model;

import javax.persistence.*;
import java.sql.Time;
import java.time.DayOfWeek;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripId;
    @ManyToOne
    @JoinColumn(name = "planeCompanyId")
    private PlaneCompany planeCompany;
    @ManyToOne
    @JoinColumn(name = "departureCityId")
    private City departureCity;
    @ManyToOne
    @JoinColumn(name = "destinationCityId")
    private City destinationCity;

    private DayOfWeek dayOfWeek;
    private Time departureTime;
    private Time duration;
    private double pricePerPerson;

    public City getDestinationCity() {
        return destinationCity;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public PlaneCompany getPlaneCompany() {
        return planeCompany;
    }

    public void setPlaneCompany(PlaneCompany planeCompany) {
        this.planeCompany = planeCompany;
    }

    public City getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(City departureCity) {
        this.departureCity = departureCity;
    }

    public void setDestinationCity(City destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public String toString() {
        return "Trip id: " + tripId + " | Departure: " + departureCity.getName() + "(" + departureCity.getCountry().getName() + ")"
                + " | Destination: " + destinationCity.getName() + "(" + destinationCity.getCountry().getName() + ")" + " | Departure time: " + departureTime  +" | Duration: " + duration
                + " | Price per person: " + pricePerPerson + " | Plane company: " + planeCompany.getName();
    }
}
