package garber.interview.UniqueNumbers;

import java.util.HashMap;
import java.util.Scanner;

public class UniqueNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10; i++) {
			int number = input.nextInt();
			if (numbers.containsKey(number)) {
				int value = numbers.get(number);
				numbers.put(number, value + 1);
			} else {
				numbers.put(number, 1);

			}

		}
		System.out.println(numbers);
	}

}
