package garber.morceCode;

import java.util.HashMap;
import java.util.StringTokenizer;

public class MorseCode {

	private final HashMap<String, String> morseCode = new HashMap<String, String>();

	private final String[] characters = { "A", "B", "C", "D", "E", "F", "G",
			"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9" };
	private final String[] code = { ".-", "-...", "-.-.", "-..", ".", "..-.",
			"--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
			".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
			"-.--", "--..", "-----", ".----", "..---", "...--", "....-",
			".....", "-....", "--...", "---..", "----." };

	public MorseCode() {
		for (int i = 0; i < characters.length; i++) {
			morseCode.put(characters[i], code[i]);
			morseCode.put(code[i], characters[i]);
		}

	}

	public String toMorseCode(String plainText) {
		StringBuilder morse = new StringBuilder();
		if (plainText != null) {
			for (int i = 0; i < plainText.length(); i++) {
				String character = Character.toString(plainText.charAt(i))
						.toUpperCase();
				if (" ".equals(character)) {
					morse.append("/ ");
				} else {
					morse.append(morseCode.get(character.toUpperCase()));
					morse.append(" ");
				}
			}

		} else {
			morse.append("");
		}
		return morse.toString().trim();
	}

	public String toPlainText(String morse) {
		StringBuilder plainText = new StringBuilder();
		if (morse != null) {
			StringTokenizer tokenizer = new StringTokenizer(morse, " ");
			while (tokenizer.hasMoreTokens()) {
				String morseLetter = String.valueOf(tokenizer.nextToken());
				if ("/".equals(morseLetter)) {
					plainText.append(" ");
				} else {
					plainText.append(morseCode.get(morseLetter));

				}

			}
		} else {
			plainText.append("");
		}
		return plainText.toString().toUpperCase();
	}

}
