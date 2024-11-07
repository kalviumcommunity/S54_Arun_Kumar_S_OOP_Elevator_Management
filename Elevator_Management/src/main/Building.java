package main;

public class Building {
    private final ElevatorBase[] elevators;

    // Constructor to create a building with a specified number of elevators and max floor
    public Building(int numberOfElevators, int maxFloor) {
        if (numberOfElevators <= 0 || maxFloor <= 0) {
            throw new IllegalArgumentException("Invalid number of elevators or max floor value.");
        }
        elevators = new ElevatorBase[numberOfElevators];
        for (int i = 0; i < numberOfElevators; i++) {
            elevators[i] = new Elevator(maxFloor); // Dynamic allocation using 'new'
        }
    }

    // Method to move an elevator to a specific floor based on user input
    public void moveElevator(int elevatorIndex, int destinationFloor) {
        if (elevatorIndex < 0 || elevatorIndex >= elevators.length) {
            System.out.println("Invalid elevator index.");
            return;
        }
        ElevatorBase elevator = elevators[elevatorIndex];
        if (destinationFloor < 0 || destinationFloor > elevator.maxFloor) {
            System.out.println("Invalid floor selection.");
            return;
        }

        while (elevator.getCurrentFloor() < destinationFloor) {
            elevator.moveUp();
        }
        while (elevator.getCurrentFloor() > destinationFloor) {
            elevator.moveDown();
        }
    }

    // Method to display the status of all elevators in the building
    public void displayElevatorStatus() {
        for (int i = 0; i < elevators.length; i++) {
            System.out.println("Elevator " + (i + 1) + " is on floor " + elevators[i].getCurrentFloor());
        }
    }

    // New method to display the current floor of a specified elevator
    public void displayElevatorFloor(int elevatorIndex) {
        if (elevatorIndex < 0 || elevatorIndex >= elevators.length) {
            System.out.println("Invalid elevator index.");
            return;
        }
        System.out.println("Elevator " + (elevatorIndex + 1) + " is currently on floor " + elevators[elevatorIndex].getCurrentFloor());
    }

    // Static method to display total number of elevators created
    public static void displayBuildingElevators() {
        Elevator.displayTotalElevatorsCreated();
    }

    // Getter method for an elevator's current floor
    public int getElevatorCurrentFloor(int elevatorIndex) {
        if (elevatorIndex < 0 || elevatorIndex >= elevators.length) {
            throw new IllegalArgumentException("Invalid elevator index.");
        }
        return elevators[elevatorIndex].getCurrentFloor();
    }

    // Handle the service request for a specific elevator
    public void handleServiceRequest(int elevatorIndex, ServiceRequest request) {
        if (elevatorIndex < 0 || elevatorIndex >= elevators.length) {
            System.out.println("Invalid elevator index.");
            return;
        }
        request.handleRequest((Elevator) elevators[elevatorIndex]);
    }
}
