package garber.mtamap;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class TripsTest {

	@Test
	public void testConstructor() throws IOException {
		new Trips();
	}

	@Test
	public void testGetTrip() throws Exception {
		final Trips trips = new Trips();
		Assert.assertNotNull("shapeId = 1..S03R not found",
				trips.getTrip("1..S03R"));
	}

}
