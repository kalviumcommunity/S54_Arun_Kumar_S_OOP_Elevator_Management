package main;

public class Building {
    private final Elevator[] elevators;

    public Building(int numElevators, int maxFloor) {
        elevators = new Elevator[numElevators];
        for (int i = 0; i < numElevators; i++) {
            elevators[i] = new Elevator(maxFloor);
        }
    }

    // Method to move the specified elevator up
    public void moveElevatorUp(int elevatorIndex) {
        if (isValidElevator(elevatorIndex)) {
            System.out.println("Elevator " + elevatorIndex + " is on floor: " + elevators[elevatorIndex].getCurrentFloor());
            elevators[elevatorIndex].moveUp();  // Move the elevator
            System.out.println("Elevator " + elevatorIndex + " moved up to floor: " + elevators[elevatorIndex].getCurrentFloor());
        } else {
            System.out.println("Invalid elevator index: " + elevatorIndex);
        }
    }

    // Method to move the specified elevator down
    public void moveElevatorDown(int elevatorIndex) {
        if (isValidElevator(elevatorIndex)) {
            System.out.println("Elevator " + elevatorIndex + " is on floor: " + elevators[elevatorIndex].getCurrentFloor());
            elevators[elevatorIndex].moveDown();  // Move the elevator
            System.out.println("Elevator " + elevatorIndex + " moved down to floor: " + elevators[elevatorIndex].getCurrentFloor());
        } else {
            System.out.println("Invalid elevator index: " + elevatorIndex);
        }
    }

    // Method to display the current floor of the specified elevator
    public void displayElevatorFloor(int elevatorIndex) {
        if (isValidElevator(elevatorIndex)) {
            System.out.println("Elevator " + elevatorIndex + " is on floor: " + elevators[elevatorIndex].getCurrentFloor());
        } else {
            System.out.println("Invalid elevator index: " + elevatorIndex);
        }
    }

    // Helper method to check if the elevator index is valid
    private boolean isValidElevator(int index) {
        return index >= 0 && index < elevators.length;
    }
}
