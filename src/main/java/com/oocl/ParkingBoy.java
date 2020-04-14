package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoy {
    protected List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingBoy() {
    }

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }

    public ParkingTicket park(Car car) {
        Boolean firstAvailableParkingLotCheck = this.parkingLots.stream()
                .anyMatch(parkingLot -> !parkingLot.isCapacityFull());
        if (firstAvailableParkingLotCheck) {
            ParkingLot targetParkingLot = this.parkingLots.stream().filter(parkingLot -> !parkingLot.isCapacityFull())
                    .findFirst().get();
            return targetParkingLot.park(car);
        }
        throw new FullCapacityException();
    }

    public Car fetch(ParkingTicket ticket) {

        if (ticket == null) {
            throw new TicketNotProvidedException();
        }

        boolean targetCarIsParked = this.parkingLots.stream()
                .anyMatch(parkingLot -> parkingLot.carTicketMap.containsKey(ticket));
        if (targetCarIsParked) {
            ParkingLot targetParkingLot = this.parkingLots.stream().filter((parkingLot -> parkingLot.carTicketMap.containsKey(ticket)))
                    .findFirst().get();
            return targetParkingLot.fetch(ticket);
        }
        throw new UnrecognizedParkingTicketException();

    }

}

