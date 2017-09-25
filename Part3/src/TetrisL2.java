/**
 * This class represents the tetris piece in L shape version 2, extends TetrisPiece
 * 
 * @author Anh Pham
 * @version Oct 25th
 *
 */
public class TetrisL2 extends TetrisPiece 
{
	/**
	 * Constructor of the piece
	 */
	public TetrisL2() 
	{
		boolean[][][] filled = 
			{
				{ 
					{ true, false, false, false },
					{ true, true, true, false },
					{ false, false, false, false },
					{ false, false, false, false } 
				},

				{ 
					{ true, true, false, false }, 
					{ true, false, false, false },
					{ true, false, false, false },
					{ false, false, false, false } 
				},

				{ 
					{ true, true, true, false }, 
					{ false, false, true, false },
					{ false, false, false, false },
					{ false, false, false, false } 
				},

				{ 
					{ false, true, false, false }, 
					{ false, true, false, false },
					{ true, true, false, false },
					{ false, false, false, false } 
					} 
			};
		
		// assign this array value 
		filledSquares = filled;
	}
}
