package main;

import model.City;
import model.Client;
import model.Country;
import persistence.RepositoryClient;

public class Main {
    public static void main(String[] args) {

        RepositoryClient repositoryClient = new RepositoryClient();

        Client client1 = new Client("John", "Doe", "+64646788", "Joh.Doe@mail.com");

        repositoryClient.saveClient(client1);

        Country Estonia = new Country("Estonia");

        City city = new City(Estonia, "Tallinn", "Harjumaa");
    }
}
