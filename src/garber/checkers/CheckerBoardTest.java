package garber.checkers;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CheckerBoardTest {

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringOnEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		final String expected = "--------\n" + "--------\n" + "--------\n"
				+ "--------\n" + "--------\n" + "--------\n" + "--------\n"
				+ "--------\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringAfterNewGame() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		final String expected = "-w-w-w-w\n" + "w-w-w-w-\n" + "-w-w-w-w\n"
				+ "--------\n" + "--------\n" + "r-r-r-r-\n" + "-r-r-r-r\n"
				+ "r-r-r-r-\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Test that isOnBoard() returns the correct result for different xs and ys
	 */
	public void testIsOnBoard() {
		final CheckerBoard board = new CheckerBoard();

		Assert.assertFalse(board.isOnBoard(9, 2));
	}

	@Test
	/**
	 * Test that isEmptySquare() returns the correct result before and after setPiece() is called
	 */
	public void testIsEmptySquare() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 4, Piece.WHITE_MAN);
		board.removePiece(5, 4);
		Assert.assertTrue(board.isEmptySquare(5, 4));
	}

	@Test
	/**
	 * Given an board with pieces, test that calling clear() clears the board
	 */
	public void testClear() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 1, Piece.WHITE_MAN);
		board.setPiece(6, 3, Piece.RED_MAN);
		board.setPiece(5, 2, Piece.WHITE_MAN);
		board.clear();
		final String expected = "--------\n" + "--------\n" + "--------\n"
				+ "--------\n" + "--------\n" + "--------\n" + "--------\n"
				+ "--------\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());

	}

	@Test
	/**
	 * Test that the board is in the correct configuration after
	 * resetNewGame() is called
	 */
	public void testResetNewGame() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(1, 0));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(3, 0));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(5, 0));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(7, 0));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(0, 1));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(2, 1));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(4, 1));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(6, 1));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(1, 2));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(3, 2));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(5, 2));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(7, 2));

		Assert.assertEquals(Piece.RED_MAN, board.getPiece(0, 5));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(2, 5));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(4, 5));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(6, 5));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(1, 6));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(3, 6));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(5, 6));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(7, 6));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(0, 7));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(2, 7));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(4, 7));
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(6, 7));
	}

	@Test
	/**
	 * Test execute(Move) moves a piece from one square to the other
	 */
	public void testMove() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 1, Piece.WHITE_MAN);
		board.execute(new Move(2, 1, 3, 3));
		Assert.assertEquals(null, board.getPiece(2, 1));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(3, 3));

	}

	@Test
	/**
	 * Test execute(Move) promotes a WHITE_MAN to a WHITE_KING when moving to the 8th row
	 */
	public void testMovePromoteToWhiteKing() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(6, 6, Piece.WHITE_MAN);
		Move move = new Move(6, 6, 7, 7);
		board.execute(move);
		Assert.assertEquals(Piece.WHITE_KING, board.getPiece(7, 7));

	}

	@Test
	/**
	 * Test execute(Move) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testMovePromoteToRedKing() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(6, 1, Piece.RED_MAN);
		Move move = new Move(6, 1, 7, 0);
		board.execute(move);
		Assert.assertEquals(Piece.RED_KING, board.getPiece(7, 0));
	}

	@Test
	/**
	 * Test execute(Jump) moves a piece from one square to another AND removes the piece that was jumped
	 */
	public void testJump() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 0, Piece.RED_MAN);
		board.setPiece(1, 1, Piece.WHITE_MAN);
		Jump jump = new Jump(0, 0, 1, 1, 2, 2);
		board.execute(jump);
		Assert.assertEquals(Piece.RED_MAN, board.getPiece(2, 2));
		Assert.assertEquals(null, board.getPiece(1, 1));
	}

	@Test
	/**
	 * Test execute(Jump) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testJumpPromoteToRedKing() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 2, Piece.RED_MAN);
		Jump jump = new Jump(2, 2, 1, 1, 0, 0);
		board.execute(jump);
		Assert.assertEquals(Piece.RED_KING, board.getPiece(0, 0));
	}

	@Test
	/**
	 * Test execute(Jump) promotes a WHITE_MAN to a WHITE_KING when moving to the 1st row
	 */
	public void testJumpPromoteToWhiteKing() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(6, 6, Piece.WHITE_MAN);
		Jump jump = new Jump(6, 6, 5, 5, 7, 7);
		board.execute(jump);
		Assert.assertEquals(Piece.WHITE_KING, board.getPiece(7, 7));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct number of Move objects when called on an empty square
	 */
	public void testGetMovesForEmptySquare() {
		final CheckerBoard board = new CheckerBoard();
		List<Move> list = board.getMoves(1, 1);
		Assert.assertEquals(0, list.size());

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedManInMiddleOfEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.RED_MAN);
		List<Move> list = board.getMoves(3, 4);
		Assert.assertEquals(new Move(3, 4, 2, 3), list.get(0));
		Assert.assertEquals(new Move(3, 4, 4, 3), list.get(1));

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedKingInMiddleOfEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.RED_KING);
		List<Move> list = board.getMoves(3, 4);
		Assert.assertEquals(new Move(3, 4, 4, 5), list.get(0));
		Assert.assertEquals(new Move(3, 4, 4, 3), list.get(1));
		Assert.assertEquals(new Move(3, 4, 2, 3), list.get(2));
		Assert.assertEquals(new Move(3, 4, 2, 5), list.get(3));

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteManInMiddleOfEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 3, Piece.WHITE_MAN);
		List<Move> list = board.getMoves(2, 3);
		Assert.assertEquals(new Move(2, 3, 3, 4), list.get(0));
		Assert.assertEquals(new Move(2, 3, 1, 4), list.get(1));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteKingInMiddleOfEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 3, Piece.WHITE_KING);
		List<Move> list = board.getMoves(2, 3);
		Assert.assertEquals(new Move(2, 3, 3, 4), list.get(0));
		Assert.assertEquals(new Move(2, 3, 3, 2), list.get(1));
		Assert.assertEquals(new Move(2, 3, 1, 2), list.get(2));
		Assert.assertEquals(new Move(2, 3, 1, 4), list.get(3));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is surrounded in 4 directions and
	 * cannot move.
	 * This should be an empty List
	 */
	public void testGetMovesForRedKingWhenSurrounded() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.RED_KING);
		board.setPiece(4, 5, Piece.RED_MAN);
		board.setPiece(4, 3, Piece.WHITE_MAN);
		board.setPiece(2, 3, Piece.RED_MAN);
		board.setPiece(2, 5, Piece.RED_MAN);
		List<Move> list = board.getMoves(3, 4);
		Assert.assertEquals(0, list.size());
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (0,7) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt07() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 7, Piece.RED_KING);
		List<Move> list = board.getMoves(0, 7);
		Assert.assertEquals(new Move(0, 7, 1, 6), list.get(0));
		Assert.assertEquals(1, list.size());
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (7,0) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt70() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(7, 0, Piece.RED_KING);
		List<Move> list = board.getMoves(7, 0);
		Assert.assertEquals(new Move(7, 0, 6, 1), list.get(0));
		Assert.assertEquals(1, list.size());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on an empty square
	 */
	public void testGetJumpsForEmptySquare() {
		final CheckerBoard board = new CheckerBoard();
		List<Jump> list = board.getJumps(3, 4);
		Assert.assertEquals(0, list.size());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on square that does not have
	 * any possible jumps
	 */
	public void testGetJumpsForRedKingInMiddleOfEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.RED_KING);
		List<Jump> list = board.getJumps(3, 4);
		Assert.assertEquals(0, list.size());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct Jump objects when a King can jump in 4 directions
	 */
	public void testGetJumpsForRedKingWhenSurrounded() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.RED_KING);
		board.setPiece(4, 5, Piece.WHITE_MAN);
		board.setPiece(4, 3, Piece.WHITE_MAN);
		board.setPiece(2, 3, Piece.WHITE_MAN);
		board.setPiece(2, 5, Piece.WHITE_MAN);
		List<Jump> list = board.getJumps(3, 4);
		Assert.assertEquals(new Jump(3, 4, 4, 5, 5, 6), list.get(0));
		Assert.assertEquals(new Jump(3, 4, 2, 5, 1, 6), list.get(1));
		Assert.assertEquals(new Jump(3, 4, 2, 3, 1, 2), list.get(2));
		Assert.assertEquals(new Jump(3, 4, 4, 3, 5, 2), list.get(3));

	}

	@Test
	/**
	 * Test that getJumps() returns the returns the correct Jump objects when a Piece can jump in 2 directions
	 */
	public void testGetJumpsForRedManWhenSurrounded() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.RED_KING);
		board.setPiece(2, 3, Piece.WHITE_MAN);
		board.setPiece(4, 3, Piece.WHITE_MAN);
		List<Jump> list = board.getJumps(3, 4);
		Assert.assertEquals(new Jump(3, 4, 2, 3, 1, 2), list.get(0));
		Assert.assertEquals(new Jump(3, 4, 4, 3, 5, 2), list.get(1));
	}

}
