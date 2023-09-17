package com.company;

import java.io.Serializable;

public class Ticket implements Serializable {
    public static int lastTicketNumber = 0;
    public int ticketNumber = 0;
    private Vehicle vehicle;

    Ticket(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.ticketNumber = lastTicketNumber;
        lastTicketNumber++;
    }


    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

  
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return String.format(
               "Vehicle (" + vehicle.getPlate() + "):" +  "\n" + "VehicleType :" 
                        + " %s\n" 
            		    + "Plate id :" 
                        + " %d\n" 
                        + "Spaces Needed :" 
                        + " %d\n" 
                        + "Cost Factor :" 
                        + " %.2f\n"  
                        + "Ticket number :" 
                        + " %d\n" 
                        +  "Duration :" 
                        + " %d minutes\n" 
                        + "Total Cost :"
                        + " Rs. %.2f" ,
                vehicle.getClass().getSimpleName(), vehicle.getPlate(), vehicle.getSpacesNeeded(),
                vehicle.getCostFactor(), getTicketNumber(), vehicle.calculateParkingDuration(),
                vehicle.getCost(vehicle.calculateParkingDuration(), vehicle.getCostFactor()));
    }
}
