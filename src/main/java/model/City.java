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

    public City() {
    }

    public City(Country country, String name, String area) {
        this.country = country;
        this.name = name;
        this.area = area;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", country=" + country +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
