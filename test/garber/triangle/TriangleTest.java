package garber.triangle;

import org.junit.Assert;
import org.junit.Test;



public class TriangleTest {

	@Test
	public void testTriangle3() {
		Triangle triangle = new Triangle(3);
		String aTriangle = triangle.toString();
		String expected = "  *" + "\n" + " * *" + "\n" + "*****";
		Assert.assertEquals(expected, aTriangle);
	}

	@Test
	public void testTriangle5() {
		Triangle triangle = new Triangle(5);
		String aTriangle = triangle.toString();
		String expected = "    *" + "\n" + "   * *" + "\n" + "  *   *" + "\n"
				+ " *     *" + "\n" + "*********";
		Assert.assertEquals(expected, aTriangle);
	}

	@Test
	public void testTriangle6() {
		Triangle triangle = new Triangle(6);
		String aTriangle = triangle.toString();
		String expected = "     *" + "\n" + "    * *" + "\n" + "   *   *"
				+ "\n" + "  *     *" + "\n" + " *       *" + "\n"
				+ "***********";
		Assert.assertEquals(expected, aTriangle);

	}

}
