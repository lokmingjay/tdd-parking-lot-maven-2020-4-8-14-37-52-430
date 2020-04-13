package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ParkingManagerTest {
    @Test
    public void should_add_parking_boy__to_management_list() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy standardParkingBoy = new ParkingBoy();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        ParkingBoyManager parkingBoyManager = new ParkingBoyManager(parkingLot);
        parkingBoyManager.addBoy(standardParkingBoy,smartParkingBoy,superSmartParkingBoy);
        Assert.assertEquals(true, parkingBoyManager.getBoyList().contains(standardParkingBoy));
        Assert.assertEquals(true, parkingBoyManager.getBoyList().contains(smartParkingBoy));
        Assert.assertEquals(true, parkingBoyManager.getBoyList().contains(superSmartParkingBoy));
    }
}
