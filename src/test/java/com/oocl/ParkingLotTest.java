package com.oocl;

import org.junit.Assert;
import org.junit.Test;
import sun.security.krb5.internal.Ticket;

public class ParkingLotTest {
    @Test
    public void should_return_ticket_when_park_car() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket ticket = parkingLot.park(car);
        Assert.assertNotNull(ticket);

    }

    @Test
    public void should_return_car_when_given_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket ticket = parkingLot.park(car);
        Car fetchCar = parkingLot.fetch(ticket);
        Assert.assertEquals(car, fetchCar);
    }

}
