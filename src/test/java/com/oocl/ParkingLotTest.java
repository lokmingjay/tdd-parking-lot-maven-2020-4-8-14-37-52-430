package com.oocl;

import org.junit.Assert;
import org.junit.Test;

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

    @Test
    public void should_not_return_car_when_given_ticket_is_used(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);
        Car fetchCar = parkingLot.fetch(ticket);
        Assert.assertNull(fetchCar);

    }

}
