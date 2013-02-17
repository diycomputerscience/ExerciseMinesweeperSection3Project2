package com.diycomputerscience.minesweeper;

public class Board {

	public static final int MAX_ROWS = 6;
	public static final int MAX_COLS = 6;
	
	private Square squares[][];
	
	public Board() {
		this.squares = new Square[MAX_ROWS][MAX_COLS];
		for(int row=0; row<MAX_ROWS; row++) {
			for(int col=0; col<MAX_COLS; col++) {
				Square square = new Square();
				// TODO: Implement logic for determining if a Square is a mine
				squares[row][col] = square;
			}
		}
	}
	
	/**
	 * This method uncovers the specified Square
	 * @param row The row of the specified Square
	 * @param col The col of the specified Square
	 * @throws UncoveredMineException if the specified Square is a mine
	 */
	public void uncover(int row, int col) throws UncoveredMineException {
		// TOOD: Implement this method
	}
	
	/**
	 * This method marks the specified Square
	 * @param row The row of the specified Square
	 * @param col The col of the specified Square
	 */
	public void mark(int row, int col) {
		//TODO: Implement this method		
	}
	
	public Square[][] getSquares() {
		//TODO: Implement this method
		return this.squares;		
	}

}
