package garber.mtamap;

import java.awt.Color;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class RoutesTest {

	@Test
	public void testConstructor() throws IOException {
		new Routes();
	}

	@Test
	public void testGetColor() throws IOException {
		Routes routes = new Routes();
		Color color = routes.getColor("E");
		Color expected = Color.decode("#2850AD");
		Assert.assertEquals(color, expected);
	}

}
