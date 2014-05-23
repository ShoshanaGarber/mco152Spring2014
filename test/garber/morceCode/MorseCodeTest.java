package garber.morceCode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testAlphabetToMorseCode() {
		MorseCode morseCode = new MorseCode();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String code = morseCode.toMorseCode(alphabet);
		String expected = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";

		Assert.assertEquals(expected, code);

	}

	@Test
	public void testMorseCodeToAlphabet() {
		MorseCode morseCode = new MorseCode();
		String code = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";
		String alphabet = morseCode.toPlainText(code);
		String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		Assert.assertEquals(expected, alphabet);

	}

	@Test
	public void testCodeToAlphabetSpaces() {
		MorseCode morseCode = new MorseCode();
		String code = "-- --- .-. ... . / -.-. --- -.. .";
		String alphabet = morseCode.toPlainText(code);
		String expected = "MORSE CODE";

		Assert.assertEquals(expected, alphabet);
	}

	@Test
	public void testAlphabetToCodeSpaces() {
		MorseCode morseCode = new MorseCode();
		String alphabet = "morse code";
		String code = morseCode.toMorseCode(alphabet);
		String expected = "-- --- .-. ... . / -.-. --- -.. .";

		Assert.assertEquals(expected, code);
	}

	@Test
	public void testNullAlphabetToCode() {
		MorseCode morseCode = new MorseCode();
		String alphabet = null;
		String code = morseCode.toMorseCode(alphabet);
		String expected = "";

		Assert.assertEquals(expected, code);
	}

	@Test
	public void testNullCodeToAlphabet() {
		MorseCode morseCode = new MorseCode();
		String code = null;
		String alphabet = morseCode.toMorseCode(code);
		String expected = "";

		Assert.assertEquals(expected, alphabet);

	}
}
