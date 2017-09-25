/**
 * This class is a Model: The TetrisPiece abstract class represents a piece made of 4 TetrisBlocks. 
 * It maintains 4 rotations (0 degrees, 90 degrees, 180 degrees and 270 degrees), 
 * with each being a 4x4 grid with certain filled squares.
 * @author Anh Pham
 * @version October 25th
 *
 */
public abstract class TetrisPiece 
{
	// 3 dimensional array maintaining which squares are filled first dimension is rotation (index 0: 0 degrees, index 1: 90 degrees, index 2: 180 degrees, index 3: 270 degrees)
	// second and third dimensions create 4x4 grid with true values indicating filled squares
	public boolean[][][] filledSquares;
	
	// Maintains the current rotation.
	public int pieceRotation;

	/**
	 * Constructor for a piece
	 */
	public TetrisPiece() 
	{
		// the piece is currently has rotation of 0
		pieceRotation = 0;
	}

	/**
	 * Rotate the piece clockwise by 90 degrees.
	 */
	public void rotateCW() 
	{
		// after the 3rd rotation, the piece comes to its initial rotation
		pieceRotation = ((pieceRotation + 1) % 4);
	}

	/**
	 * Rotate the piece counter-clockwise by 90 degrees.
	 */
	public void rotateCCW() 
	{
		// after the 3rd rotation, the piece comes to its initial rotation
		pieceRotation = ((pieceRotation + 3) % 4);
	}

	/**
	 * Get the rotation of this piece.
	 * @return 0, 90, 180, or 270 degrees.
	 */
	public int getPieceRotation() 
	{
		// return the degrees for each case 
		switch (pieceRotation) 
		{
		case 0:
			return 0;
		case 1:
			return 90;
		case 2:
			return 180;
		case 3:
			return 270;
		}
		return -1;
	}
	
	/**
	 * Checks if there is a TetrisBlock at the (row, col) position for the rotation rot, 
	 * where rot is 0, 90, 180 or 270 degrees.
	 * @param rot the TetrisPiece rotation value (should be 0, 90, 180, or 270)
	 * @param row the row within the TetrisPiece 4x4 grid
	 * @param col the col within the TetrisPiece 4x4 grid
	 * @return true if there is a block in the position for that rotation
	 */
	public boolean isFilled(int rot, int row, int col) 
	{
		// cases for the rotation
		int rotation = 0;

		switch (rot) {
		case 90:
			rotation = 1;
			break;
		case 180:
			rotation = 2;
			break;
		case 270:
			rotation = 3;
		}
		// return true if there is a block in the position for that rotation
		return filledSquares[rotation][row][col];
	}
}
