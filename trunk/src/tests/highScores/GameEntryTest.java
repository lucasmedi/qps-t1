package tests.highScores;

import highScores.modified.GameEntry;

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
	public void testNameSizeEqualZeroLI() throws Exception{
		GameEntry gameEntry = new GameEntry("", 100);
	}
	
	@Test
	public void testNameSizeEqualOneLI() throws Exception{
		GameEntry gameEntry = new GameEntry("a", 100);
		
		Assert.assertTrue(gameEntry.getName().length() > 0);
	}
	
	@Test
	public void testNameSizeEqualTwoLI() throws Exception{
		GameEntry gameEntry = new GameEntry("ab", 100);
		
		Assert.assertTrue(gameEntry.getName().length() > 0);
	}
	
	@Test
	public void testNameLS() throws Exception{
		GameEntry gameEntry = new GameEntry("user567891234567891", 1000);
		
		Integer length = gameEntry.getName().length();
		
		Assert.assertTrue(length > 0 && length <= 20);
	}
	
	@Test
	public void testNameLimitLS() throws Exception{
		GameEntry gameEntry = new GameEntry("user5678912345678912", 1000);
		
		Integer length = gameEntry.getName().length();
		
		Assert.assertTrue(length > 0 && length <= 20);
	}
	
	@Test(expected = Exception.class)
	public void testGreatNameLS() throws Exception{
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
	public void testNegativeScoreLI() throws Exception{
		int score = -1;
		GameEntry gameEntry = new GameEntry("user1", score);
	}
	
	@Test
	public void testGetScoreZeroLI() throws Exception{
		int score = 0;
		GameEntry gameEntry = new GameEntry("User1", score);
		
		Assert.assertEquals(score, gameEntry.getScore());
	}
	
	@Test
	public void testScoreLI() throws Exception{
		int score = 1;
		GameEntry gameEntry = new GameEntry("User1", score);
 
		Assert.assertTrue(gameEntry.getScore() >= 0 && gameEntry.getScore() <= 1000);
	}

	@Test
	public void testScoreLS() throws Exception{
		int score = 999;
		GameEntry gameEntry = new GameEntry("user1", 999);
		
		Assert.assertTrue(gameEntry.getScore() >= 0 && gameEntry.getScore() <= 1000);
	}
	
	@Test
	public void testMaxScoreLS() throws Exception{
		int score = 999;
		GameEntry gameEntry = new GameEntry("user1", 1000);
		
		Assert.assertTrue(gameEntry.getScore() > 0 && gameEntry.getScore() <= 1000);
	}
	
	@Test(expected= Exception.class)
	public void testGreaterThanMaxScoreLS() throws Exception{
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
	public void testGetName() throws Exception{
		String name = "Frodo";
		GameEntry gameEntry = new GameEntry(name, 10);
		
		Assert.assertTrue(name.equalsIgnoreCase(gameEntry.getName()));
	}
	@Test
	public void testGetScore() throws Exception{
		int score = 5;
		GameEntry gameEntry = new GameEntry("Frodo", 5);
		
		Assert.assertEquals(score, gameEntry.getScore());;
	}
	
	@Test
	public void testToString() throws Exception{
		GameEntry gameEntry = new GameEntry("Nome1", 3);
		String resultExpected = "(Nome1, 3)";
		
		Assert.assertEquals(gameEntry.toString(), resultExpected);
	}

}
