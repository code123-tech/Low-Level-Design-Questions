package Questions.ParkingLots.ParkingLot2.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import Questions.ParkingLots.ParkingLot2.model.User.User;

public class UserRepository {

    public static Map<String, User> users = new HashMap<>();
    public static List<User> usersList = new ArrayList<>();

    public User addUser(User user){
        users.put(user.getId(), user);
        usersList.add(user);
        return user;
    }

    public User getUserByEmail(String email){

        Optional<User> userOptional = usersList.stream().filter(user -> user.getContact() != null).filter(user -> user.getContact().getEmail().equals(email)).findFirst();
        return userOptional.isPresent() ? userOptional.get() : null;
    }

    public User getUserById(String id){
        return users.get(id);
    }
}
