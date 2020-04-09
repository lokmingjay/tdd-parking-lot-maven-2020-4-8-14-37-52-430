package com.oocl;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SmartParkingBoyTest {
    @Test
    public void should_park_car_with_more_empty_position_parking_lot() {
        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(3);
        ParkingLot parkingLotC = new ParkingLot(5);
        Car carA = new Car();
        Car carB = new Car();
        Car carC = new Car();

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotA, parkingLotB, parkingLotC);
        ParkingTicket ticketA = smartParkingBoy.park(carA);
        ParkingTicket ticketB = smartParkingBoy.park(carB);
        ParkingTicket ticketC = smartParkingBoy.park(carC);
        Car targetCarA = parkingLotC.fetch(ticketA);
        Car targetCarB = parkingLotC.fetch(ticketB);
        Car targetCarC = parkingLotB.fetch(ticketC);
        Assert.assertEquals(carA, targetCarA);
        Assert.assertEquals(carB, targetCarB);
        Assert.assertEquals(carC, targetCarC);

    }
}