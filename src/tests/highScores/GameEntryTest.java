package tests.highScores;

import highScores.GameEntry;

import org.junit.Assert;
import org.junit.Test;

public class GameEntryTest {
	
	
	/*
	 * 
	 * 
	 * 
	 * Test Name
	 * 
	 * 
	 * 
	 * */
	@Test(expected= Exception.class)
	public void testNameSizeEqualZeroLI(){
		GameEntry gameEntry = new GameEntry("", 100);
	}
	
	@Test
	public void testNameSizeEqualOneLI(){
		GameEntry gameEntry = new GameEntry("a", 100);
		
		Assert.assertTrue(gameEntry.getName().length() > 0);
	}
	
	@Test
	public void testNameSizeEqualTwoLI(){
		GameEntry gameEntry = new GameEntry("ab", 100);
		
		Assert.assertTrue(gameEntry.getName().length() > 0);
	}
	
	@Test
	public void testNameLS(){
		GameEntry gameEntry = new GameEntry("user567891234567891", 1000);
		
		Integer length = gameEntry.getName().length();
		
		Assert.assertTrue(length > 0 && length <= 20);
	}
	
	@Test
	public void testNameLimitLS(){
		GameEntry gameEntry = new GameEntry("user5678912345678912", 1000);
		
		Integer length = gameEntry.getName().length();
		
		Assert.assertTrue(length > 0 && length <= 20);
	}
	
	@Test(expected = Exception.class)
	public void testGreatNameLS(){
		GameEntry gameEntry = new GameEntry("user56789123456789123", 100);
		
	}
	
	/*
	 * 
	 * 
	 * 
	 * Test Score
	 * 
	 * 
	 * 
	 * */
	 
	@Test(expected= Exception.class)
	public void testNegativeScoreLI(){
		GameEntry gameEntry = new GameEntry("user1", -1);
	}
	
	@Test
	public void testGetScoreZeroLI(){
		int score = 0;
		GameEntry gameEntry = new GameEntry("User1", score);
		
		Assert.assertEquals(score, gameEntry.getScore());
	}
	
	@Test
	public void testScoreLI(){
		int score = 1;
		GameEntry gameEntry = new GameEntry("User1", score);
 
		Assert.assertTrue(gameEntry.getScore() > 0 && gameEntry.getScore() <= 1000);
	}

	@Test
	public void testScoreLS(){
		int score = 999;
		GameEntry gameEntry = new GameEntry("user1", 999);
		
		Assert.assertTrue(gameEntry.getScore() <= 1000);
	}
	
	@Test
	public void testMaxScoreLS(){
		int score = 999;
		GameEntry gameEntry = new GameEntry("user1", 1000);
		
		Assert.assertTrue(gameEntry.getScore() <= 1000);
	}
	
	@Test(expected= Exception.class)
	public void testGreaterThanMaxScoreLS(){
		GameEntry gameEntry = new GameEntry("user1", 1001);
	}
	
	
	/*
	 * 
	 * 
	 * 
	 * Other Tests
	 * 
	 * 
	 * 
	 * */
	@Test
	public void testGetName(){
		String name = "Frodo";
		GameEntry gameEntry = new GameEntry(name, 10);
		
		Assert.assertTrue(name.equalsIgnoreCase(gameEntry.getName()));
	}
	
	@Test
	public void testToString(){
		GameEntry gameEntry = new GameEntry("Nome1", 3);
		String resultExpected = "(Nome1, 3)";
		
		Assert.assertEquals(gameEntry.toString(), resultExpected);
	}

}
