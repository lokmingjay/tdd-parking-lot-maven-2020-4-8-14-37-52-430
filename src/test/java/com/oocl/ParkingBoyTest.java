package com.oocl;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParkingBoyTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_return_ticket_when_parking_car() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket ticket = parkingBoy.park(car);
        Assert.assertNotNull(ticket);
    }

    @Test
    public void should_return_car_when_given_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket ticket = parkingBoy.park(car);
        Car fetchCar = parkingBoy.fetch(ticket);
        Assert.assertEquals(car, fetchCar);
    }

    @Test
    public void should_return_exception_message_when_fetch_incorrect_ticket() {
        expectedException.expect(UnrecognizedParkingTicketException.class);
        expectedException.expectMessage("Unrecognized parking ticket.");
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);
        parkingBoy.fetch(new ParkingTicket());

    }

    @Test
    public void should_return_exception_message_when_customs_without_ticket() {
        expectedException.expect(TicketNotProvidedException.class);
        expectedException.expectMessage("Please provide your parking ticket.");
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);
        parkingBoy.fetch(null);
    }

    @Test
    public void should_return_exception_message_when_capacity_is_full() {
        expectedException.expect(FullCapacityException.class);
        expectedException.expectMessage("Not enough position.");
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car carA = new Car();
        Car carB = new Car();
        ParkingTicket parkingTicketA = parkingBoy.park(carA);
        ParkingTicket parkingTicketB = parkingBoy.park(carB);
    }

    @Test
    public void should_park_to_second_parking_lot_when_first_parking_lot_is_full() {
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);
        ParkingTicket parkingTicketA = parkingBoy.park(new Car());
        Car car = new Car();
        ParkingTicket parkingTicketB = parkingBoy.park(car);
        Car fetchCar = secondParkingLot.fetch(parkingTicketB);
        Assert.assertEquals(car, fetchCar);
    }
}
