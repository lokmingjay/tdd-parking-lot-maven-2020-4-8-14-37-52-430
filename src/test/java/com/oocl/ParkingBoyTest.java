package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ParkingBoyTest {
    @Test
    public void should_return_ticket_when_parking_car() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket ticket = parkingBoy.park(car);
        Assert.assertNotNull(ticket);
    }
}
