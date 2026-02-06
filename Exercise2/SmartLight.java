package Exercise2;

public class SmartLight extends SmartDevice implements Adjustable {
    
    private int brightness;

    public SmartLight(String deviceName) {
        super(deviceName);
        this.brightness = 0;
    }

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            activeDevicesCount++;
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            activeDevicesCount--;
        }
    }

    @Override
    public void setLevel(int level) {
        if (isOn) {
            if (level >= 0 && level <= 100){
                brightness = level;
            }
        } else {
            System.out.println("Cannot adjust: Device is OFF.");
        }
    }

    @Override
    public void performSelfDiagnostic() {
        System.out.println("Checking LED health...");
    }
}
