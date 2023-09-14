package Questions.VehicleRentalSystem.core;

public class Location {
    private String address;
    private String city;
    private String state;
    private String country;
    private Integer pineCode;

    public Location(String address, String city, String state, String country, Integer pineCode) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pineCode = pineCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPineCode() {
        return pineCode;
    }

    public void setPineCode(Integer pineCode) {
        this.pineCode = pineCode;
    }

    @Override
    public String toString() {
        return "Location{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pineCode=" + pineCode +
                '}';
    }
}
