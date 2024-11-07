package main;

public class Elevator extends ElevatorBase {
    private static int totalElevatorsCreated = 0; // Static variable to track total number of elevators created

    // Constructor
    public Elevator(int maxFloor) {
        super(maxFloor); // Calling the superclass constructor
        totalElevatorsCreated++; // Increment count when a new elevator is created
    }

    // Method to move elevator up by one floor
    @Override
    public void moveUp() {
        if (currentFloor < maxFloor) {
            currentFloor++;
            System.out.println("Elevator moved up to floor: " + currentFloor);
        } else {
            System.out.println("Elevator is already at the top floor: " + currentFloor);
        }
    }

    // Method to move elevator down by one floor
    @Override
    public void moveDown() {
        if (currentFloor > 0) {
            currentFloor--;
            System.out.println("Elevator moved down to floor: " + currentFloor);
        } else {
            System.out.println("Elevator is at the ground floor: " + currentFloor);
        }
    }

    // Static method to display the total number of elevators created
    public static void displayTotalElevatorsCreated() {
        System.out.println("Total elevators created: " + totalElevatorsCreated);
    }

    // Static method to reset total elevators count (useful for testing purposes)
    public static void resetTotalElevatorsCount() {
        totalElevatorsCreated = 0;
    }
}
