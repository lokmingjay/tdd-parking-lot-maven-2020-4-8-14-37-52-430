package com.oocl;

public class ParkingBoy {

    private ParkingLot parkingLot;
    public ParkingBoy(){}

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }
    public ParkingTicket park(Car car) {
        return parkingLot.park(car);
    }
}
