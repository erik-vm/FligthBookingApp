package model;

import javax.persistence.*;

@Entity
public class PlaneCompany {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int planeCompanyId;
    private String name;
    @ManyToOne
    @JoinColumn (name = "cityId")
    private City city;
}
