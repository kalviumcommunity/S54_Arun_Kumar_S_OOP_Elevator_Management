package main;

public class CargoElevator extends Elevator {
    private final int weightCapacity; // Additional feature

    public CargoElevator(int maxFloor, int weightCapacity) {
        super(maxFloor); // Call parent class constructor
        this.weightCapacity = weightCapacity;
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    @Override
    public void moveUp() {
        System.out.println("CargoElevator is moving up.");
        super.moveUp();
    }

    @Override
    public void moveDown() {
        System.out.println("CargoElevator is moving down.");
        super.moveDown();
    }

    @Override
    public void emergencyStop() {
        System.out.println("CargoElevator has stopped immediately. Please reset.");
    }
}
