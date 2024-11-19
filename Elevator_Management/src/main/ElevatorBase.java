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

    // Abstract methods to be implemented by subclasses
    public abstract void moveUp();
    public abstract void moveDown();

    // Virtual function: emergencyStop() - can be overridden by subclasses for specific implementation
    public void emergencyStop() {
        System.out.println("Elevator emergency stop triggered. Stopping immediately.");
        // Default implementation can be provided here (or abstract if no common functionality)
    }

    // Getter method for current floor
    public int getCurrentFloor() {
        return currentFloor;
    }

    // Custom cleanup method to simulate a destructor (used for cleaning up resources)
    public void cleanup() {
        System.out.println("Elevator cleanup complete. Elevator is being removed from service.");
    }
}
