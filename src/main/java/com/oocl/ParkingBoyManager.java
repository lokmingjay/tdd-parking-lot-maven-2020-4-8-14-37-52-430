package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoyManager extends ParkingBoy {
    private List<ParkingBoy> boyList = new ArrayList<>();
    private List<ParkingLot> managerParkingLotList;

    public ParkingBoyManager(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    public List<ParkingBoy> getBoyList() {
        return boyList;
    }

    public void manage(ParkingLot... parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            parkingLot.setParkingBoyManager(this);
            managerParkingLotList.add(parkingLot);
        }
    }

    public void addBoy(ParkingBoy... boyList) {
        List<ParkingBoy> parkingBoyList = Arrays.asList(boyList);
        this.boyList.addAll(Arrays.asList(boyList));
    }

}
