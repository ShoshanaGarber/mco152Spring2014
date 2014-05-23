package garber.homework;


import org.junit.Assert;
import org.junit.Test;

public class Circle2DTest {

	@Test
	public void testArea() {
		Circle2D circle2D = new Circle2D();
		double area = circle2D.getArea();
		double expected = 3.1415926535897932;
		Assert.assertEquals(expected, area, .001);
	}

	@Test
	public void testPerimeter() {

		Circle2D circle2D = new Circle2D();
		double perimeter = circle2D.getPerimeter();
		double expected = 6.2831853071795865;
		Assert.assertEquals(expected, perimeter, .001);
	}

	@Test
	public void testContainsXY() {
		Circle2D circle2D = new Circle2D(5, 5, 10);
		boolean contains = circle2D.contains(6, 6);
		Assert.assertTrue(contains);
	}

	@Test
	public void testContainsCircle() {
		Circle2D circle2D = new Circle2D();
		boolean contains = circle2D.contains(new Circle2D(.1, .4, .2));
		Assert.assertTrue(contains);

	}

	@Test
	public void testOverlaps() {
		Circle2D circle2D = new Circle2D();
		boolean overlaps = circle2D.overlaps(new Circle2D(1.5, 0, 2));
		Assert.assertTrue(overlaps);

	}

}
