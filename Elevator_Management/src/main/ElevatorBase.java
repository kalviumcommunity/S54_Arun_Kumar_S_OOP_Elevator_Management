package main;

public abstract class ElevatorBase {
    protected int currentFloor;
    protected final int maxFloor;

    // Default Constructor
    public ElevatorBase() {
        this.maxFloor = 10; // Default max floor set to 10
        this.currentFloor = 0;
    }

    // Parameterized Constructor
    public ElevatorBase(int maxFloor) {
        if (maxFloor <= 0) {
            throw new IllegalArgumentException("Maximum floor must be a positive integer.");
        }
        this.maxFloor = maxFloor;
        this.currentFloor = 0;
    }

    public abstract void moveUp();
    public abstract void moveDown();

    public int getCurrentFloor() {
        return currentFloor;
    }

    // Custom cleanup method to simulate a destructor
    public void cleanup() {
        System.out.println("Elevator cleanup complete. Elevator is being removed from service.");
    }
}
