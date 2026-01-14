package Behavioral_Desing_pattern.Command.SimpleBehaviour;

import Behavioral_Desing_pattern.Command.SimpleBehaviour.commands.GarageDoorOpenCommand;
import Behavioral_Desing_pattern.Command.SimpleBehaviour.commands.LightOnCommand;
import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.GarageDoor;
import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.IGarageDoor;
import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.Light;
import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.RoomLight;

// 1. This is our Client in command pattern
public class SimpleRemoteControlTest {

    public static void main(String[] args) {
        // 2. The remote is our Invoker, that will be passed a command to execute
        SimpleRemoteControl remote = new SimpleRemoteControl();

        // 3. The Light, garageDoor is our Receiver, that will perform the actual action when the command is executed
        Light light = new RoomLight();
        IGarageDoor garageDoor = new GarageDoor();

        // 4. Command is created and associated with the receiver
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);

        // 5. The command is set on the invoker
        remote.setCommand(lightOnCommand);
        remote.buttonWasPressed(); // 6. The button is pressed, which causes the command to be executed

        remote.setCommand(garageDoorOpenCommand);
        remote.buttonWasPressed();
    }
}
