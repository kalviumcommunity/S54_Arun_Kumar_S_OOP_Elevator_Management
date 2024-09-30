package main;

public class Building {
    private final Elevator[] elevators;

    public Building(int numElevators, int maxFloor) {
        elevators = new Elevator[numElevators];
        
        for (int i = 0; i < numElevators; i++) {
            elevators[i] = new Elevator(maxFloor);
        }
    }

    // Method to handle service requests
    public void handleServiceRequest(int elevatorIndex, ServiceRequest request) {
        if (isValidElevator(elevatorIndex)) {
            System.out.println("Handling request for Elevator " + elevatorIndex + " to go " + request.getDirection() + " to floor " + request.getTargetFloor());
    
            // Check if the elevator is already on the requested floor
            if (elevators[elevatorIndex].getCurrentFloor() == request.getTargetFloor()) {
                System.out.println("Elevator " + elevatorIndex + " is already on the requested floor: " + request.getTargetFloor());
                return; // Exit the method as the request is already fulfilled
            }
    
            // Move the elevator based on the request direction and target floor
            while (elevators[elevatorIndex].getCurrentFloor() != request.getTargetFloor()) {
                if (request.getDirection().equalsIgnoreCase("up")) {
                    elevators[elevatorIndex].moveUp();
                } else if (request.getDirection().equalsIgnoreCase("down")) {
                    elevators[elevatorIndex].moveDown();
                }
            }
            System.out.println("Elevator " + elevatorIndex + " has reached floor: " + elevators[elevatorIndex].getCurrentFloor());
        } else {
            System.out.println("Invalid elevator index: " + elevatorIndex);
        }
    }

    // Method to get the current floor of the specified elevator
    public int getElevatorCurrentFloor(int elevatorIndex) {
        if (isValidElevator(elevatorIndex)) {
            return elevators[elevatorIndex].getCurrentFloor();
        } else {
            throw new IllegalArgumentException("Invalid elevator index: " + elevatorIndex);
        }
    }

    // Method to move the specified elevator up
    public void moveElevatorUp(int elevatorIndex) {
        if (isValidElevator(elevatorIndex)) {
            elevators[elevatorIndex].moveUp();
        } else {
            System.out.println("Invalid elevator index: " + elevatorIndex);
        }
    }

    // Method to move the specified elevator down
    public void moveElevatorDown(int elevatorIndex) {
        if (isValidElevator(elevatorIndex)) {
            elevators[elevatorIndex].moveDown();
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
