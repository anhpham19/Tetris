/**
 * 
 * This class represents the tetris piece in S shape version 2, extends TetrisPiece
 * 
 * @author Anh Pham
 * @version Oct 25th
 */
public class TetrisS2 extends TetrisPiece 
{
	/**
	 * Constrcutor of the piece
	 */
	public TetrisS2()
	{
		// the 3-D filled boolean for this piece
		boolean[][][] filled = 
			{
				{ 
					{ false, true, false, false }, 
					{ true, true, false, false },
					{ true, false, false, false },
					{ false, false, false, false } 
				},

				{ 
					{ true, true, false, false },
					{ false, true, true, false },
					{ false, false, false, false },
					{ false, false, false, false } 
				},

				{ 
					{ false, true, false, false },
					{ true, true, false, false },
					{ true, false, false, false },
					{ false, false, false, false } 
				},

				{ 
					{ true, true, false, false },
					{ false, true, true, false },	
					{ false, false, false, false },
					{ false, false, false, false }
				} 
			};
		// assign this array value 
		filledSquares = filled;
	}
}
