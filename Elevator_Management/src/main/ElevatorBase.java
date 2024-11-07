package main;

public abstract class ElevatorBase {
    protected int currentFloor;
    protected final int maxFloor;

    public ElevatorBase(int maxFloor) {
        if (maxFloor <= 0) {
            throw new IllegalArgumentException("Maximum floor must be a positive integer.");
        }
        this.maxFloor = maxFloor;
        this.currentFloor = 0;
    }

    public abstract void moveUp();
    public abstract void moveDown();

    public int getCurrentFloor() {
        return currentFloor;
    }
}
