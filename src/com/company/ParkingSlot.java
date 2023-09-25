package com.company;


public class ParkingSlot{
    private Vehicle vehicle;
    private Ticket ticket;
    private boolean occupied;

    ParkingSlot(boolean occupied) {
        this.occupied = occupied;
    }

 
    public Ticket getTicket() {
        return ticket;
    }

 
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
