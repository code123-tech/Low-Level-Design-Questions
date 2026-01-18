# Command Pattern Implementation with Undo Functionality

## Overview
This is a complete implementation of the Command Pattern with undo functionality, based on the example from *Head First Design Patterns*.

## Structure

```
Command/
├── SimpleBehaviour/
│   ├── commands/
│   │   ├── Command.java (Interface with execute() and undo())
│   │   ├── NoCommand.java
│   │   ├── LightOnCommand.java
│   │   ├── LightOffCommand.java
│   │   ├── CeilingFanOnCommand.java (with state tracking)
│   │   ├── CeilingFanOffCommand.java (with state tracking)
│   │   ├── GarageDoorOpenCommand.java
│   │   ├── GarageDoorCloseCommand.java
│   │   ├── StereoOnWithCDCommand.java
│   │   └── StereoOffCommand.java
│   └── vendors/
│       ├── Impl/
│       │   ├── Light.java
│       │   ├── CeilingFan.java (with speed tracking)
│       │   ├── GarageDoor.java
│       │   └── Stereo.java
│       ├── ILight.java
│       ├── ICeilingFan.java (with getSpeed())
│       ├── IGarageDoor.java
│       └── IStereo.java
├── RemoteControl.java (with undoButtonWasPressed())
└── RemoteLoader.java (with undo tests)
```

## Key Features Implemented

### 1. **Basic Command Pattern**
- Command interface with `execute()` and `undo()` methods
- Concrete commands for each device operation
- RemoteControl as the Invoker
- Devices as Receivers

### 2. **Undo Functionality**
- **Simple Undo**: For Light and GarageDoor commands (opposite action)
- **Stateful Undo**: For CeilingFan commands (remembers previous speed)
- **Complex Undo**: For Stereo commands (restores full state)

### 3. **State Management**
- CeilingFan tracks its speed (HIGH, MEDIUM, LOW, OFF)
- Commands save previous state before executing
- Undo restores the exact previous state

## How It Works

### Simple Undo (Light Example)
```java
public class LightOnCommand implements Command {
    private final ILight light;
    
    @Override
    public void execute() {
        light.turnOn();
    }
    
    @Override
    public void undo() {
        light.turnOff();  // Simply do the opposite
    }
}
```

### Stateful Undo (CeilingFan Example)
```java
public class CeilingFanOnCommand implements Command {
    private final ICeilingFan ceilingFan;
    private int prevSpeed;  // Store previous state
    
    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();  // Remember current state
        ceilingFan.high();
    }
    
    @Override
    public void undo() {
        // Restore to previous state
        switch (prevSpeed) {
            case ICeilingFan.HIGH:
                ceilingFan.high();
                break;
            case ICeilingFan.MEDIUM:
                ceilingFan.medium();
                break;
            // ... etc
        }
    }
}
```

### RemoteControl with Undo
```java
public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand;  // Tracks last command
    
    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];  // Save for undo
    }
    
    public void undoButtonWasPressed() {
        undoCommand.undo();  // Call undo on last command
    }
}
```

## Running the Example

To run the example:
```bash
javac RemoteLoader.java
java Behavioral_Desing_pattern.Command.RemoteLoader
```

## Expected Output

The program demonstrates:
1. **Basic Commands** - Turning devices on/off
2. **Simple Undo** - Light turns on, then undo turns it off
3. **Stateful Undo** - Ceiling fan goes HIGH→OFF→undo→HIGH
4. **Garage Door Undo** - Opens, then undo closes it
5. **Stereo Undo** - Turns on with CD, undo turns off

## Design Patterns Used

1. **Command Pattern** - Encapsulates requests as objects
2. **Null Object Pattern** - NoCommand for unassigned slots
3. **Memento Pattern** (implicit) - Commands store state for undo

## Benefits of This Implementation

✅ **Decoupling** - Remote doesn't know about devices  
✅ **Flexibility** - Easy to add new commands  
✅ **Undo Support** - Built-in undo for all operations  
✅ **State Management** - Proper handling of stateful devices  
✅ **Testability** - Each component can be tested independently  

## Key Learnings

1. **Undo requires state** - Commands must store necessary information
2. **Not all undos are simple** - Some require remembering previous state
3. **Interface consistency** - All commands implement same interface
4. **Receiver independence** - Commands work with any receiver implementation

## Further Enhancements

Possible improvements:
- Add **multiple undo levels** (undo stack)
- Implement **redo functionality** (redo stack)
- Add **macro commands** (combine multiple commands)
- Implement **command logging** (for persistence)
- Add **transaction support** (all-or-nothing execution)

## References
- Head First Design Patterns (2nd Edition) - Chapter 6
- Command Pattern Article (Command_Pattern_Article.md)