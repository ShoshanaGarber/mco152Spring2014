package garber.tictactoe;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EvaluatorTest {

	@Test
	public void testWinnerHorizontal() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();

		ticTacToeBoard.setSquare(new Location(1, 1), Symbol.X);
		ticTacToeBoard.setSquare(new Location(0, 1), Symbol.O);
		ticTacToeBoard.setSquare(new Location(0, 0), Symbol.O);
		ticTacToeBoard.setSquare(new Location(0, 2), Symbol.O);
		ticTacToeBoard.setSquare(new Location(1, 0), Symbol.X);
		ticTacToeBoard.setSquare(new Location(2, 0), Symbol.X);
		Evaluator eval = new Evaluator(ticTacToeBoard);
		eval.evaluate();
		Symbol winner = eval.getWinner();
		Symbol expectedWinner = Symbol.O;
		Assert.assertEquals(expectedWinner, winner);

	}

	@Test
	public void testWinnerVertical() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();

		ticTacToeBoard.setSquare(new Location(0, 0), Symbol.X);
		ticTacToeBoard.setSquare(new Location(0, 1), Symbol.O);
		ticTacToeBoard.setSquare(new Location(0, 2), Symbol.O);
		ticTacToeBoard.setSquare(new Location(1, 0), Symbol.X);
		ticTacToeBoard.setSquare(new Location(2, 0), Symbol.X);
		Evaluator eval = new Evaluator(ticTacToeBoard);
		eval.evaluate();
		Symbol winner = eval.getWinner();
		Symbol expectedWinner = Symbol.X;
		Assert.assertEquals(expectedWinner, winner);

	}

	@Test
	public void testWinnerDiagonalLeft() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();

		ticTacToeBoard.setSquare(new Location(0, 0), Symbol.X);
		ticTacToeBoard.setSquare(new Location(2, 0), Symbol.O);
		ticTacToeBoard.setSquare(new Location(1, 1), Symbol.X);
		ticTacToeBoard.setSquare(new Location(2, 2), Symbol.X);
		ticTacToeBoard.setSquare(new Location(0, 2), Symbol.O);
		Evaluator eval = new Evaluator(ticTacToeBoard);
		eval.evaluate();
		Symbol winner = eval.getWinner();
		Symbol expectedWinner = Symbol.X;
		Assert.assertEquals(expectedWinner, winner);

	}

	@Test
	public void testWinnerDiagonalRight() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();

		ticTacToeBoard.setSquare(new Location(0, 0), Symbol.X);
		ticTacToeBoard.setSquare(new Location(0, 2), Symbol.O);
		ticTacToeBoard.setSquare(new Location(2, 1), Symbol.X);
		ticTacToeBoard.setSquare(new Location(2, 2), Symbol.X);
		ticTacToeBoard.setSquare(new Location(1, 1), Symbol.O);
		ticTacToeBoard.setSquare(new Location(2, 0), Symbol.O);
		Evaluator eval = new Evaluator(ticTacToeBoard);
		eval.evaluate();
		Symbol winner = eval.getWinner();
		Symbol expectedWinner = Symbol.O;
		Assert.assertEquals(expectedWinner, winner);

	}

	@Test
	public void testlistWinningSquares() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();

		ticTacToeBoard.setSquare(new Location(1, 1), Symbol.X);
		ticTacToeBoard.setSquare(new Location(0, 1), Symbol.O);
		ticTacToeBoard.setSquare(new Location(0, 0), Symbol.O);
		ticTacToeBoard.setSquare(new Location(0, 2), Symbol.O);
		ticTacToeBoard.setSquare(new Location(1, 0), Symbol.X);
		ticTacToeBoard.setSquare(new Location(2, 0), Symbol.X);
		Evaluator eval = new Evaluator(ticTacToeBoard);
		eval.evaluate();
		List<Location> list = eval.getWinningSquares();
		Location expectedWinningSquare1 = new Location(0, 0);
		Location expectedWinningSquare2 = new Location(0, 1);
		Location expectedWinningSquare3 = new Location(0, 2);
		Assert.assertEquals(list.get(0).getX(), expectedWinningSquare1.getX());
		Assert.assertEquals(list.get(0).getY(), expectedWinningSquare1.getY());
		Assert.assertEquals(list.get(1).getX(), expectedWinningSquare2.getX());
		Assert.assertEquals(list.get(1).getY(), expectedWinningSquare2.getY());
		Assert.assertEquals(list.get(2).getX(), expectedWinningSquare3.getX());
		Assert.assertEquals(list.get(2).getY(), expectedWinningSquare3.getY());

	}

	@Test
	public void testNumberWinningSquares() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();

		ticTacToeBoard.setSquare(new Location(1, 1), Symbol.X);
		ticTacToeBoard.setSquare(new Location(0, 1), Symbol.O);
		ticTacToeBoard.setSquare(new Location(0, 0), Symbol.O);
		ticTacToeBoard.setSquare(new Location(0, 2), Symbol.O);
		ticTacToeBoard.setSquare(new Location(1, 0), Symbol.X);
		ticTacToeBoard.setSquare(new Location(2, 0), Symbol.X);
		Evaluator eval = new Evaluator(ticTacToeBoard);
		eval.evaluate();
		List<Location> list = eval.getWinningSquares();
		Assert.assertEquals(list.size(), 3);
	}

}
