package menu;

import model.Invoice;
import persistence.RepositoryClient;
import persistence.RepositoryInvoice;
import persistence.RepositoryTrip;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class MenuInvoice {

    RepositoryInvoice repositoryInvoice = new RepositoryInvoice();
    RepositoryClient repositoryClient = new RepositoryClient();
    RepositoryTrip repositoryTrip = new RepositoryTrip();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all invoices");
        System.out.println("2: Save invoice");
        System.out.println("5: Show all invoices per client");
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
                    showAllInvoices(input);
                    break;
                case 2:
                    break;
                case 3:
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

    public void showAllInvoices(Scanner input) {
        if (repositoryInvoice.invoiceList() == null) {
            System.out.println("No invoices saved.");
        } else {
            for (Invoice invoice : repositoryInvoice.invoiceList()) {
                System.out.println(invoice);
            }
        }
    }

    public void saveInvoice(Scanner input) {
        Invoice invoice = new Invoice();
        System.out.println("Enter user id:");
        invoice.setClient(repositoryClient.searchById(input.nextInt()));
        System.out.println("Select trip id:");
        int tripId = input.nextInt();
        invoice.setTrip(repositoryTrip.getTripById(tripId));
        System.out.println("When do you want to leave? ()");
        Date depTime = Date.valueOf(input.next());
        invoice.setDepartureDate(depTime);
        String time = String.valueOf(repositoryTrip.getTripById(tripId).getDuration());
        Date newDate = Date.valueOf(time);
invoice.setArrivalDate(depTime.);

        invoice.setDateIssued(Date.valueOf(LocalDate.now()));
        repositoryInvoice.saveInvoice(invoice);

    }
}
