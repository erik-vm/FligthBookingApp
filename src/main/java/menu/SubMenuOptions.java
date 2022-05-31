package menu;

import java.util.Scanner;

public class SubMenuOptions {
    boolean exit = false;
    private MenuClient menuClient;
    private MenuCountry menuCountry;
    private MenuCity menuCity;

    public SubMenuOptions() {
        menuClient = new MenuClient();
        menuCountry = new MenuCountry();
        menuCity = new MenuCity();
    }

    private int menuOptions(Scanner input) {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("Main menu ");
        System.out.println("-------------------------------------------------------");
        System.out.println();
        System.out.println("1: Sub Menu - Client");
        System.out.println("2: Sub Menu - County");
        System.out.println("3: Sub Menu - City");
        System.out.println("4: Sub Menu - <NAME>");
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
                case 4:
                    break;
                case 5:
                    break;
                case 6:
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
