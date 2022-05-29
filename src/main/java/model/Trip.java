package model;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class Trip {
    @Id
    @GeneratedValue
    private int tripId;
    @ManyToOne
    @JoinColumn (name = "planeCompanyId")
    private PlaneCompany planeCompany;
    @ManyToOne
    @JoinColumn(name = "departureCityId")
    private City departureCity;
    @ManyToOne
    @JoinColumn(name = "destinationCityId")
    private City destinationCity;


    private Time duration;
    private double pricePerPerson;

    public City getDestinationCity() {
        return destinationCity;
    }

}
