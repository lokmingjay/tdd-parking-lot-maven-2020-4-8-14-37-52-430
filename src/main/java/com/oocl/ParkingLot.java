package com.oocl;

import java.util.HashMap;

public class ParkingLot {
    HashMap<ParkingTicket, Car> carTicketMap = new HashMap<>();
    private int capacity = 1;

    public  ParkingLot(){}
    public ParkingLot(int capacity){
        this.capacity = capacity;
    }
    public ParkingTicket park(Car car) {
        if (carTicketMap.size() == capacity){
            return null;
        }
        ParkingTicket ticket = new ParkingTicket();
        carTicketMap.put(ticket, car);
        return ticket;
    }

    public Car fetch(ParkingTicket ticket) {

        if(ticket==null) {
            throw new TicketNotProvidedException();
        }
        if(!carTicketMap.containsKey(ticket)){
            throw new UnrecognizedParkingTicketException();
        }
        return carTicketMap.remove(ticket);
    }

    public Boolean isCapacityFull (){
        return carTicketMap.size() == capacity;
    }
}
