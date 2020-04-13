package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoy {
    protected List<ParkingLot> parkingLots = new ArrayList<>();
    //private ParkingLot parkingLot;

    public ParkingBoy() {
    }

    public ParkingBoy(ParkingLot... parkingLots) {
        // this.parkingLots = Arrays.asList(parkingLots);
        this.parkingLots.addAll(Arrays.asList(parkingLots));

    }

    public ParkingTicket park(Car car) {
        Boolean firstAvailableParkingLotCheck = this.parkingLots.stream().anyMatch(parkingLot -> !parkingLot.isCapacityFull());
        if (firstAvailableParkingLotCheck) {
            ParkingLot targetParkingLot = this.parkingLots.stream().filter(parkingLot -> !parkingLot.isCapacityFull()).findFirst().get();
            return targetParkingLot.park(car);
        }
        throw new FullCapacityException();


    }

    public Car fetch(ParkingTicket ticket) {

        if (ticket == null) {
            throw new TicketNotProvidedException();
        }
        Boolean targetCarIsPark = this.parkingLots.stream().anyMatch(parkingLot -> parkingLot.carTicketMap.containsKey(ticket));
        if (targetCarIsPark) {
            ParkingLot targetParkingLot = this.parkingLots.stream().filter((parkingLot -> parkingLot.carTicketMap.containsKey(ticket))).findFirst().get();
            return parkingLots.get(0).fetch(ticket);
        }
        throw new UnrecognizedParkingTicketException();

    }

}

