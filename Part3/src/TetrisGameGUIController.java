import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class is the controller for the GUI version. The user can play by
 * pressing on the keyboard.
 * 
 * @author Anh Pham
 * @version Oct 30
 *
 */
public class TetrisGameGUIController extends JPanel implements KeyListener 
{
	// The drop rate for the tetris pieces
	public static final int DEFAULT_DROP_RATE = 700;
	
	// The tetris  game controller
	public TetrisGame game;
	
	// The tetris GUI view
	public TetrisBoardGUIView view;
	
	// The labels for the lines cleared and tetris cleared
	public JLabel linesLabel, tetrisesLabel;
	
	// The timer for the game
	public Timer gameTimer;
	
	// Drop rate variable
	public int dropRate;

	/**
	 * Constructor for the GUI controller of the game
	 */
	public TetrisGameGUIController() 
	{
		// Create a Border layout manager for the whole board panel
		super(new BorderLayout());
		
		// Create new tetris game controller
		game = new TetrisGame();
		
		// create the view for the game
		createView();
		
		// create the score for the game
		createScore();
		
		// refresh the display
		refreshDisplay();
		
		// set focus for this game's input from the keyboard
		setFocusable(true);
		
		// add the key listen
		addKeyListener(this);
		
		// set the drop rate to the default drop rate
		dropRate = DEFAULT_DROP_RATE;
		
		// set up the timer
		setupTimer();
	}

	/** 
	 * Set up the timer for which each piece fells down the board
	 */
	private void setupTimer() 
	{	
		// create the game timer and move the piece down with that corresponding timer
		gameTimer = new Timer(dropRate, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				game.attemptMove(2);
				
				// refresh the display for each movement
				refreshDisplay();
			}
		});
		
		// start the game timer
		gameTimer.start();
	}
	
	/**
	 * Create the view for the GUI version
	 */
	private void createView() 
	{	
		// get the board from the game controller
		TetrisBoard board = game.getTetrisBoard();
		
		// create the voard view
		view = new TetrisBoardGUIView(board);
		
		// add the view to the center region of the border layout
		add(view, BorderLayout.CENTER);
	}

	/**
	 * Create the score records
	 */
	private void createScore() 
	{
		// create a panel just for scores, this panel is a grid layout contains 2 rows and 0 columns
		JPanel scorePanel = new JPanel(new GridLayout(2, 0));

		// create the lines cleared label 
		linesLabel = new JLabel();
		
		// add the line label into the score panel
		scorePanel.add(linesLabel);

		// create tetrises cleared label
		tetrisesLabel = new JLabel();
		
		// add the tetrises label into the score panel
		scorePanel.add(tetrisesLabel);
		
		// add the score panel into the north region of the border layout
		add(scorePanel, BorderLayout.NORTH);
	}

	/**
	 * Refresh the display after the user scores 
	 */
	public void refreshDisplay() 
	{
		// set a new score for lines cleared
		linesLabel.setText("Lines Cleared: " + game.getNumLines());

		// // set a new score for tetrises cleared
		tetrisesLabel.setText("Tetrises cleared: " + game.getNumTetrises());
		
		// repaint the view
		repaint();
	}

	/**
	 * Handle the key typed event.
	 */
	public void keyTyped(KeyEvent e) 
	{
	}

	/**
	 * Handle the key-released event.
	 */
	public void keyReleased(KeyEvent e) 
	{
	}
	
	/**
	 * Handle the key-pressed event.
	 * Move the pieces accordingly.
	 */
	public void keyPressed(KeyEvent e) 
	{
		// get the keycode from the key event
		int key = e.getKeyCode();

		// move the tetris pieces accordingly: right arrow for moving right, left arrow for left, down
		// arrow for down, x for clockwise rotate and z for counter-clockwise rotate 
		if (key == KeyEvent.VK_RIGHT) 
		{
			game.attemptMove(0);
		} else if (key == KeyEvent.VK_LEFT) 
		{
			game.attemptMove(1);
		} else if (key == KeyEvent.VK_DOWN)
		{
			game.attemptMove(2);
		} else if (key == KeyEvent.VK_X) 
		{
			game.attemptMove(3);
		} else if (key == KeyEvent.VK_Z) 
		{
			game.attemptMove(4);
		}

		// refresh the display after each move
		refreshDisplay();
	}

}