package garber.homework2;

import org.junit.Assert;
import org.junit.Test;



public class Force2DTest {

	@Test
	public void testMagnitude() {
		Force2D force2D = new Force2D(1, 2);
		double magnitude = force2D.getMagnitude();
		double expected = 2.2361;
		Assert.assertEquals(expected, magnitude, .001);
	}

	@Test
	public void testAngle() {
		Force2D force2D = new Force2D(2, 2);
		double angle = force2D.getAngle();
		double expected = 45;
		Assert.assertEquals(expected, angle, .001);

	}

	@Test
	public void testAdd() {
		Force2D force2D = new Force2D(1, 1);
		Force2D newForce2D = force2D.add(new Force2D(1, 1));
		Force2D expected = new Force2D(2, 2);
		Assert.assertEquals(expected.getX(), newForce2D.getX(), .001);
		Assert.assertEquals(expected.getY(), newForce2D.getY(), .001);
	}

}
