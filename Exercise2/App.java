package Exercise2;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<SmartDevice> homeHub =  new ArrayList<>();

        SmartLight livingRoomSmartLight = new SmartLight("Living Room");
        SmartLight kitchenSmartLight =  new SmartLight("Kitchen");
        SmartThermostat hallwaySmartThermostat =  new SmartThermostat("Hallway");

        homeHub.add(livingRoomSmartLight);
        homeHub.add(kitchenSmartLight);
        homeHub.add(hallwaySmartThermostat);

        
    }
}
