package Questions.VehicleRentalSystem.core.Model;

import java.util.UUID;

public class User {
    private String userId;
    private String drivingLicense;

    public User(String drivingLicense) {
        this.userId = UUID.randomUUID().toString();
        this.drivingLicense = drivingLicense;
    }

    public String getUserId() {
        return userId;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }
}
