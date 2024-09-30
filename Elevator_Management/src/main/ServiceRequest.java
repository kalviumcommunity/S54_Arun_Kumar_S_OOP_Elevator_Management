package main;

public class ServiceRequest {
    private final int targetFloor;
    private final String direction;

    public ServiceRequest(int targetFloor, String direction) {
        this.targetFloor = targetFloor;
        this.direction = direction.toLowerCase();
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public String getDirection() {
        return direction;
    }

    public void handleRequest(Elevator elevator) {
        System.out.println("Handling service request for floor: " + targetFloor + " (" + direction + ")");
        
        if (direction.equals("up")) {
            // Move elevator up
            while (elevator.getCurrentFloor() < targetFloor) {
                elevator.moveUp();
            }
        } else if (direction.equals("down")) {
            // Handle the case where the elevator is already at the ground floor
            if (elevator.getCurrentFloor() == 0) {
                System.out.println("Elevator is already at the ground floor, cannot move down.");
            } else {
                // Move elevator down
                while (elevator.getCurrentFloor() > targetFloor) {
                    elevator.moveDown();
                }
            }
        }

        // Check if the elevator reached the target floor
        if (elevator.getCurrentFloor() == targetFloor) {
            System.out.println("Elevator reached target floor: " + targetFloor);
        } else {
            System.out.println("Elevator stopped at floor: " + elevator.getCurrentFloor());
        }
    }
}
