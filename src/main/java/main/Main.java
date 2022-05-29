package main;

import model.Client;
import persistence.RepositoryClient;

public class Main {
    public static void main(String[] args) {

        RepositoryClient repositoryClient = new RepositoryClient();

        Client client1 = new Client();
        client1.setFistName("Erik");
        client1.setPhoneNumber("5464646");

        repositoryClient.saveClient(client1);
    }
}
