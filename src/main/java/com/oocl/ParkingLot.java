package com.oocl;

import java.util.HashMap;

public class ParkingLot {
    HashMap<ParkingTicket, Car> carTicketMap = new HashMap<>();
    private int capacity = 1;

    private ParkingBoyManager parkingBoyManager;

    public ParkingBoyManager getParkingBoyManager() {
        return parkingBoyManager;
    }

    public void setParkingBoyManager(ParkingBoyManager parkingBoyManager) {
        this.parkingBoyManager = parkingBoyManager;
    }

    public  ParkingLot(){}
    public ParkingLot(int capacity){
        this.capacity = capacity;
    }
    public ParkingTicket park(Car car) {
        ParkingTicket ticket = new ParkingTicket();
        carTicketMap.put(ticket, car);
        return ticket;
    }

    public Car fetch(ParkingTicket ticket) {
        return carTicketMap.remove(ticket);
    }

    public Boolean isCapacityFull (){
        return carTicketMap.size() == capacity;
    }

    public int emptyParkingNumber (){
        return capacity-carTicketMap.size();
    }

    public double availablePositionRate() {
        return Double.valueOf(emptyParkingNumber())/capacity;
    }
}
