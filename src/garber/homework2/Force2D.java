package garber.homework2;

public class Force2D {

	private double x;
	private double y;

	public Force2D(double x, double y) {
		this.x = x;
		this.y = y;

	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getMagnitude() {
		double magnitude = Math.sqrt(x * x + y * y);
		return magnitude;
	}

	public double getAngle() {
		double radians = Math.atan2(y, x);
		double angle = Math.toDegrees(radians);
		return angle;
	}

	public Force2D add(Force2D force2D) {
		double sumX = this.x + force2D.getX();
		double sumY = this.y + force2D.getY();
		Force2D newForce2D = new Force2D(sumX, sumY);
		return newForce2D;
	}

}
