package Exercise2;

public class SmartThermostat extends SmartDevice implements Adjustable {
    
    private int temperature;

    public SmartThermostat(String deviceName) {
        super(deviceName);
        this.temperature = 60;
    }

    @Override
    public void setLevel(int level) {
        if (isOn) {
            if (level >= 60 && level <= 80) {
                temperature = level;
            }
        }
    }

    @Override
    public void turnOn() {
        System.out.println("HVAC System Starting...");
        super.turnOn();
    }

    @Override
    public void performSelfDiagnostic() {
        //left empty
    }
}
