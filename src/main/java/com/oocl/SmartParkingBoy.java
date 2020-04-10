package com.oocl;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        int targetParkingPositionNumber = parkingLots.stream().mapToInt(ParkingLot::emptyParkingNumber).max().getAsInt();
        //System.out.println(targetParkingPositionNumber);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.emptyParkingNumber() == targetParkingPositionNumber && targetParkingPositionNumber != 0) {
                return parkingLot.park(car);
            }
        }
        throw new FullCapacityException();
    }
}
