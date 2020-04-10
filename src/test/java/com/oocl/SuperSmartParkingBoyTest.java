package com.oocl;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuperSmartParkingBoyTest {
    @Test
    public void should_park_car_with_larger_available_position_rate() {
        ParkingLot parkingLotA = new ParkingLot(5);
        ParkingLot parkingLotB = new ParkingLot(4);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotA, parkingLotB);
        Car carA = new Car();
        Car carB = new Car();
        Car carC = new Car();
        ParkingTicket ticketA = superSmartParkingBoy.park(carA);
        ParkingTicket ticketB = superSmartParkingBoy.park(carB);
        ParkingTicket ticketC = superSmartParkingBoy.park(carC);
        Car targetCarA = parkingLotA.fetch(ticketA);
        Car targetCarB = parkingLotB.fetch(ticketB);
        Car targetCarC = parkingLotA.fetch(ticketC);
        Assert.assertEquals(carA, targetCarA);
        Assert.assertEquals(carB, targetCarB);
        Assert.assertEquals(carC, targetCarC);
    }
}