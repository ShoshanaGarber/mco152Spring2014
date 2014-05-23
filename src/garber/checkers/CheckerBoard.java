package garber.checkers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of a game of Checkers should match
 * http://simple.wikipedia.org/wiki/Checkers
 * 
 * How to play Checkers: https://www.youtube.com/watch?v=SuQY1_fCVsA
 */
public class CheckerBoard {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	private final Piece[][] board;

	public CheckerBoard() {
		this.board = new Piece[HEIGHT][WIDTH];
	}

	public Piece getPiece(final int x, final int y) {
		return board[y][x];
	}

	public void setPiece(final int x, final int y, final Piece piece) {
		board[y][x] = piece;
	}

	public void removePiece(final int x, final int y) {
		setPiece(x, y, null);
	}

	/**
	 * Returns true if the x,y coordinate is within the 8x8 board, otherwise
	 * false
	 */
	public boolean isOnBoard(final int x, final int y) {
		boolean onBoard = false;
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (y == i && x == j) {
					onBoard = true;
					break;
				}
			}
		}
		return onBoard;

	}

	/**
	 * Returns true if the square is null, otherwise false
	 */
	public boolean isEmptySquare(final int x, final int y) {

		return getPiece(x, y) == null;

	}

	/**
	 * Removes all pieces from the board
	 */
	public void clear() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				removePiece(i, j);

			}
		}
	}

	/**
	 * Sets the board to a starting configuration
	 */
	public void resetNewGame() {
		clear();
		setPiece(1, 0, Piece.WHITE_MAN);
		setPiece(3, 0, Piece.WHITE_MAN);
		setPiece(5, 0, Piece.WHITE_MAN);
		setPiece(7, 0, Piece.WHITE_MAN);
		setPiece(0, 1, Piece.WHITE_MAN);
		setPiece(2, 1, Piece.WHITE_MAN);
		setPiece(4, 1, Piece.WHITE_MAN);
		setPiece(6, 1, Piece.WHITE_MAN);
		setPiece(1, 2, Piece.WHITE_MAN);
		setPiece(3, 2, Piece.WHITE_MAN);
		setPiece(5, 2, Piece.WHITE_MAN);
		setPiece(7, 2, Piece.WHITE_MAN);

		setPiece(0, 5, Piece.RED_MAN);
		setPiece(2, 5, Piece.RED_MAN);
		setPiece(4, 5, Piece.RED_MAN);
		setPiece(6, 5, Piece.RED_MAN);
		setPiece(1, 6, Piece.RED_MAN);
		setPiece(3, 6, Piece.RED_MAN);
		setPiece(5, 6, Piece.RED_MAN);
		setPiece(7, 6, Piece.RED_MAN);
		setPiece(0, 7, Piece.RED_MAN);
		setPiece(2, 7, Piece.RED_MAN);
		setPiece(4, 7, Piece.RED_MAN);
		setPiece(6, 7, Piece.RED_MAN);

	}

	@Override
	/**
	 * Returns a String representation of the board. Each row of the board should be on it's own line.
	 * A dash "-" represents an empty square. Pieces should be displayed using the .toString() method
	 * of the piece class.
	 */
	public String toString() {
		StringBuilder board = new StringBuilder();
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (getPiece(j, i) == null) {
					board.append("-");
				} else {
					board.append(getPiece(j, i));
				}
			}
			board.append("\n");
		}
		return board.toString();
	}

	/**
	 * Do the Move, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. If the piece is now on their "King's Row", then promote the piece
	 * should be promoted to a King
	 */
	public void execute(final Move move) {

		setPiece(move.getX2(), move.getY2(),
				getPiece(move.getX1(), move.getY1()));
		removePiece(move.getX1(), move.getY1());
		if (getPiece(move.getX2(), move.getY2()) == Piece.WHITE_MAN) {
			if (move.getY2() == 7) {
				setPiece(move.getX2(), move.getY2(), Piece.WHITE_KING);
			}
		} else {
			if (move.getY2() == 0) {
				setPiece(move.getX2(), move.getY2(), Piece.RED_KING);
			}
		}
	}

	/**
	 * Do the Jump, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. Remove the piece from captureX, captureY as well. If the piece is now
	 * on their "King's Row", then promote the piece should be promoted to a
	 * King
	 */
	public void execute(final Jump jump) {
		setPiece(jump.getX2(), jump.getY2(),
				getPiece(jump.getX1(), jump.getY1()));
		removePiece(jump.getX1(), jump.getY1());
		removePiece(jump.getCaptureX(), jump.getCaptureY());
		if (getPiece(jump.getX2(), jump.getY2()) == Piece.WHITE_MAN) {
			if (jump.getY2() == 7) {
				setPiece(jump.getX2(), jump.getY2(), Piece.WHITE_KING);
			}
		} else {
			if (jump.getY2() == 0) {
				setPiece(jump.getX2(), jump.getY2(), Piece.RED_KING);
			}
		}

	}

	/**
	 * Returns a list of all possible moves from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal move then
	 * return an empty list
	 */
	public List<Move> getMoves(final int x, final int y) {
		List<Move> listMoves = new ArrayList<Move>();
		if (!isEmptySquare(x, y) && isOnBoard(x, y)) {

			if (getPiece(x, y) == Piece.WHITE_MAN) {
				if (isOnBoard(x + 1, y + 1) && getPiece(x + 1, y + 1) == null) {
					listMoves.add(new Move(x, y, x + 1, y + 1));
				}
				if (isOnBoard(x - 1, y + 1) && getPiece(x - 1, y + 1) == null) {
					listMoves.add(new Move(x, y, x - 1, y + 1));
				}
			} else if (getPiece(x, y) == Piece.RED_MAN) {
				if (isOnBoard(x - 1, y - 1) && getPiece(x - 1, y - 1) == null) {
					listMoves.add(new Move(x, y, x - 1, y - 1));
				}
				if (isOnBoard(x + 1, y - 1) && getPiece(x + 1, y - 1) == null) {
					listMoves.add(new Move(x, y, x + 1, y - 1));
				}
			} else if (getPiece(x, y).isKing()) {
				if (isOnBoard(x + 1, y + 1) && getPiece(x + 1, y + 1) == null) {
					listMoves.add(new Move(x, y, x + 1, y + 1));
				}
				if (isOnBoard(x + 1, y - 1) && getPiece(x + 1, y - 1) == null) {
					listMoves.add(new Move(x, y, x + 1, y - 1));
				}
				if (isOnBoard(x - 1, y - 1) && getPiece(x - 1, y - 1) == null) {
					listMoves.add(new Move(x, y, x - 1, y - 1));
				}
				if (isOnBoard(x - 1, y + 1) && getPiece(x - 1, y + 1) == null) {
					listMoves.add(new Move(x, y, x - 1, y + 1));
				}
			}

		}
		return listMoves;

	}

	/**
	 * Returns a list of all possible jumps from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal jump then
	 * return an empty list
	 */
	public List<Jump> getJumps(final int x, final int y) {
		List<Jump> listJumps = new ArrayList<Jump>();
		if (!isEmptySquare(x, y) && isOnBoard(x, y)) {
			if (getPiece(x, y) == Piece.WHITE_MAN) {
				if (getPiece(x + 2, y + 2) == null && isOnBoard(x + 2, y + 2)
						&& getPiece(x + 1, y + 1) != null
						&& getPiece(x + 1, y + 1).isColor(Color.RED)) {
					listJumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
				}
				if (getPiece(x - 2, y + 2) == null && isOnBoard(x - 2, y + 2)
						&& getPiece(x - 1, y + 1) != null
						&& getPiece(x - 1, y + 1).isColor(Color.RED)) {
					listJumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
				}
			} else if (getPiece(x, y) == Piece.RED_MAN) {
				if (getPiece(x - 2, y - 2) == null && isOnBoard(x - 2, y - 2)
						&& getPiece(x - 1, y - 1) != null
						&& getPiece(x - 1, y - 1).isColor(Color.WHITE)) {
					listJumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
				}
				if (getPiece(x + 2, y - 2) == null && isOnBoard(x + 2, y - 2)
						&& getPiece(x + 1, y - 1) != null
						&& getPiece(x + 1, y - 1).isColor(Color.WHITE)) {
					listJumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
				}

			} else if (getPiece(x, y).isKing()) {
				if (getPiece(x + 2, y + 2) == null
						&& isOnBoard(x + 2, y + 2)
						&& getPiece(x + 1, y + 1) != null
						&& getPiece(x + 1, y - 1).getColor() != getPiece(x, y)
								.getColor()) {
					listJumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
				}
				if (getPiece(x - 2, y + 2) == null
						&& isOnBoard(x - 2, y + 2)
						&& getPiece(x - 1, y + 1) != null
						&& getPiece(x - 1, y + 1).getColor() != getPiece(x, y)
								.getColor()) {
					listJumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
				}
				if (getPiece(x - 2, y - 2) == null
						&& isOnBoard(x - 2, y - 2)
						&& getPiece(x - 1, y - 1) != null
						&& getPiece(x - 1, y - 1).getColor() != getPiece(x, y)
								.getColor()) {
					listJumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
				}
				if (getPiece(x + 2, y - 2) == null
						&& isOnBoard(x + 2, y - 2)
						&& getPiece(x + 1, y - 1) != null
						&& getPiece(x + 1, y - 1).getColor() != getPiece(x, y)
								.getColor()) {
					listJumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
				}
			}
		}
		return listJumps;

	}

}
