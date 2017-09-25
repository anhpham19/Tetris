/**
 * A Tetromino defines a tetris piece. It is a a geometric shape 
 * composed of four squares, connected orthogonally. 
 * This is the super class for each specific tetromino shape
 **/ 
 public class Tetrominos
 {
	// an array of Booleans to check if the square if filled
	boolean [] isFilled;
	
	/**
	 * Constructor
	 **/
	public Tetrominos()
	{
	}
	
	/**
	 * Rotate the tetrominos clock-wise
	 **/
	public void rotateClock()
	{	
	}
	
	/** 
	 * Rotate the tetrominos counter clock-wise
	 **/ 
	public void rotateCounter()
	{
	}
	
	/**
	 * check if the square is filled
	 **/
	public boolean isFilled ()
	{
		return false;
	}
 }
 