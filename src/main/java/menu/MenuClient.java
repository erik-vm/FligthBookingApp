package menu;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.Client;
import persistence.RepositoryClient;

public class MenuClient {
    RepositoryClient repositoryClient = new RepositoryClient();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all clients");
        System.out.println("2: Save new client");
        System.out.println("3: Update clients phone number");
        System.out.println("4: List total active customers");
        System.out.println("5: List total active and not active customers");
        System.out.println("6: Update customers phone number by customer id");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    menuListAllClients(input);
                    break;
                case 2:
                    addClient(input);
                    break;
                case 3: updateClientPhoneNumber(input);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }// End of switch statement
        } while (userChoice != 100);
    }


    private void menuListAllClients(Scanner input) {
        List<Client> listClient = repositoryClient.listAllClients();

        if (listClient.size() > 0) {
            System.out.println("\nList of clients:");
            for (Client client : listClient) {
                System.out.println(client.toString());
            }
        } else {
            System.out.println("\nNo clients registered\n");
            menuOptions(input);
        }
    }

    private void addClient(Scanner input) {
        Client client = new Client();
        String firstName = null;
        String lastName = null;
        String number = null;
        String email = null;
        boolean validFirstName = false;
        boolean validLastName = false;
        boolean validNumber = false;
        boolean validEmail = false;

        while (!validFirstName) {
            System.out.println("Enter first name: ");
            firstName = input.next();
            validFirstName = isValidName(firstName);
        }
        client.setFirstName(firstName);
        while (!validLastName) {
            System.out.println("Enter last name: ");
            lastName = input.next();
            validLastName = isValidName(lastName);
        }
        client.setLastName(lastName);
        while (!validNumber) {
            System.out.println("Enter number: ");
            number = input.next();
            validNumber = isValidNumber(number);
        }
        client.setPhoneNumber(number);
        while (!validEmail) {
            System.out.println("Enter email: ");
            email = input.next();
            validEmail = isValidEmail(email);
        }
        client.setEmail(email);
        client.setDateOfRegister(LocalDate.now());
        repositoryClient.saveClient(client);


    }

    private boolean isValidName(String name) {
        return name != null && name.matches("^[a-zA-Z]{3,20}$");
    }

    private boolean isValidNumber(String number) {
        return number != null && number.matches("^\\d+");
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^(.+)@(.+)$");
    }

    private void updateClientPhoneNumber(Scanner input){
        System.out.println("Enter clients id who's number to update:");
        int clientId = input.nextInt();
        if (repositoryClient.searchById(clientId) != null){
            String number = null;
            boolean validNumber = false;
            while (!validNumber){
                System.out.println("Enter new phone number: ");
                number = input.next();
                validNumber = isValidNumber(number);
            }
            repositoryClient.updatePhoneNumber(clientId, number);
        }else {
            System.out.println("Client with id " + clientId + " not found.");
        }
    }
}
