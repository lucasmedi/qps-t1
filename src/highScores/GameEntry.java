
package highScores;

public class GameEntry {
	protected String name; // name of the person earning this score

	protected int score; // the score value

	/** Constructor to create a game entry 
	 * @throws Exception */
	public GameEntry(String n, int s) {
		name = n;
		s = score;		
	}

	/** Retrieves the name field */
	public String getName() {
		return name;
	}

	/** Retrieves the score field */
	public int getScore() {
		return score;
	}

	/** Returns a string representation of this entry */
	public String toString() {
		return "(" + name + ", " + score + ")";
	}
}