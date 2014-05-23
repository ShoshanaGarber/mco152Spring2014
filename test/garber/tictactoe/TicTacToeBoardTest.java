package garber.tictactoe;

import org.junit.Assert;
import org.junit.Test;



public class TicTacToeBoardTest {

	@Test
	public void testIsNotFull() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
		ticTacToeBoard.setSquare(new Location(1, 1), Symbol.X);
		ticTacToeBoard.setSquare(new Location(0, 1), Symbol.O);
		boolean isFull = ticTacToeBoard.isFull();

		Assert.assertFalse(isFull);

	}

	@Test
	public void testIsFull() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
		ticTacToeBoard.setSquare(new Location(1, 1), Symbol.X);
		ticTacToeBoard.setSquare(new Location(0, 1), Symbol.O);
		ticTacToeBoard.setSquare(new Location(0, 0), Symbol.X);
		ticTacToeBoard.setSquare(new Location(0, 2), Symbol.O);
		ticTacToeBoard.setSquare(new Location(1, 0), Symbol.X);
		ticTacToeBoard.setSquare(new Location(2, 1), Symbol.O);
		ticTacToeBoard.setSquare(new Location(2, 2), Symbol.X);
		ticTacToeBoard.setSquare(new Location(1, 2), Symbol.O);
		ticTacToeBoard.setSquare(new Location(2, 0), Symbol.X);
		boolean isFull = ticTacToeBoard.isFull();

		Assert.assertTrue(isFull);

	}

	@Test
	public void testSetSquare() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
		ticTacToeBoard.setSquare(new Location(0, 0), Symbol.X);
		Symbol actualSquare = ticTacToeBoard.getSquare(new Location(0, 0));
		Symbol expectedSquare = Symbol.valueOf("X");
		Assert.assertEquals(actualSquare, expectedSquare);

	}

	@Test
	public void testReset() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
		ticTacToeBoard.setSquare(new Location(1, 0), Symbol.O);
		ticTacToeBoard.setSquare(new Location(0, 1), Symbol.X);
		ticTacToeBoard.reset();
		Assert.assertNull(ticTacToeBoard.getSquare(new Location(1, 0)));
		Assert.assertNull(ticTacToeBoard.getSquare(new Location(0, 1)));

	}

}
