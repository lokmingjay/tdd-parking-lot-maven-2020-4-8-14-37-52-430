package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ParkingBoy {
    protected List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingBoy() {
    }

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }

    public ParkingTicket park(Car car) {
        ParkingLot targetParkingLot = this.parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isCapacityFull())
                .findFirst()
                .orElseThrow(FullCapacityException::new);
        return targetParkingLot.park(car);
    }

    public Car fetch(ParkingTicket ticket) {
        if (ticket == null) {
            throw new TicketNotProvidedException();
        }

        ParkingLot targetParkingLot = this.parkingLots.stream()
                .filter((parkingLot -> parkingLot.carTicketMap.containsKey(ticket)))
                .findFirst()
                .orElseThrow(UnrecognizedParkingTicketException::new);
        return targetParkingLot.fetch(ticket);
    }

}

