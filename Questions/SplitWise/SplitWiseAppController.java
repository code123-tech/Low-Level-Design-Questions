import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.BalanceSheetController;
import controller.GroupController;
import controller.UserController;
import enums.ExpenseSplitType;
import model.Group;
import model.Split;
import model.User;

public class SplitWiseAppController {

    UserController userController;
    GroupController groupController;

    BalanceSheetController balanceSheetController;

    public SplitWiseAppController(){
        
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }

    public void demo(){

        setupUserAndGroup();

        User splitWiseUser1 = userController.getUser("U1");
        User splitWiseUser2 = userController.getUser("U2");
        User splitWiseUser3 = userController.getUser("U3");

        // add members
        Group group = groupController.getGroup("G1");
        group.addMember(splitWiseUser2);
        group.addMember(splitWiseUser3);

        // equal expense inside a group
        Split split1 = new Split(splitWiseUser1, 500);
        Split split2 = new Split(splitWiseUser2, 500);
        Split split3 = new Split(splitWiseUser3, 500);
        List<Split> splits = Arrays.asList(split1, split2, split3);
        group.createExpense("G1Exp1", "Lunch", 1500, splitWiseUser1, ExpenseSplitType.EQUAL, splits);

        // unequal expense inside a group
        Split split4 = new Split(splitWiseUser1, 1000);
        Split split5 = new Split(splitWiseUser2, 2000);
        List<Split> splits2 = Arrays.asList(split4, split5);
        group.createExpense("G1Exp2", "Dinner", 3000, splitWiseUser2, ExpenseSplitType.UNEQUAL, splits2);

        for(User user: userController.getAllUsers()){
            balanceSheetController.showBalanceSheetOfUser(user);
        }
    }

    public void setupUserAndGroup(){

        addUsersToSplitWiseApp();

        // group
        User splitWiseUser1 = userController.getUser("U1");
        groupController.createNewGroup("G1", "SpltiWise Group 1", splitWiseUser1);
    }

    private void addUsersToSplitWiseApp(){
        
        User splitWiseUser1 = new User("U1", "SpltiWise User 1");

        User splitWiseUser2 = new User("U2", "SpltiWise User 2");
        
        User splitWiseUser3 = new User("U3", "SpltiWise User 3");

        userController.addUser(splitWiseUser1);
        userController.addUser(splitWiseUser2);
        userController.addUser(splitWiseUser3);
    }

    public static void main(String[] args) {
        SplitWiseAppController splitWiseAppController = new SplitWiseAppController();
        splitWiseAppController.demo();
    }

}
