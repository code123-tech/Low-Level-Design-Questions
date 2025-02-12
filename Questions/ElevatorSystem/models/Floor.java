package Questions.ElevatorSystem.models;

import Questions.ElevatorSystem.enums.Direction;

public class Floor {
    
    private int floorNumber;
    private Display display;
    private ExternalButton externalButton;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        externalButton = new ExternalButton();
        display = new Display();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public ExternalButton getExternalButton() {
        return externalButton;
    }

    public void setExternalButton(ExternalButton externalButton) {
        this.externalButton = externalButton;
    }

    public void pressButton(Direction direction){
        externalButton.pressButton(floorNumber, direction);
    }
}
