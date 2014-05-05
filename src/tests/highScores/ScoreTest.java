package tests.highScores;

import highScores.GameEntry;
import highScores.ScoresBuggedImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ScoreTest {
	
	private ScoresBuggedImpl scoreBuggedImpl;
	
	@Before
	public void initializeValues(){
		scoreBuggedImpl = new ScoresBuggedImpl();
	}
	
	@Test
	public void testNumElements(){
		GameEntry gameEntry1 = new GameEntry("user1", 400);
		GameEntry gameEntry2 = new GameEntry("user2", 200);
		GameEntry gameEntry3 = new GameEntry("user3", 500);
		
		scoreBuggedImpl.add(gameEntry1);
		scoreBuggedImpl.add(gameEntry2);
		scoreBuggedImpl.add(gameEntry3);
		
		int numElements = 3;
		
		Assert.assertEquals(numElements, scoreBuggedImpl.getNumElements());
	}
		 
	@Test
	public void testCapacity(){
		GameEntry gameEntry1 = new GameEntry("user1", 400);
		GameEntry gameEntry2 = new GameEntry("user2", 200);
		GameEntry gameEntry3 = new GameEntry("user3", 500);
		
		scoreBuggedImpl.add(gameEntry1);
		scoreBuggedImpl.add(gameEntry2);
		scoreBuggedImpl.add(gameEntry3);
		
		int numElements = 2;
		
		Assert.assertEquals(numElements, scoreBuggedImpl.getCapacity());
	}
	
	@Test 
	public void testScoresListIsNotNull(){
		GameEntry gameEntry1 = new GameEntry("user1", 400);
		scoreBuggedImpl.add(gameEntry1);
		
		Assert.assertNotNull(scoreBuggedImpl.toString());
	}
	
	@Test 
	public void testHighScoreList(){
		GameEntry gameEntry1 = new GameEntry("user1", 400);
		GameEntry gameEntry2 = new GameEntry("user2", 200);
		GameEntry gameEntry3 = new GameEntry("user3", 500);
		
		scoreBuggedImpl.add(gameEntry1);
		scoreBuggedImpl.add(gameEntry2);
		scoreBuggedImpl.add(gameEntry3);
		
		String scores = scoreBuggedImpl.toString();
		
		String[] scoresList = scores.split(",");
		
		Assert.assertEquals(scoresList[0], gameEntry3.toString());
	}
	
	@Test 
	public void testLowScoreList(){
		GameEntry gameEntry1 = new GameEntry("user1", 400);
		GameEntry gameEntry2 = new GameEntry("user2", 200);
		GameEntry gameEntry3 = new GameEntry("user3", 500);
		
		scoreBuggedImpl.add(gameEntry1);
		scoreBuggedImpl.add(gameEntry2);
		scoreBuggedImpl.add(gameEntry3);
		
		String scores = scoreBuggedImpl.toString();
		
		String[] scoresList = scores.split(",");
		
		Assert.assertEquals(scoresList[2], gameEntry2.toString());
	}
	
	@Test 
	public void testAddScoreFullScoreList(){
		GameEntry gameEntry1 = new GameEntry("user1", 400);
		GameEntry gameEntry2 = new GameEntry("user2", 200);
		GameEntry gameEntry3 = new GameEntry("user3", 500);
		GameEntry gameEntry4 = new GameEntry("user4", 100);
		GameEntry gameEntry5 = new GameEntry("user5", 900);
		
		scoreBuggedImpl.add(gameEntry1);
		scoreBuggedImpl.add(gameEntry2);
		scoreBuggedImpl.add(gameEntry3);
		scoreBuggedImpl.add(gameEntry4);
		scoreBuggedImpl.add(gameEntry5);
		
		GameEntry gameEntry6 = new GameEntry("user6", 600);
		scoreBuggedImpl.add(gameEntry5);
		
		String scores = scoreBuggedImpl.toString();
		
		Assert.assertTrue(scores.contains("user6"));
	}

	@Test 
	public void testNotAddedScoreFullScoreList(){
		GameEntry gameEntry1 = new GameEntry("user1", 400);
		GameEntry gameEntry2 = new GameEntry("user2", 200);
		GameEntry gameEntry3 = new GameEntry("user3", 500);
		GameEntry gameEntry4 = new GameEntry("user4", 100);
		GameEntry gameEntry5 = new GameEntry("user5", 900);
		
		scoreBuggedImpl.add(gameEntry1);
		scoreBuggedImpl.add(gameEntry2);
		scoreBuggedImpl.add(gameEntry3);
		scoreBuggedImpl.add(gameEntry4);
		scoreBuggedImpl.add(gameEntry5);
		
		GameEntry gameEntry6 = new GameEntry("user6", 50);
		scoreBuggedImpl.add(gameEntry5);
		
		String scores = scoreBuggedImpl.toString();
		
		Assert.assertFalse(scores.contains("user6"));
	}
	
}
