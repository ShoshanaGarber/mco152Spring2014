package garber.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Evaluator {

	private final TicTacToeBoard ticTacToeBoard;
	private Symbol winner;
	private List<Location> listWinningSquares;

	public Evaluator(TicTacToeBoard ticTacToeBoard) {
		this.ticTacToeBoard = ticTacToeBoard;
		listWinningSquares = new ArrayList<Location>();
		winner = null;

	}

	public void evaluate() {
		Location l1;
		Location l2;
		Location l3;
		for (int x = 0; x < 3; x++) {

			l1 = new Location(x, 0);
			l2 = new Location(x, 1);
			l3 = new Location(x, 2);
			if (ticTacToeBoard.getSquare(l1) != null
					&& ticTacToeBoard.getSquare(l2) != null
					&& ticTacToeBoard.getSquare(l3) != null
					&& ticTacToeBoard.getSquare(l1) == ticTacToeBoard
							.getSquare(l2)
					&& ticTacToeBoard.getSquare(l2) == ticTacToeBoard
							.getSquare(l3)) {
				winner = ticTacToeBoard.getSquare(l1);
				listWinningSquares.add(l1);
				listWinningSquares.add(l2);
				listWinningSquares.add(l3);
				return;

			}
		}

		for (int y = 0; y < 3; y++) {
			l1 = new Location(0, y);
			l2 = new Location(1, y);
			l3 = new Location(2, y);
			if (ticTacToeBoard.getSquare(l1) != null
					&& ticTacToeBoard.getSquare(l2) != null
					&& ticTacToeBoard.getSquare(l3) != null
					&& ticTacToeBoard.getSquare(l1) == ticTacToeBoard
							.getSquare(l2)
					&& ticTacToeBoard.getSquare(l2) == ticTacToeBoard
							.getSquare(l3)) {
				winner = ticTacToeBoard.getSquare(l1);
				listWinningSquares.add(l1);
				listWinningSquares.add(l2);
				listWinningSquares.add(l3);
				return;

			}
		}

		l1 = new Location(0, 0);
		l2 = new Location(1, 1);
		l3 = new Location(2, 2);
		if (ticTacToeBoard.getSquare(l1) != null
				&& ticTacToeBoard.getSquare(l2) != null
				&& ticTacToeBoard.getSquare(l3) != null
				&& ticTacToeBoard.getSquare(l1) == ticTacToeBoard.getSquare(l2)
				&& ticTacToeBoard.getSquare(l2) == ticTacToeBoard.getSquare(l3)) {
			winner = ticTacToeBoard.getSquare(l1);
			listWinningSquares.add(l1);
			listWinningSquares.add(l2);
			listWinningSquares.add(l3);
			return;

		}

		l1 = new Location(0, 2);
		l2 = new Location(1, 1);
		l3 = new Location(2, 0);
		if (ticTacToeBoard.getSquare(l1) != null
				&& ticTacToeBoard.getSquare(l2) != null
				&& ticTacToeBoard.getSquare(l3) != null
				&& ticTacToeBoard.getSquare(l1) == ticTacToeBoard.getSquare(l2)
				&& ticTacToeBoard.getSquare(l2) == ticTacToeBoard.getSquare(l3)) {
			winner = ticTacToeBoard.getSquare(l1);
			listWinningSquares.add(l1);
			listWinningSquares.add(l2);
			listWinningSquares.add(l3);
			return;

		}

	}

	public Symbol getWinner() {

		return winner;

	}

	public void resetWinner() {// reset game
		winner = null;
		listWinningSquares = new ArrayList<Location>();
	}

	public List<Location> getWinningSquares() {
		if (winner == null) {
			return null;
		} else {
			return listWinningSquares;
		}

	}
}
