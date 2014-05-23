package garber.homework;

public class Circle2D {
	private double x;
	private double y;
	private double radius;

	public Circle2D() {
		x = 0;
		y = 0;
		radius = 1;
	}

	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;

	}

	public double getArea() {
		double area = Math.PI * radius * radius;
		return area;
	}

	public double getPerimeter() {
		double perimeter = 2 * Math.PI * radius;
		return perimeter;
	}

	public boolean contains(double x2, double y2) {
		double distance = Math.sqrt((x2 - x) * (x2 - x))
				+ ((y2 - y) * (y2 - y));
		return distance < radius;
	}

	public boolean contains(Circle2D circle) {
		double distance = Math.sqrt((circle.getX() - x) * (circle.getX() - x))
				+ ((circle.getY() - y) * (circle.getY() - y));
		return (distance + circle.getRadius()) < radius;
	}

	public boolean overlaps(Circle2D circle) {

		double distance = Math.sqrt((circle.getX() - x) * (circle.getX() - x))
				+ ((circle.getY() - y) * (circle.getY() - y));
		return distance < (radius + circle.getRadius());
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

}
