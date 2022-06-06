package menu;

import model.City;
import model.PlaneCompany;
import model.Trip;
import persistence.RepositoryCity;
import persistence.RepositoryPlaneCompany;
import persistence.RepositoryTrip;

import java.sql.Time;
import java.util.Scanner;

public class MenuTrip {

    RepositoryTrip repositoryTrip = new RepositoryTrip();
    RepositoryPlaneCompany repositoryPlaneCompany = new RepositoryPlaneCompany();
    RepositoryCity repositoryCity = new RepositoryCity();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all trips");
        System.out.println("2: Save new trip");
        System.out.println("3: Update trip duration name by id");
        System.out.println("4: Show all departures from from one city");
        System.out.println("5: Show departure count per city");
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
                    listAllTrips(input);
                    break;
                case 2:
                    saveTrip(input);
                    break;
                case 3:
                    updateTripDuration(input);
                    break;
                case 4:
                    showDeparturesFromCity(input);
                    break;
                case 5: tripCountPerCity(input);
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


    public void listAllTrips(Scanner input) {
        if (repositoryTrip.tripList().size() == 0) {
            System.out.println("No trips available.");
            return;
        }
        System.out.println("All trips:");
        for (Trip trip : repositoryTrip.tripList()) {
            System.out.println(trip);
        }
    }

    public void saveTrip(Scanner input) {
        Trip trip = new Trip();
        boolean isValidPlaneCompany = false;
        boolean isValidDepCity = false;
        boolean isValidDesCity = false;
        boolean validDuration = false;
        boolean validPrice = false;

        while (!isValidPlaneCompany) {
            System.out.println("Enter name of plane company:");
            String planeCompanyName = input.next();
            if (repositoryPlaneCompany.doesPlaneCompanyExist(planeCompanyName)) {
                trip.setPlaneCompany(repositoryPlaneCompany.getPlaneCompanyByName(planeCompanyName));
                isValidPlaneCompany = true;
            } else {
                System.out.println("This plane company does not exist in our database.");
            }
        }
        while (!isValidDepCity) {
            System.out.println("Enter departure city:");
            String depCity = input.next();
            if (repositoryCity.doesCityExist(depCity)) {
                trip.setDepartureCity(repositoryCity.getCityByName(depCity));
                isValidDepCity = true;
            } else {
                System.out.println("This city does not exist in our database.");
            }
        }
        while (!isValidDesCity) {
            System.out.println("Enter destination city:");
            String desCity = input.next();
            if (repositoryCity.doesCityExist(desCity)) {
                trip.setDestinationCity(repositoryCity.getCityByName(desCity));
                isValidDesCity = true;
            }
        }
        while (!validDuration) {
            System.out.println("Enter trip duration (HH:MI:SS):");
            try {
                Time duration = Time.valueOf(input.next());
                if (String.valueOf(duration).matches("(?m)^(\\d\\d:\\d\\d:\\d\\d)")) {
                    trip.setDuration(duration);
                    validDuration = true;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
                ;
            }
        }
        while (!validPrice) {
            System.out.println("Enter price per person:");
            double price = input.nextDouble();
            if (String.valueOf(price).matches("\\d+\\.\\d+")) {
                trip.setPricePerPerson(price);
                validPrice = true;
                ;
            } else {
                System.out.println("Invalid input.");
            }
        }
        repositoryTrip.saveTrip(trip);
        System.out.println("Trip saved.");
    }

    public void updateTripDuration(Scanner input) {
        System.out.println("Enter trip id: ");
        int tripId = input.nextInt();
        if (repositoryTrip.getTripById(tripId) != null) {
            System.out.println("Enter new duration (HH:MI:SS)");
            Time newDuration = Time.valueOf(input.next());
            repositoryTrip.updateTripDurationById(tripId, newDuration);
            System.out.println("Duration updated");
        } else {
            System.out.println("No trip found with id: " + tripId);
        }
    }

    public void showDeparturesFromCity(Scanner input) {
        System.out.println("Enter name of the city: ");
        String cityName = input.next();
        for (Trip trip : repositoryTrip.tripListFromCity(repositoryCity.getCityByName(cityName))){
            System.out.println(trip);
        }

    }
    public void tripCountPerCity(Scanner input){
        for (City city : repositoryCity.cityList()){
            System.out.println(city.getName() + "(" + repositoryTrip.countTripsPerCity(repositoryCity.getCityByName(city.getName())) + ")");
        }
    }

}
