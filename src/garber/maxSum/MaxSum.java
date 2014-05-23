package garber.maxSum;

import java.util.Scanner;

public class MaxSum {

	private int[][] matrix;
	private int width;
	private int height;
	private int maxSum;

	public MaxSum() {

	}

	public void setUpMatrix(int n) {
		height = n;
		width = n;
		matrix = new int[height][width];
	}

	public void addNumber(Scanner inputNumbers) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {

				matrix[i][j] = inputNumbers.nextInt();

			}
		}

	}

	public int getMaxSum() {
		maxSum = Integer.MIN_VALUE;

		for (int rowStart = 0; rowStart < width; rowStart++) {
			for (int colStart = 0; colStart < width; colStart++) {
				for (int rowEnd = 0; rowEnd < width; rowEnd++) {
					for (int colEnd = 0; colEnd < width; colEnd++) {

						int sum = 0;
						for (int row = rowStart; row <= rowEnd; row++) {
							for (int col = colStart; col <= colEnd; col++) {
								sum += matrix[row][col];
							}
						}
						if (sum > maxSum) {
							maxSum = sum;

						}
					}
				}
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		MaxSum maxSum = new MaxSum();
		Scanner input = new Scanner(System.in);
		System.out
				.println("Enter the size of matrix, followed by the numbers:");
		int n = input.nextInt();
		maxSum.setUpMatrix(n);
		maxSum.addNumber(input);

		System.out.println(maxSum.getMaxSum());

	}
}