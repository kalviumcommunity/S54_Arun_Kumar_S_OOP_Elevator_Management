package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Use try-with-resources to automatically close the Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of elevators: ");
            int numElevators = scanner.nextInt();

            System.out.print("Enter the maximum number of floors: ");
            int maxFloor = scanner.nextInt();

            Building building = new Building(numElevators, maxFloor);  // Create the building with specified elevators and floors

            int serviceRequestCount = 0; // Count of service requests handled

            while (true) {
                System.out.println("\nEnter a service request:");
                System.out.print("Enter the elevator index (0 to " + (numElevators - 1) + "): ");
                int elevatorIndex = scanner.nextInt();

                System.out.print("Enter the target floor (0 to " + maxFloor + "): ");
                int targetFloor = scanner.nextInt();

                // Determine direction based on the current floor of the elevator and the target floor
                String direction;
                int currentFloor = building.getElevatorCurrentFloor(elevatorIndex);
                
                if (currentFloor < targetFloor) {
                    direction = "up";
                } else if (currentFloor > targetFloor) {
                    direction = "down";
                } else {
                    System.out.println("Elevator is already on the requested floor: " + targetFloor);
                    continue; // Skip to the next request
                }

                // Create the service request
                ServiceRequest request = new ServiceRequest(targetFloor, direction);
                // Handle the service request
                building.handleServiceRequest(elevatorIndex, request);
                serviceRequestCount++;

                // Ask if the user wants to add another request
                System.out.print("Do you want to add another request? (yes/no): ");
                String continueInput = scanner.next().toLowerCase();
                if (!continueInput.equals("yes")) {
                    break;
                }
            }

            // Display final elevator states
            for (int i = 0; i < numElevators; i++) {
                building.displayElevatorFloor(i);
            }

            // Display total service requests handled
            System.out.println("Total service requests handled: " + serviceRequestCount);
            // Display total elevators created
            System.out.println("Total elevators created: " + numElevators);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}