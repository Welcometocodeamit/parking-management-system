package com.company;

public class ParkingLot {

    final int MAXFLOORS = 10;

    private ParkingFloor[] floors = new ParkingFloor[MAXFLOORS];

    public ParkingLot() {
        createFloors();
    }

    public void createFloors() {
        for (int i = 0; i < MAXFLOORS; i++) {
            this.floors[i] = new ParkingFloor(i);
        }
    }

    public int getFreeSlotCount() {
        int freeSlotsCount = 0;
        for (int j = 0; j < floors.length; j++) {
            for (int k = 0; k < floors[j].getSlots().length; k++) {
                if (!floors[j].getSlots()[k].isOccupied()) {
                    freeSlotsCount++;
                }
            }
        }
        return freeSlotsCount;
    }

    public ParkingFloor[] getFloors() {
        return floors;
    }

    public void allocateSlot(Vehicle vehicle, int floorNumber, Ticket ticket) {
        for (int k = 0; k < floors[floorNumber].getSlots().length; k++) {
            if (!floors[floorNumber].getSlots()[k].isOccupied()) {
                floors[floorNumber].getSlots()[k].setOccupied(true);
                addVehicle(k, vehicle, floorNumber, ticket);
                break;
            }
        }
    }

    public void deAllocateSlot(Ticket ticket) {
        for (int j = 0; j < floors.length; j++) {
            for (int k = 0; k < floors[j].getSlots().length; k++) {
                if (floors[j].getSlots()[k].isOccupied()
                        && (floors[j].getSlots()[k].getVehicle().getPlate() == ticket.getVehicle().getPlate())) {
                    floors[j].getSlots()[k].setOccupied(false);
                    removeVehicle(k, j, ticket);
                     return;
                }
            }
        }
    }

    public Vehicle findVehicle(int plate) {
        for (int j = 0; j < floors.length; j++) {
            for (int k = 0; k < floors[j].getSlots().length; k++) {
                ParkingSlot slot = floors[j].getSlot(k);
                if (slot != null) {
                    Vehicle veh = slot.getVehicle();
                    if (veh != null && veh.getPlate() == plate) {
                        return veh;
                    }
                }
            }
        }
        return null;
    }

    public Ticket findTicket(int plate) {
        for (int j = 0; j < floors.length; j++) {
            for (int k = 0; k < floors[j].getSlots().length; k++) {
                ParkingSlot slot = floors[j].getSlot(k);
                if (slot != null) {
                    Vehicle veh = slot.getVehicle();
                    if (veh != null && veh.getPlate() == plate) {
                        return slot.getTicket();
                    }
                }
            }
        }
        return null;
    }

    public void addVehicle(int slotNumber, Vehicle vehicle, int floorNumber, Ticket ticket) {
        ParkingSlot slot = floors[floorNumber].getSlot(slotNumber);
        slot.setVehicle(vehicle);
        slot.setTicket(ticket);
    }

    public void removeVehicle(int slotNumber, int floorNumber, Ticket ticket) {
        ParkingSlot slot = floors[floorNumber].getSlot(slotNumber);
        slot.setVehicle(null);
        slot.setTicket(null);
    }
}
