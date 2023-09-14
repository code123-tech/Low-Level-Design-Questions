package Questions.VehicleRentalSystem;

import Questions.VehicleRentalSystem.core.Location;
import Questions.VehicleRentalSystem.core.Model.Store;
import Questions.VehicleRentalSystem.core.Model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VehicleRentalSystem {
    private List<User> users = new ArrayList<>();
    private List<Store> stores = new ArrayList<>();

    public void addUser(User user){
        this.users.add(user);
    }
    public void removeUser(User user){
        this.users.remove(user);
    }

    public void addStore(Store store){
        this.stores.add(store);
    }
    public void removeStore(Store store){
        this.stores.remove(store);
    }

    public List<Store> findStores(Location location){
        /**
         * Change logic to find stores based on location
         */
        return Arrays.asList(stores.get(0));
    }
}
