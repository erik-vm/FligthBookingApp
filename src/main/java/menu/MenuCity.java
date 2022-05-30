package menu;

import model.City;
import persistence.RepositoryCity;

import java.util.List;
import java.util.Scanner;

public class MenuCity {

    RepositoryCity repositoryCity = new RepositoryCity();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all cities");
        System.out.println("2: Save new city");
        System.out.println("3: Update city name by id");
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
                    break;
                case 2:
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

    private void listAllCities(){
        for (City city : repositoryCity.cityList()){
            System.out.println(city);
        }
    }
   /* private void saveCity(Scanner input){
        City city = new City();
        System.out.println("Enter name for city: ");
        String cityName = input.next();
        if (cityName.matches("^[a-zA-Z]{3,20}$")){
            city.setName(cityName);
        }
    }*/
}
