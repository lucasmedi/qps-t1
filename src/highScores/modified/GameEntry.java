
package highScores.modified;

public class GameEntry {
	protected String name; // name of the person earning this score

	protected int score; // the score value

	/** Constructor to create a game entry 
	 * @throws Exception */
	public GameEntry(String n, int s) throws Exception {
		if(n.length() == 0 || n.length() > 20 )
			throw new Exception("O campo nome não pode ser vazio e ultrapassar os 20 caracteres.");
		
		if(s < 0 || s > 1000)
			throw new Exception("O campo Score não pode ser negativo ou maior que 1000");

		name = n;
		score = s;		
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