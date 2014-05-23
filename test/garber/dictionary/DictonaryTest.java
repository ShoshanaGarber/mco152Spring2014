package garber.dictionary;

import java.io.FileNotFoundException;



import org.junit.Assert;
import org.junit.Test;

public class DictonaryTest {

	@Test
	public void testExists() throws FileNotFoundException {
		Dictionary dictionary = new Dictionary();

		boolean exists = dictionary.exists("PINNACES");
		Assert.assertTrue(exists);

	}

	@Test
	public void testNotExists() throws FileNotFoundException {
		Dictionary dictionary = new Dictionary();

		boolean exists = dictionary.exists("DD");
		Assert.assertFalse(exists);

	}

	public void testMixedCase() throws FileNotFoundException {
		Dictionary dictionary = new Dictionary();

		boolean exists = dictionary.exists("amU");
		Assert.assertTrue(exists);

	}

}
