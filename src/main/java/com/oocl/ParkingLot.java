package com.oocl;

import java.util.HashMap;

public class ParkingLot {
    HashMap<ParkingTicket,Car> carTicketMap = new HashMap<ParkingTicket, Car>();

    public ParkingTicket park(Car car) {
        ParkingTicket ticket = new ParkingTicket();
        carTicketMap.put(ticket,car);
        return ticket;
    }

    public Car fetch(ParkingTicket ticket) {
        return carTicketMap.get(ticket);
    }
}
