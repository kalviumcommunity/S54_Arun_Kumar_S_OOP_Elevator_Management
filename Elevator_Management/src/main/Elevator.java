package main;

public class Elevator {
    private int currentFloor;
    private final int maxFloor;
    private static int totalElevatorsCreated = 0; // Static variable to track the number of elevators created

    public Elevator(int maxFloor) {
        if (maxFloor <= 0) {
            throw new IllegalArgumentException("Maximum floor must be a positive integer.");
        }
        this.currentFloor = 0;
        this.maxFloor = maxFloor;
        totalElevatorsCreated++; // Increment when a new elevator is created
    }

    public void moveUp() {
        if (currentFloor < maxFloor) {
            currentFloor++;
            System.out.println("Elevator moved up to floor: " + currentFloor);
        } else {
            System.out.println("Elevator is already at the top floor: " + currentFloor);
        }
    }

    public void moveDown() {
        if (currentFloor > 0) {
            currentFloor--;
            System.out.println("Elevator moved down to floor: " + currentFloor);
        } else {
            System.out.println("Elevator is at the ground floor: " + currentFloor);
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    // Static method to display the total number of elevators created
    public static void displayTotalElevatorsCreated() {
        System.out.println("Total elevators created: " + totalElevatorsCreated);
    }
}
