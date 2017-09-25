import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is the (text) controller: plays Tetris from the command line, printing the game after each move.
 * @author Anh Chau Pham
 * @version Oct 25th
 *
 */
public class TetrisGameTextController 
{
	// the tetris game controller
	public TetrisGame game;
	
	// the tetris board view
	public TetrisBoardTextView view;

	/**
	 * Constructor of the Text controller
	 */
	public TetrisGameTextController() 
	{
		// create a new game
		game = new TetrisGame();
		
		// get the board
		TetrisBoard board = game.getTetrisBoard();
		
		// create a new board text view
		view = new TetrisBoardTextView(board);

		// refresh the board display 
		refreshDisplay();
		
		// read the input from the command line
		readInput();
	}
	
	/**
	 * Get input from the user, looping until the user types "Quit".
	 */
	private void readInput() 
	{
		// Create a new buffer reader object 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		try 
		{
			// create a string object to read the command line
			String line;

			do 
			{
				// Print out the instructions
				System.out.println("Please enter a move (l,r,d,z,x) or type Quit to end.");

				// read the command line 
				line = in.readLine();
				
				// the line entered
				moveEntered(line);
				
				// refresh the display 
				refreshDisplay();
			} 
			
			// all of the above happen if the user does not type quit
			while (!line.equals("Quit"));

		} 
		
		//catch exception
		catch (IOException excp) 
		{
			excp.printStackTrace();
		}
	}

	/**
	 * Print text view of the game.
	 */
	private void refreshDisplay() 
	{
		// First, print the number of tetrises cleared.
		System.out.println("Number of Tetrises cleared: " + game.getNumTetrises());

		// Second, print the number of lines cleared. 
		System.out.println("Number of lines cleared: " + game.getNumLines());

		// Then, print the tetris board.
		System.out.println(view.getStringBoard());
	}
	
	/**
	 * Read the move entered by the keyboard
	 * @param letter the letter key the user types in
	 */
	private void moveEntered(String letter) 
	{
		// r for moving right
		if (letter.equals("r")) 
		{
			game.attemptMove(0);
		} 
		// l for moving left
		else if (letter.equals("l")) 
		{
			game.attemptMove(1);
		} 
		// d for moving down
		else if (letter.equals("d")) 
		{
			game.attemptMove(2);
		} 
		// z for rotate CW
		else if (letter.equals("z")) 
		{
			game.attemptMove(3);
		} 
		// x for rotate CCW
		else if (letter.equals("x")) 
		{
			game.attemptMove(4);
		}
		// invalid move warning 
		else 
		{
			System.out.println("Please enter a valid move!");
		}
	}

	/**
	 * Start the game
	 * @param args the String argument
	 */
	public static void main(String[] args) 
	{
		new TetrisGameTextController();
	}
}
