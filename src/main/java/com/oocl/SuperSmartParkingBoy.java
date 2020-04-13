package com.oocl;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {

        Double targetAvailablePositionRate = parkingLots.stream().mapToDouble(ParkingLot::availablePositionRate).max().getAsDouble();
        System.out.println(targetAvailablePositionRate);

        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.availablePositionRate() == targetAvailablePositionRate && parkingLot.emptyParkingNumber() != 0) {
                return parkingLot.park(car);
            }
        }
        throw new FullCapacityException();
    }
}
