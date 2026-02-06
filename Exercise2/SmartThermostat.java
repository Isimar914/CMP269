package Exercise2;

public class SmartThermostat extends SmartDevice implements Adjustable {
    
    private int temperature;

    public SmartThermostat(String deviceName) {
        super(deviceName);
        this.temperature = 60;
    }
    
}
