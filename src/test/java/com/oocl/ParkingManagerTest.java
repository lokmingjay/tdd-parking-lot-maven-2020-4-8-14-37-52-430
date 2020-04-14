package com.oocl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParkingManagerTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ParkingLot parkingLot;
    private ParkingBoy standardParkingBoy;
    private SmartParkingBoy smartParkingBoy;
    private SuperSmartParkingBoy superSmartParkingBoy;
    private ParkingBoyManager parkingBoyManager;
    private Car car;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot();
        standardParkingBoy = new ParkingBoy(parkingLot);
        smartParkingBoy = new SmartParkingBoy(parkingLot);
        superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot);
        parkingBoyManager = new ParkingBoyManager(parkingLot);
        car = new Car();
    }

    @Test
    public void should_add_parking_boy_to_management_list() {
        parkingBoyManager.addBoy(standardParkingBoy, smartParkingBoy, superSmartParkingBoy);
        Assert.assertEquals(true, parkingBoyManager.getBoyList().contains(standardParkingBoy));
        Assert.assertEquals(true, parkingBoyManager.getBoyList().contains(smartParkingBoy));
        Assert.assertEquals(true, parkingBoyManager.getBoyList().contains(superSmartParkingBoy));
    }

    @Test
    public void should_specify_a_parking_boy_to_park_or_fetch_the_car() {
        parkingBoyManager.addBoy(standardParkingBoy, smartParkingBoy, superSmartParkingBoy);
        ParkingTicket ticket = parkingBoyManager.getBoyList().get(0).park(car);
        Assert.assertEquals(car, parkingBoyManager.getBoyList().get(0).fetch(ticket));
        ticket = parkingBoyManager.getBoyList().get(1).park(car);
        Assert.assertEquals(car, parkingBoyManager.getBoyList().get(1).fetch(ticket));
        ticket = parkingBoyManager.getBoyList().get(2).park(car);
        Assert.assertEquals(car, parkingBoyManager.getBoyList().get(2).fetch(ticket));
    }

    @Test
    public void should_return_exception_when_parking_boy_fail() {
        Car carA = new Car();
        expectedException.expect(FullCapacityException.class);
        expectedException.expectMessage("Not enough position.");
        parkingBoyManager.addBoy(standardParkingBoy, smartParkingBoy, superSmartParkingBoy);
        ParkingTicket ticket = parkingBoyManager.getBoyList().get(0).park(car);
        ticket = parkingBoyManager.getBoyList().get(0).park(carA);
    }
}
