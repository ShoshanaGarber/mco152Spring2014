package garber.stocks;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class StocksTest {

	@Test
	public void testContains() throws ParseException, IOException {

		AmexData amex = new AmexData();
		Assert.assertTrue(amex.contains("AIP"));

	}

	@Test
	public void testGetPricesSymbol() throws IOException, ParseException {
		AmexData amex = new AmexData();
		List<DailyPrice> list = amex.getPrices("AIP");
		Assert.assertEquals(6412, list.size());

		Assert.assertNotNull(list);
		Assert.assertNotSame(0, list.size());

	}

	@Test
	public void testGetPricesDates() throws IOException, ParseException {
		AmexData amex = new AmexData();
		List<DailyPrice> list = amex.getPrices("AIP", new Date(2010 - 2 - 1),
				new Date(2010 - 2 - 8));
		Assert.assertNotNull(list);
		Assert.assertNotSame(0, list.size());

	}
}
