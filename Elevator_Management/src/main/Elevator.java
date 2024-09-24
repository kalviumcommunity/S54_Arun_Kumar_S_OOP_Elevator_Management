package main;

public class Elevator {
    private int currentFloor;
    private final int maxFloor;

    public Elevator(int maxFloor) {
        if (maxFloor <= 0) {
            throw new IllegalArgumentException("Maximum floor must be a positive integer.");
        }
        this.currentFloor = 0;  // Assuming elevators start at ground floor (0)
        this.maxFloor = maxFloor;
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

    public void resetToGroundFloor() {
        currentFloor = 0;
        System.out.println("Elevator reset to ground floor: " + currentFloor);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}
