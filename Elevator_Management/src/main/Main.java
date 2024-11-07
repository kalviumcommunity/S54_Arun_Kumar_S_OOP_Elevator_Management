package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of elevators: ");
            int numElevators = scanner.nextInt();

            System.out.print("Enter the maximum number of floors: ");
            int maxFloor = scanner.nextInt();

            Building building = new Building(numElevators, maxFloor);

            int serviceRequestCount = 0;

            while (true) {
                System.out.println("\nEnter a service request:");
                System.out.print("Enter the elevator index (0 to " + (numElevators - 1) + "): ");
                int elevatorIndex = scanner.nextInt();

                System.out.print("Enter the target floor (0 to " + maxFloor + "): ");
                int targetFloor = scanner.nextInt();

                String direction = building.getElevatorCurrentFloor(elevatorIndex) < targetFloor ? "up" : "down";

                ServiceRequest request = new ServiceRequest(targetFloor, direction);
                building.handleServiceRequest(elevatorIndex, request);
                serviceRequestCount++;

                System.out.print("Do you want to add another request? (yes/no): ");
                String continueInput = scanner.next().toLowerCase();
                if (!continueInput.equals("yes")) {
                    break;
                }
            }

            for (int i = 0; i < numElevators; i++) {
                building.displayElevatorFloor(i);
            }

            System.out.println("Total service requests handled: " + serviceRequestCount);
            Building.displayBuildingElevators();

            // Cleanup each elevator at the end of the program
            for (int i = 0; i < numElevators; i++) {
                ((Elevator) building.getElevator(i)).cleanup();
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
