package model;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;
    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country country;
    private String name;
    private String area;
}
