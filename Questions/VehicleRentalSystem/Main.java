package Questions.VehicleRentalSystem;

import Questions.VehicleRentalSystem.core.Location;
import Questions.VehicleRentalSystem.core.Model.*;
import Questions.VehicleRentalSystem.core.Reservation;
import Questions.VehicleRentalSystem.core.VehicleInventory;
import Questions.VehicleRentalSystem.enums.PaymentMode;
import Questions.VehicleRentalSystem.enums.ReservationType;
import Questions.VehicleRentalSystem.enums.VehicleType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------Welcome to Vehicle Rental System.----------");
        User user = new User("DUIT-345-GGGG");
        System.out.println("User with Driving license number: " + user.getDrivingLicense() + " has Id: " + user.getUserId());

        Location storeLocation = new Location("11/322, Mountain View", "Gulmarg", "Jammu And Kashmir", "India",456333);
        Store store = new Store("Mountain Rental", storeLocation, new ArrayList<>());
        System.out.println("Store with name: " + store.getStoreName() + " and id is: " + store.getStoreId());

        /** Vehicles in Store */
        Vehicle bike1 = new Vehicle("JK-12-SM-0989", "Hero", "456-BCED", 4567.90, 123, 34, 6, false, 23.45, 120.45,VehicleType.BIKE);
        Vehicle bike2 = new Vehicle("JK-12-SM-0667", "Bajaj", "456-BCEG", 4567.90, 123, 34, 6, false, 23.45, 120.45,VehicleType.BIKE);
        Vehicle car1 = new Vehicle("JK-12-SM-7789", "Maruti", "456-GGGG", 4567.90, 123, 34, 6, false, 23.45, 120.45,VehicleType.CAR);
        Vehicle car2 = new Vehicle("JK-12-SM-1234", "Kia", "456-B6678", 4567.90, 123, 34, 6, false, 23.45, 120.45,VehicleType.CAR);
        store.getVehicleInventory().addVehicle(bike1);
        store.getVehicleInventory().addVehicle(bike2);
        store.getVehicleInventory().addVehicle(car1);
        store.getVehicleInventory().addVehicle(car2);

        /**  VehicleRentalSystem */
        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem();
        vehicleRentalSystem.addUser(user);
        vehicleRentalSystem.addStore(store);

        List<Store> availableStores = vehicleRentalSystem.findStores(storeLocation);
        System.out.println("List of Available Stores near location: " + storeLocation + " are: " + availableStores.size());
        for(Store availableStore: availableStores){
            System.out.println("---------------1. Store name: " + availableStore.getStoreName() + "-------------------");
            System.out.println("Store Location: " + availableStore.getStoreLocation());
            List<Vehicle> cars = availableStore.getVehicleInventory().getAllAvailableVehicles(VehicleType.CAR);
            System.out.println("Available number of cars in Store are: " + cars.size());
            for(Vehicle car: cars){
                System.out.println(car);
            }
            List<Vehicle> bikes = availableStore.getVehicleInventory().getAllAvailableVehicles(VehicleType.BIKE);
            System.out.println("Available number of bikes in Store are: " + bikes.size());

            for(Vehicle bike: bikes){
                System.out.println(bike);
            }
        }
        System.out.println("-------------------------------------------------------------------");
        Store reservingStore = availableStores.get(0);
        System.out.println("Reserving Vehicle from Store: " + reservingStore.getStoreName());
        List<Vehicle> cars = reservingStore.getVehicleInventory().getAllAvailableVehicles(VehicleType.CAR);
        List<Vehicle> bikes = reservingStore.getVehicleInventory().getAllAvailableVehicles(VehicleType.BIKE);
        for(Vehicle car: cars){
            System.out.println(car);
        }
        for(Vehicle bike: bikes){
            System.out.println(bike);
        }
        System.out.println("Available number of Bikes in Store: " + reservingStore.getStoreName() + " are: " + reservingStore.getVehicleInventory().getAllAvailableVehicles(VehicleType.BIKE).size());
        System.out.println("Reserving Bike: " + bike1.getVehicleNumber());
        Reservation reservation1 = reservingStore.reserveVehicle(user, bike1, LocalDateTime.now(), LocalDateTime.now(), storeLocation, storeLocation, ReservationType.HOURLY);
        Bill bill1 = new Bill(reservation1);
        System.out.println("Generate total amount for vehicle: " + reservation1.getVehicle().getVehicleNumber() +" is: " + bill1.getTotalAmount());
        Payment payment1 = new Payment();
        payment1.makePayment(bill1, PaymentMode.UPI);
        System.out.println("Bike with number " + bike1.getVehicleNumber() + " is reserved for user: " + user.getDrivingLicense());
        System.out.println("Available number of Bikes in Store: " + reservingStore.getStoreName() + " are: " + reservingStore.getVehicleInventory().getAllAvailableVehicles(VehicleType.BIKE).size());


        System.out.println("Reserving Bike: " + bike2.getVehicleNumber());
        Reservation reservation2 = reservingStore.reserveVehicle(user, bike2, LocalDateTime.now(), LocalDateTime.now(), storeLocation, storeLocation, ReservationType.HOURLY);
        Bill bill2 = new Bill(reservation2);
        System.out.println("Generate total amount for vehicle: " + reservation2.getVehicle().getVehicleNumber() +" is: " + bill2.getTotalAmount());
        Payment payment2 = new Payment();
        payment2.makePayment(bill2, PaymentMode.CARD);
        System.out.println("Bike with number " + bike2.getVehicleNumber() + " is reserved for user: " + user.getDrivingLicense());
        System.out.println("Available number of Bikes in Store: " + reservingStore.getStoreName() + " are: " + reservingStore.getVehicleInventory().getAllAvailableVehicles(VehicleType.BIKE).size());


        reservingStore.completeJourney(reservation1);
        System.out.println("Available number of Bikes in Store: " + reservingStore.getStoreName() + " are: " + reservingStore.getVehicleInventory().getAllAvailableVehicles(VehicleType.BIKE).size());
    }
}
