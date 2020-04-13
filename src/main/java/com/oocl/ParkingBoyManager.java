package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoyManager extends ParkingBoy {
    private  List<ParkingBoy> boyList = new ArrayList<>();
    private  ParkingLot managerParkingLot;

    public List<ParkingBoy> getBoyList() {
        return boyList;
    }

    public ParkingBoyManager(ParkingLot managerParkingLot) {
        if(managerParkingLot.getParkingBoyManager() == null) {
            this.managerParkingLot = managerParkingLot;
            managerParkingLot.setParkingBoyManager(this);
        }
    }

    public void addBoy(ParkingBoy... boyList) {
        List<ParkingBoy> parkingBoyList = Arrays.asList(boyList);
//        for(ParkingBoy parkingBoy : parkingBoyList){
//            if(parkingBoy.parkingLots.equals())
//        }
        this.boyList.addAll(Arrays.asList(boyList));
    }


}
