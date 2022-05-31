package main;

import model.City;
import model.Client;
import model.Country;
import persistence.RepositoryClient;
import persistence.RepositoryCountry;

public class Main {
    public static void main(String[] args) {

        RepositoryCountry repositoryCountry = new RepositoryCountry();

        System.out.println(  repositoryCountry.getCountryByName("Estonia"));


    }
}
