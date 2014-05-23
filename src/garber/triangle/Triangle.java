package garber.triangle;

public class Triangle {

	private int height;

	public Triangle(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		StringBuilder triangle = new StringBuilder();
		char blank = ' ';
		int x = 1;

		int numBlanks = 0;

		for (int row = 1; row <= height - 1; row++) {

			numBlanks = height - row;
			int printedBlanks = 0;
			while (printedBlanks < numBlanks) {
				triangle.append(blank);
				printedBlanks++;
			}

			for (int print = 0; print < x; print++) {
				if (print == 0 || print == x - 1) {
					triangle.append("*");
				} else {
					triangle.append(" ");
				}
			}
			triangle.append("\n");
			x += 2;

		}

		for (int stars = 0; stars < (height * 2) - 1; stars++) {
			triangle.append("*");
		}

		return triangle.toString();
	}

}
