package workshop05.mobile;

public class Otab extends Mobile{
	public Otab() {
		
	}
	public Otab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}
	@Override
	public int operate(int time) {
		setBatterySize(getBatterySize() - 12 * time);
		return (this.getBatterySize() - 12 * time);
	}
	@Override
	public int charge(int time) {
		setBatterySize(getBatterySize() + 8 * time);
		return (this.getBatterySize() + 8 * time);
	}
}
