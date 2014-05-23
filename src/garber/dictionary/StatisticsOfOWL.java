package garber.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class StatisticsOfOWL {

	private final String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H",
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
			"V", "W", "X", "Y", "Z" };
	private final Map<String, String> wordList;

	public StatisticsOfOWL() throws FileNotFoundException {
		wordList = new HashMap<String, String>();
		Scanner inputFile = new Scanner(new File("./OWL.txt"));

		while (inputFile.hasNext()) {

			wordList.put(inputFile.next(), inputFile.nextLine());
		}

		inputFile.close();
	}

	public Iterator<String> iterator() {
		return wordList.keySet().iterator();
	}

	public void collectStatistics() {

		String word;
		int numAccurances;
		int numAccurancesPerWord;
		double statistics;
		boolean accurance;
		DecimalFormat formatter = new DecimalFormat("##.00");

		for (int j = 0; j < alphabet.length; j++) {
			numAccurances = 0;
			numAccurancesPerWord = 0;
			statistics = 0;

			for (int k = 0; k < wordList.size(); k++) {
				word = wordList.get(k);
				accurance = false;

				for (int i = 0; i < word.length(); i++) {
					if (String.valueOf(word.charAt(i)).equals(alphabet[j])) {
						numAccurances++;
						accurance = true;
					}
				}
				if (accurance) {
					numAccurancesPerWord++;
				}
			}

			statistics = numAccurancesPerWord * 100.0 / wordList.size();

			System.out.println(alphabet[j] + "\t" + numAccurances + "\t"
					+ formatter.format(statistics) + "%");
		}

	}

	public static void main(String[] args) {

		try {
			StatisticsOfOWL statistics = new StatisticsOfOWL();
			statistics.collectStatistics();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
