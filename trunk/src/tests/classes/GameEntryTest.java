package tests.classes;

import org.junit.Assert;
import org.junit.Test;

import classes.GameEntry;

public class GameEntryTest {
	
	
	@Test
	public void testNotEmptyName(){
		GameEntry gameEntry = new GameEntry("", 100);
		
		Assert.assertFalse(gameEntry.getName().isEmpty());
	}
	
	@Test
	public void testGreatName(){
		GameEntry gameEntry = new GameEntry("user56789123456789101", 100);
		
		Integer length = gameEntry.getName().length();
		
		Assert.assertTrue(length < 20);
	}
	
	@Test
	public void testName(){
		GameEntry gameEntry = new GameEntry("user1", 100);
		
		Integer length = gameEntry.getName().length();
		
		Assert.assertTrue(length < 20);
	}
	
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
	public void testToString(){
		GameEntry gameEntry = new GameEntry("user1", 100);
		String result = "(user1, 100)";
		
		Assert.assertEquals(gameEntry.toString(), result);
	}

}
