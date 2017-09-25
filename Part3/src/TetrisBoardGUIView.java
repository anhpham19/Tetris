import java.awt.*;
import javax.swing.*;

/**
 * This class creates a GUI view of the Tetris Board
 * @author Anh Pham 
 * @version Oct 30th
 *
 */
public class TetrisBoardGUIView extends JComponent 
{
	// The Tetris board object 
	public TetrisBoard board;
	
	// line thickness for the outline of board and blocks
	public static final int LINE_THICKNESS = 4;
	
	/**
	 * Constructor of the Tetris board GUI view 
	 * @param board
	 */
	public TetrisBoardGUIView(TetrisBoard board) 
	{
		this.board = board;
	}
	
	/**
	 * Paint the Tetris game
	 */
	public void paint(Graphics g) 
	{
		// Convert graphic object to 2D graphic object
		Graphics2D g2 = (Graphics2D) g;

		// set the thicker line for the outline of board and blocks for appearance purpose
		g2.setStroke(new BasicStroke(LINE_THICKNESS));
		
		// compute the block size
		int blockSize = computeBlockSize();
		
		// paint the board out line
		paintBoardOutline(g2, blockSize);
		
		// loop through the array of rows and columns, paint the block for whichever grid has a block
		for (int row = 0; row < board.getNumRows(); row++) 
		{
			for (int col = 0; col < board.getNumCols(); col++) 
			{
				if (board.hasBlock(row, col)) 
				{
					paintBlock(g2, row, col, blockSize);
				}
			}
		}
	}
	
	/**
	 * Paint the board out line
	 * @param g the graphics
	 * @param blockSize the size of block
	 */
	private void paintBoardOutline(Graphics g, int blockSize) 
	{
		// set color black for the line
		g.setColor(Color.BLACK);
		
		// draw an empty rectangle at the top left of the window with the appropriate width and height
		g.drawRect(0, 0, blockSize * board.getNumCols(), blockSize * board.getNumRows());
	}

	/**
	 * Paint the block at grid row and grid column
	 * @param g the graphics
	 * @param row  grid row
	 * @param col grid column
	 * @param blockSize the size of the block
	 */
	private void paintBlock(Graphics g, int row, int col, int blockSize) 
	{
		// the x and y coordinate of the rectangle that fill the grid
		int xCoord = col * blockSize;
		int yCoord = row * blockSize;
		
		// Get the piece color of the board
		Color pieceColor = board.getPieceColor();
		
		// set that random color
		g.setColor(pieceColor);
		
		// Draw the inner rectangle for the block
		g.fillRect(xCoord, yCoord, blockSize, blockSize);
		
		// Set the color to black draw the outline of the rectangle of the block
		g.setColor(Color.BLACK);
		g.drawRect(xCoord, yCoord, blockSize, blockSize);

	}

	/**
	 * Compute the best block size for the current window width and height.
	 * @return the block size 
	 */
	private int computeBlockSize() 
	{
		// the width of the block is the window width divide by the number of columns
		int blockWidth = getWidth() / board.getNumCols();
		
		// the height of the block is the window width divide by the number of rows
		int blockHeight = getHeight() / board.getNumRows();
		
		// initialize the block size 
		int blockSize = 0;
		
		// compare the block width and height and return the smaller for appearance purpose 
		if (blockWidth > blockHeight) 
		{
			blockSize = blockHeight;
		} else 
		{
			blockSize = blockWidth;
		}
		return blockSize;
	}
}
