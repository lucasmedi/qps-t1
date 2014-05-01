package classes;

public class GameEntry {
	
	private String name;
	private Integer score;
	
	public GameEntry(String name, Integer score) {
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	/** Returns a string representation of this entry 
	 *  Format: (<name>, <score>)
	 */
	public String toString() {
		return "("+name+","+score+")";
	}

}
