package menu;

import model.City;
import model.Country;
import persistence.RepositoryCity;
import persistence.RepositoryCountry;

import java.util.List;
import java.util.Scanner;

public class MenuCity {

    RepositoryCity repositoryCity = new RepositoryCity();
    RepositoryCountry repositoryCountry = new RepositoryCountry();

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
                case 1:listAllCities(input);
                    break;
                case 2: saveCity(input);
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

    private void listAllCities(Scanner input) {
        for (City city : repositoryCity.cityList()) {
            System.out.println(city);
        }
    }

    private void saveCity(Scanner input) {
        City city = new City();
        Country country = new Country();
        Boolean isValidName = false;
        Boolean isValidCountry = false;
        while (!isValidName) {
            System.out.println("Enter name for city: ");
            String cityName = input.next();
            if (cityName.matches("[A-Za-z\\s]*$")) {
                city.setName(cityName);
                isValidName = true;
            }
        }
        while (!isValidCountry){
            System.out.println("Enter country city belongs to: ");
            String countryName = input.next();
            if (repositoryCountry.getCountryByName(countryName) == null){
                System.out.println("Entered country is not in database. Current countries in database: ");
                repositoryCountry.countryList();
                return;
            }else {
                country = repositoryCountry.getCountryByName(countryName);
                city.setCountry(country);
                isValidCountry = true;
            }
        }
        repositoryCity.saveCity(city);
    }
}
