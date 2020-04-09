package com.oocl;

import java.util.HashMap;

public class ParkingLot {
    HashMap<ParkingTicket,Car> carTicketMap = new HashMap<>();
    private static final int MAX_CAPACITY = 1;
    public ParkingTicket park(Car car) {
        if(carTicketMap.size()==MAX_CAPACITY)
            return null;
        ParkingTicket ticket = new ParkingTicket();
        carTicketMap.put(ticket,car);
        return ticket;
    }

    public Car fetch(ParkingTicket ticket) {

        return carTicketMap.remove(ticket);
    }
}
