package main;

public class Main {
    public static void main(String[] args) {
        Building building = new Building(3, 10);  // 3 elevators and 10 floors

        // Move Elevator 0 up
        building.moveElevatorUp(0);
        building.moveElevatorUp(0);  // Moving up again

        // Display the floor of Elevator 0
        building.displayElevatorFloor(0);
        
        // Move Elevator 1 up
        // building.moveElevatorUp(1);
        
        // Move Elevator 2 up
        // building.moveElevatorUp(2);
    }
}
