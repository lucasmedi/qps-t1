package services;

import classes.GameEntry;

/** Interface of classes for storing high scores in an array in non-decreasing order. 
 *   Format: [(<name>, <score>), (<name>, <score>) …]
 *   Example: [(John, 10), (Carol, 5), (Dan, 3)]
 */
public interface Scores {
	
	/** Returns a string representation of the high scores list */
	public String toString();

	/** Attempt to add a new score to the collection (if it is high enough) */
	public boolean add(GameEntry e);

	/** Remove and return the high score at index i */
	public GameEntry remove(int i) throws IndexOutOfBoundsException;

	/** Returns the capacity of the collection*/
	public int getCapacity();

	/** Returns the number of scores currently stored on the collection */
	public int getNumElements();

}
