package Questions.VehicleRentalSystem.core.Model;

import Questions.VehicleRentalSystem.enums.VehicleStatus;
import Questions.VehicleRentalSystem.enums.VehicleType;

import java.util.UUID;

public class Vehicle {
    private String vehicleId;
    private String vehicleNumber;
    private String vehicleCompany;
    private String vehicleModel;
    private Double kmsDriven;
    private Integer cc;
    private Integer average;
    private Integer numberOfSeats;
    private Boolean isRoofTopOpen;
    private Double hourlyRent;
    private Double dailyRent;
    private VehicleStatus vehicleStatus;
    private VehicleType vehicleType;

    public Vehicle(String vehicleNumber, VehicleType vehicleType){
        this.vehicleId = UUID.randomUUID().toString();
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public Vehicle(String vehicleNumber, String vehicleCompany, String vehicleModel, Double kmsDriven, Integer cc, Integer average, Integer numberOfSeats, Boolean isRoofTopOpen, Double hourlyRent, Double dailyRent, VehicleType vehicleType) {
        this.vehicleId = UUID.randomUUID().toString();;
        this.vehicleNumber = vehicleNumber;
        this.vehicleCompany = vehicleCompany;
        this.vehicleModel = vehicleModel;
        this.kmsDriven = kmsDriven;
        this.cc = cc;
        this.average = average;
        this.numberOfSeats = numberOfSeats;
        this.isRoofTopOpen = isRoofTopOpen;
        this.hourlyRent = hourlyRent;
        this.dailyRent = dailyRent;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleCompany() {
        return vehicleCompany;
    }

    public void setVehicleCompany(String vehicleCompany) {
        this.vehicleCompany = vehicleCompany;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Double getKmsDriven() {
        return kmsDriven;
    }

    public void setKmsDriven(Double kmsDriven) {
        this.kmsDriven = kmsDriven;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Boolean getRoofTopOpen() {
        return isRoofTopOpen;
    }

    public void setRoofTopOpen(Boolean roofTopOpen) {
        isRoofTopOpen = roofTopOpen;
    }

    public Double getHourlyRent() {
        return hourlyRent;
    }

    public void setHourlyRent(Double hourlyRent) {
        this.hourlyRent = hourlyRent;
    }

    public Double getDailyRent() {
        return dailyRent;
    }

    public void setDailyRent(Double dailyRent) {
        this.dailyRent = dailyRent;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleCompany='" + vehicleCompany + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", kmsDriven=" + kmsDriven +
                ", cc=" + cc +
                ", average=" + average +
                ", numberOfSeats=" + numberOfSeats +
                ", isRoofTopOpen=" + isRoofTopOpen +
                ", hourlyRent=" + hourlyRent +
                ", dailyRent=" + dailyRent +
                ", vehicleStatus=" + vehicleStatus +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
