package Behavioral_Desing_pattern.Command;

import Behavioral_Desing_pattern.Command.SimpleBehaviour.commands.*;
import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.ICeilingFan;
import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.IGarageDoor;
import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.ILight;
import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.IStereo;
import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.Impl.CeilingFan;
import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.Impl.GarageDoor;
import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.Impl.Light;
import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.Impl.Stereo;

public class RemoteLoader {

    public static void main(String[] args) {

        int totalSlots = 7;

        // 1. Invoker
        RemoteControl remoteControl = new RemoteControl(totalSlots);

        // 2. Receivers
        ILight livingRoomLight = new Light("Living Room");
        ILight kitchenLight = new Light("Kitchen");
        ICeilingFan livingRoomCeilingFan = new CeilingFan("Living Room");
        IGarageDoor garageDoor = new GarageDoor("Garage");
        IStereo stereo = new Stereo("Living Room");

        // 3. Commands
        Command livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);

        Command kitchenLightOnCommand = new LightOnCommand(kitchenLight);
        Command kitchenLightOffCommand = new LightOffCommand(kitchenLight);

        Command livingRoomCeilingFanHighCommand = new CeilingFanHighCommand(livingRoomCeilingFan);
        Command livingRoomCeilingFanMediumCommand = new CeilingFanMediumCommand(livingRoomCeilingFan);
        Command livingRoomCeilingFanLowCommand = new CeilingFanLowCommand(livingRoomCeilingFan);
        Command livingRoomCeilingFanOffCommand = new CeilingFanOffCommand(livingRoomCeilingFan);

        Command garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        Command garageDoorCloseCommand = new GarageDoorCloseCommand(garageDoor);

        Command stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
        Command stereoOffCommand = new StereoOffCommand(stereo);

        // 4. Setting commands to remote control slots
        remoteControl.setCommand(0, livingRoomLightOnCommand, livingRoomLightOffCommand);
        remoteControl.setCommand(1, kitchenLightOnCommand, kitchenLightOffCommand);
        remoteControl.setCommand(2, livingRoomCeilingFanHighCommand, livingRoomCeilingFanOffCommand);
        remoteControl.setCommand(3, livingRoomCeilingFanMediumCommand, livingRoomCeilingFanOffCommand);
        remoteControl.setCommand(4, livingRoomCeilingFanLowCommand, livingRoomCeilingFanOffCommand);
        remoteControl.setCommand(5, garageDoorOpenCommand, garageDoorCloseCommand);
        remoteControl.setCommand(6, stereoOnWithCDCommand, stereoOffCommand);

        System.out.println(remoteControl);

        // 5. Testing basic functionality
        System.out.println("\n===== Testing Basic Commands =====");
        remoteControl.onButtonWasPressed(0);   // Living Room Light ON
        remoteControl.offButtonWasPressed(0);  // Living Room Light OFF
        System.out.println(remoteControl);

        // 6. Testing Undo functionality
        System.out.println("\n===== Testing Undo Functionality =====");
        System.out.println("Turning on living room light...");
        remoteControl.onButtonWasPressed(0);   // Living Room Light ON
        System.out.println("Pressing UNDO...");
        remoteControl.undoButtonWasPressed();  // Should turn light OFF

        System.out.println("\nTurning off living room light...");
        remoteControl.offButtonWasPressed(0);  // Living Room Light OFF
        System.out.println("Pressing UNDO...");
        remoteControl.undoButtonWasPressed();  // Should turn light ON

        // 7. Testing Ceiling Fan with State
        System.out.println("\n===== Testing Ceiling Fan with State =====");
        System.out.println("Turning ceiling fan to HIGH...");
        remoteControl.onButtonWasPressed(2);   // Ceiling Fan HIGH
        System.out.println("Pressing UNDO (should go back to OFF)...");
        remoteControl.undoButtonWasPressed();  // Should go back to OFF

        System.out.println("\nTurning ceiling fan to MEDIUM...");
        remoteControl.onButtonWasPressed(3);   // Ceiling Fan MEDIUM
        System.out.println("Pressing UNDO (should go back to OFF or previous)...");
        remoteControl.undoButtonWasPressed();  // Should go back to OFF

        System.out.println("\nTurning ceiling fan to LOW...");
        remoteControl.onButtonWasPressed(4);   // Ceiling Fan LOW
        System.out.println("Pressing UNDO (should go back to OFF or previous)...");
        remoteControl.undoButtonWasPressed();  // Should go back to OFF

        System.out.println("\nTurning ceiling fan OFF from HIGH...");
        remoteControl.onButtonWasPressed(2);   // Ceiling Fan HIGH
        remoteControl.offButtonWasPressed(2);  // Ceiling Fan OFF
        System.out.println("Pressing UNDO (should go back to HIGH)...");
        remoteControl.undoButtonWasPressed();  // Should go back to HIGH

        // 8. Testing Garage Door
        System.out.println("\n===== Testing Garage Door =====");
        System.out.println("Opening garage door...");
        remoteControl.onButtonWasPressed(5);   // Garage Door UP
        System.out.println("Pressing UNDO (should close)...");
        remoteControl.undoButtonWasPressed();  // Should close

        // 9. Testing Stereo
        System.out.println("\n===== Testing Stereo =====");
        System.out.println("Turning stereo on with CD...");
        remoteControl.onButtonWasPressed(6);   // Stereo ON with CD
        System.out.println("Pressing UNDO (should turn off)...");
        remoteControl.undoButtonWasPressed();  // Should turn OFF

        System.out.println("\n===== Final Remote State =====");
        System.out.println(remoteControl);
    }

}
