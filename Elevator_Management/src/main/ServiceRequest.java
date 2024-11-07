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
            while (elevator.getCurrentFloor() < targetFloor) {
                elevator.moveUp();
            }
        } else if (direction.equals("down")) {
            while (elevator.getCurrentFloor() > targetFloor) {
                elevator.moveDown();
            }
        }

        if (elevator.getCurrentFloor() == targetFloor) {
            System.out.println("Elevator reached target floor: " + targetFloor);
        } else {
            System.out.println("Elevator stopped at floor: " + elevator.getCurrentFloor());
        }
    }
}
