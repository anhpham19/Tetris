/**
 * This class represents the tetris piece in L shape version 1, extends TetrisPiece
 * 
 * @author Anh Pham
 * @version Oct 25th
 *
 */
public class TetrisL1 extends TetrisPiece 
{
	/**
	 * Constructor of the piece
	 */
	public TetrisL1() 
	{
		// the 3-D filled boolean for this piece
		boolean[][][] filled = 
			{
					{ 	
						{ false, false, true, false }, 
						{ true, true, true, false },
						{ false, false, false, false },
						{ false, false, false, false } 
					},

					{ 
						{ true, false, false, false }, 
						{ true, false, false, false },
						{ true, true, false, false },
						{ false, false, false, false } 
					},

					{ 
						{ true, true, true, false }, 
						{ true, false, false, false },
						{ false, false, false, false },
						{ false, false, false, false } 
					},

					{ 
						{ true, true, false, false }, 
						{ false, true, false, false },
						{ false, true, false, false },
						{ false, false, false, false } 
					} 
				};
		
		// assign this array value 
		filledSquares = filled;
	}
}
