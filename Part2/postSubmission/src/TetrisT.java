/**
 * 
 * This class represents the tetris piece in T shape, extends TetrisPiece
 * 
 * @author Anh Pham
 * @version Oct 25th
 */
public class TetrisT extends TetrisPiece 
{
	/**
	 * Constrcutor of the piece
	 */
	public TetrisT() 
	{
		boolean[][][] filled = 
			{
				{ 
					{ false, false, false, false },
					{ false, true, false, false },
					{ true, true, true, false },
					{ false, false, false, false } 
				},

				{ 
					{ true, false, false, false }, 
					{ true, true, false, false },
					{ true, false, false, false },
					{ false, false, false, false }
				},

				{ 
					{ true, true, true, false },
					{ false, true, false, false },
					{ false, false, false, false },
					{ false, false, false, false } 
				},

				{ 
					{ false, true, false, false },
					{ true, true, false, false },
					{ false, true, false, false },
					{ false, false, false, false }
				} 
			};
		// assign this array value 
		filledSquares = filled;
	}
}
