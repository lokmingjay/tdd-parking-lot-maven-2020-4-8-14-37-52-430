package com.oocl;

import java.util.Comparator;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {

        ParkingLot targetParkingLot = parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::emptyParkingNumber))
                .orElseThrow(FullCapacityException::new);
        return targetParkingLot.park(car);
    }
}
