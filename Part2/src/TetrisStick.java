/**
 * 
 * This class represents the tetris piece in Stick shape, extends TetrisPiece
 * 
 * @author Anh Pham
 * @version Oct 25th
 */
public class TetrisStick extends TetrisPiece
{
	/**
	 * Constrcutor of the piece
	 */
	public TetrisStick() 
	{
		boolean[][][] filled = 
			{
				{ 
					{ true, false, false, false }, 
					{ true, false, false, false },
					{ true, false, false, false },
					{ true, false, false, false }
				},

				{ 
					{ true, true, true, true }, 
					{ false, false, false, false },
					{ false, false, false, false },
					{ false, false, false, false }
				},

				{ 
					{ true, false, false, false }, 
					{ true, false, false, false },
					{ true, false, false, false },
					{ true, false, false, false } 
				},

				{
					{ true, true, true, true }, 
					{ false, false, false, false },
					{ false, false, false, false },
					{ false, false, false, false } 
				} 
			};
		// assign this array value 
		filledSquares = filled;
	}
}
