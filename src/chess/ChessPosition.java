package chess;

import boardgame.Position;
import chess.exceptions.ChessException;

public class ChessPosition {

	private int row;	
	private char column;
	
	public ChessPosition(int row, char column) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Erro na posição de xadrez: valores aceitos vão de a1 até h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition(8 - position.getRow(), (char) ('a' - position.getColumn()));
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
