package garber.weather;

public class Main {

	private double temp;
	private int pressure;
	private int humidity;
	private double temp_min;

	@Override
	public String toString() {
		return "Main [temp=" + temp + ", pressure=" + pressure + ", humidity="
				+ humidity + ", temp_min=" + temp_min + ", temo_max="
				+ temo_max + "]";
	}

	public double getTemp() {
		return temp;
	}

	public int getPressure() {
		return pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public double getTemp_min() {
		return temp_min;
	}

	public double getTemo_max() {
		return temo_max;
	}

	private double temo_max;

}
