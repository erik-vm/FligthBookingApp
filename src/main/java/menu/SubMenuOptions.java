package menu;

import model.PlaneCompany;

import java.util.Scanner;

public class SubMenuOptions {
    boolean exit = false;
    private MenuClient menuClient;
    private MenuCountry menuCountry;
    private MenuCity menuCity;
    private MenuPlaneCompany menuPlaneCompany;
    private MenuTrip menuTrip;
    private MenuInvoice menuInvoice;

    public SubMenuOptions() {
        menuClient = new MenuClient();
        menuCountry = new MenuCountry();
        menuCity = new MenuCity();
        menuPlaneCompany = new MenuPlaneCompany();
        menuTrip = new MenuTrip();
        menuInvoice = new MenuInvoice();
    }

    private int menuOptions(Scanner input) {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("Main menu ");
        System.out.println("-------------------------------------------------------");
        System.out.println();
        System.out.println("1: Sub Menu - Client");
        System.out.println("2: Sub Menu - County");
        System.out.println("3: Sub Menu - City");
        System.out.println("4: Sub Menu - Plane company");
        System.out.println("5: Sub Menu - Trips");
        System.out.println("6: Sub Menu - Invoices");
        System.out.println("100 - Quit");
        System.out.println("***************************************************");

        System.out.println("Type the sub menu option: ");
        return input.nextInt();
    }

    public void menuChoice(Scanner input) {
        while(!exit) {
            int userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    this.menuClient.menuChoice(input);
                    break;
                case 2: menuCountry.menuChoice(input);
                    break;
                case 3: menuCity.menuChoice(input);
                    break;
                case 4: menuPlaneCompany.menuChoice(input);
                    break;
                case 5: menuTrip.menuChoice(input);
                    break;
                case 6: menuInvoice.menuChoice(input);
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:

                    break;
                case 100:
                    exit = true;
                    System.out.println("System closed");
                    break;
//                default:
//                    System.out.println("\nSorry, please enter valid Option");
//                    menuChoice(input);
            }
        }
    }
}
