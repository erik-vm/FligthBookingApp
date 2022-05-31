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

    public City() {
    }

    public City(Country country, String name) {
        this.country = country;
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", country=" + country +
                ", name='" + name + '\'' +
                '}';
    }
}
