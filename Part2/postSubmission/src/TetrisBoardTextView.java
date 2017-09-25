/**
 * This class creates a String view of the Tetris Board
 * 
 * @author Anh Pham
 * @version Oct 25th
 *
 */
public class TetrisBoardTextView 
{
	// The Tetris board object
	public TetrisBoard board;

	/**
	 * Constructor Tetris Board text view
	 * @param board the tetris board
	 */
	public TetrisBoardTextView(TetrisBoard board) 
	{
		this.board = board;
	}

	/**
	 * Get the string version of the board
	 * @return the board strings
	 */
	public String getStringBoard() 
	{
		// initialize the board string
		String stringBoard = "";
		
		// create the dash line which equals to number of cols
		for (int i = 0; i < board.getNumCols(); i++) 
		{
			stringBoard = stringBoard + "-";
		}
		
		// a new line after the dash line
		stringBoard = stringBoard + "\n";
		
		// loop through the rows and columns of the board
		for (int row = 0; row < board.getNumRows(); row++) 
		{
			for (int col = 0; col < board.getNumCols(); col++) 
			{
				// if the board has block at that position
				if (board.hasBlock(row, col)) 
				{
					// fill the string with "x" which is the piece/ block
					stringBoard = stringBoard + "x";
				} 
				else 
				{
					// if there is no block then don't insert anything
					stringBoard = stringBoard + " ";
				}
			}
			
			// a new line before the dash line
			stringBoard = stringBoard + "\n";
		}
		
		// create the dash line which equals to number of cols
		for (int i = 0; i < board.getNumCols(); i++) 
		{
			stringBoard = stringBoard + "-";
		}
		// a new line after the dash line
		stringBoard = stringBoard + "\n";

		// return the board string
		return stringBoard;
	}
}
