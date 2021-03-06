/**
 * This class is the controller of the tetris game
 * @author Anh Pham
 * @version Oct 25
 *
 */
public class TetrisGame 
{
	// the variables that hold each movement type: right, left, down, clock-wise, counter-clock-wise
	public static final int RIGHT = 0;
	public static final int LEFT = 1;
	public static final int DOWN = 2;
	public static final int CW = 3;
	public static final int CCW = 4;
	
	// number of lines cleared
	public int numLines;
	
	// number of tetrises cleared
	public int numTetrises;
	
	// the tetris board
	public TetrisBoard tetrisBoard;

	/**
	 * Constructor of the Tetris game
	 */
	public TetrisGame() 
	{
		// no lines and tetrises cleared so far
		numLines = 0;
		numTetrises = 0;

		// create a new board
		tetrisBoard = new TetrisBoard();
	}
	
	/**
	 * Attempt to move tetris right, left, down, clock-wise and counter clock-wise 
	 * @param movement the type of movement for the tetris
	 */
	public void attemptMove(int movement) 
	{
		switch (movement) 
		{
		case 0:
			tetrisBoard.moveRight();
			break;
		case 1:
			tetrisBoard.moveLeft();
			break;
		// if cannot move down anymore, it's the end of the round
		case 2:
			if (!tetrisBoard.moveDown())
				endRound();
			break;
		case 3:
			tetrisBoard.rotateCW();
			break;
		case 4:
			tetrisBoard.rotateCCW();
			break;
		}
	}

	/**
	 * Performed when a piece cannot move down anymore. 
	 */
	private void endRound() 
	{	
		// When the piece has landed
		tetrisBoard.landPiece();
		
		// Ends the round by checking for newly formed lines and adding a new piece.
		int numFoundLines = tetrisBoard.numberOfFormedLines();
		
		// if lines found equals 4 then the player "win" a tetris
		if (numFoundLines == 4) 
		{
			// update number of tetris found
		}
		
		// update the number of lines found
		numLines += numFoundLines;
		
		// add a new piece after clearing the tetris and lines
		tetrisBoard.addNewPiece();
	}
	
	/**
	 * get number of lines cleared
	 * @return number of lines cleared
	 */
	public int getNumLines() 
	{
		return numLines;
	}

	/**
	 * get number of tetrises found
	 * @return number of tetrises found
	 */
	public int getNumTetrises() 
	{
		return numTetrises;
	}
	
	/**
	 * get the tetris board
	 * @return the tetris board
	 */
	public TetrisBoard getTetrisBoard() 
	{
		return tetrisBoard;
	}
}
