package menu;

import model.City;
import model.PlaneCompany;
import persistence.RepositoryCity;
import persistence.RepositoryPlaneCompany;

import java.util.List;
import java.util.Scanner;

public class MenuPlaneCompany {

    RepositoryPlaneCompany repositoryPlaneCompany= new RepositoryPlaneCompany();
    RepositoryCity repositoryCity = new RepositoryCity();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all plane companies");
        System.out.println("2: Save new plane company");
        System.out.println("3: Update plane company name by id");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1: listAllPlaneCompanies(input);
                    break;
                case 2:savePlaneCompany(input);
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


    public void listAllPlaneCompanies(Scanner input){
        if (repositoryPlaneCompany.planeCompanyList().size() == 0){
            System.out.println("No plane companies registered.");
            return;
        }
        System.out.println("Plane companies:");
     for (PlaneCompany planeCompany : repositoryPlaneCompany.planeCompanyList()){
         System.out.println(planeCompany);
     }
    }
    public void savePlaneCompany(Scanner input){
        City city = new City();
        String name = null;
        String cityName = null;
        boolean isValidName = false;
        boolean isValidCity  = false;
        while (!isValidName){
            System.out.println("Enter name for the company: ");
            name = input.next();
            if (name.matches("^[a-zA-Z]{1,40}$")){
                isValidName = true;
            }else {
                System.out.println("Name must contain only letters and max length is 40 characters.");
            }
        }
        while (!isValidCity){
            System.out.println("Enter name of the city");
            cityName = input.next();
            if (repositoryCity.getCityByName(cityName) != null){
                city = repositoryCity.getCityByName(cityName);
                repositoryPlaneCompany.savePlaneCompany(new PlaneCompany(name, city));
                isValidCity = true;
            } else {
                System.out.println("No such city in database.");
            }
        }
        System.out.println("Plane company saved.");
    }
}
