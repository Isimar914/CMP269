package Exercise2;

public abstract class SmartDevice implements Powerable {
    protected String deviceName;
    protected boolean isOn;
    protected static int activeDevicesCount = 0;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
        this.isOn = false;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            activeDevicesCount++;
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            activeDevicesCount--;
        }
    }

    public abstract void performSelfDiagnostic();
}
