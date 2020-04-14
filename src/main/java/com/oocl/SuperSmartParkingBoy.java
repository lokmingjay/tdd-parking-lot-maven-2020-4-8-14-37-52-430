package com.oocl;

import java.util.Comparator;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {

        ParkingLot targetParkingLot = parkingLots.stream().max(Comparator.comparing(ParkingLot::availablePositionRate))
                .orElseThrow(FullCapacityException::new);
        return targetParkingLot.park(car);
    }
}
