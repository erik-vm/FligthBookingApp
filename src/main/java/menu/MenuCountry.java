package menu;

import model.Country;
import persistence.RepositoryCountry;

import java.util.List;
import java.util.Scanner;

public class MenuCountry {

    RepositoryCountry repositoryCountry = new RepositoryCountry();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all countries");
        System.out.println("2: Save new country");
        System.out.println("3: Update country name by id");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1: countryList(input);
                    break;
                case 2: saveCounty(input);
                    break;
                case 3:
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

   private void countryList(Scanner input){
        if (repositoryCountry.countryList().size() > 0){
            System.out.println("Country list: ");
            for (Country country : repositoryCountry.countryList()){
                System.out.println(country);
            }
        }else {
            System.out.println("No countries found.");
            menuOptions(input);
        }
   }
   private void saveCounty(Scanner input){
        Country country = new Country();
       String countryName = null;
       boolean isValidName = false;
       while (!isValidName){
           System.out.println("Enter name of a country to save: ");
           countryName = input.next();
           if (countryName.matches("^[a-zA-Z]{3,20}$")){
               country.setName(countryName);
               repositoryCountry.saveCountry(country);
               isValidName = true;
           }
       }
   }
}
