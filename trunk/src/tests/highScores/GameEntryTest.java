package tests.highScores;

import highScores.GameEntry;

import org.junit.Assert;
import org.junit.Test;

public class GameEntryTest {
	
	
	//Test Name
	@Test
	public void testNameSizeEqualZero(){
		GameEntry gameEntry = new GameEntry("", 100);
		
		Assert.assertTrue(gameEntry.getName().length() > 0);
	}
	
	@Test
	public void testGreatName(){
		GameEntry gameEntry = new GameEntry("user56789123456789101", 100);
		
		Assert.assertTrue(gameEntry.getName().length() < 20);
	}
	
	@Test
	public void testName(){
		GameEntry gameEntry = new GameEntry("user1", 100);
		
		Integer length = gameEntry.getName().length();
		
		Assert.assertTrue(length > 0 && length < 20);
	}
	
	//Test Score
	@Test
	public void testMaxScore(){
		GameEntry gameEntry = new GameEntry("user1", 1001);

		Assert.assertTrue(gameEntry.getScore() <= 1000);
	}
	
	@Test
	public void testNegativeScore(){
		GameEntry gameEntry = new GameEntry("user1", -1);

		Assert.assertTrue(gameEntry.getScore() > 0);
	}
	
	@Test
	public void testScore(){
		GameEntry gameEntry = new GameEntry("user1", 10);
 
		Assert.assertTrue(gameEntry.getScore() > 0 && gameEntry.getScore() <= 1000);
	}
	
	@Test
	public void testGetScore(){
		int score = 100;
		GameEntry gameEntry = new GameEntry("User1", score);
		
		Assert.assertEquals(score, gameEntry.getScore());
	}
	
	@Test
	public void testGetName(){
		String name = "Frodo";
		GameEntry gameEntry = new GameEntry(name, 10);
		
		Assert.assertTrue(name.equalsIgnoreCase(gameEntry.getName()));
	}
	
	@Test
	public void testToString(){
		GameEntry gameEntry = new GameEntry("user1", 100);
		String result = "(user1, 100)";
		
		Assert.assertEquals(gameEntry.toString(), result);
	}

}
