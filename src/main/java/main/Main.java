package main;

import model.City;
import model.Client;
import model.Country;
import persistence.RepositoryCity;
import persistence.RepositoryClient;
import persistence.RepositoryCountry;
import persistence.RepositoryTrip;

import java.sql.Time;

public class Main {
    public static void main(String[] args) {
        RepositoryTrip repositoryTrip = new RepositoryTrip();
RepositoryCity repositoryCity = new RepositoryCity();
        System.out.println(repositoryTrip.countTripsPerCity(repositoryCity.getCityByName("Tallinn")));


    }
}
