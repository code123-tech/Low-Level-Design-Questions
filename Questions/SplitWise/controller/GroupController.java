package controller;

import java.util.ArrayList;
import java.util.List;

import model.Group;
import model.User;

public class GroupController {

    List<Group> groupList;

    public GroupController(){
        groupList = new ArrayList<>();
    }

    public void createNewGroup(String groupId, String groupName, User createByUser){
        
        Group group = new Group();
        group.setGroupId(groupId);
        group.setGroupName(groupName);
        
        group.addMember(createByUser);

        groupList.add(group);
    }

    public Group getGroup(String groupId){

        for(Group group : groupList){
            if(group.getGroupId().equals(groupId)){
                return group;
            }
        }
        return null;
    }

}
