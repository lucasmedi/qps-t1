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
		int numElements = 5;
		
		Assert.assertEquals(numElements, scoreBuggedImpl.getCapacity());
	}
	
	@Test 
	public void testAddScoresListIsEmpty(){
		GameEntry gameEntry1 = new GameEntry("João", 5);
		
		Assert.assertTrue(scoreBuggedImpl.add(gameEntry1));
	}
	
	@Test 
	public void testAddNull(){
		Assert.assertFalse(scoreBuggedImpl.add(null));
	}

	@Test 
	public void testNotAddedScoreFullList(){
		GameEntry gameEntry1 = new GameEntry("John", 10);
		GameEntry gameEntry2 = new GameEntry("Carol", 5);
		GameEntry gameEntry3 = new GameEntry("Giovanni", 11);
		GameEntry gameEntry4 = new GameEntry("Lucas", 10);
		GameEntry gameEntry5 = new GameEntry("Frodo", 3);
		
		scoreBuggedImpl.add(gameEntry1);
		scoreBuggedImpl.add(gameEntry2);
		scoreBuggedImpl.add(gameEntry3);
		scoreBuggedImpl.add(gameEntry4);
		scoreBuggedImpl.add(gameEntry5);
		
		GameEntry gameEntry6 = new GameEntry("Peter", 1);
		
		Assert.assertFalse(scoreBuggedImpl.add(gameEntry6));
	}
	
	@Test 
	public void testAddedScoreFullList(){
		GameEntry gameEntry1 = new GameEntry("John", 10);
		GameEntry gameEntry2 = new GameEntry("Carol", 5);
		GameEntry gameEntry3 = new GameEntry("Giovanni", 11);
		GameEntry gameEntry4 = new GameEntry("Lucas", 10);
		GameEntry gameEntry5 = new GameEntry("Frodo", 3);
		
		scoreBuggedImpl.add(gameEntry1);
		scoreBuggedImpl.add(gameEntry2);
		scoreBuggedImpl.add(gameEntry3);
		scoreBuggedImpl.add(gameEntry4);
		scoreBuggedImpl.add(gameEntry5);
		
		GameEntry gameEntry6 = new GameEntry("Homer", 20);
		
		Assert.assertTrue(scoreBuggedImpl.add(gameEntry6));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveNegativeIndex(){
		//[(John, 10), (Carol, 5), (Dan, 3), (Giovanni, 2), (Lucas, 1)]
		GameEntry gameEntry1 = new GameEntry("John", 10);
		GameEntry gameEntry2 = new GameEntry("Carol", 5);
		GameEntry gameEntry3 = new GameEntry("Dan", 3);
		GameEntry gameEntry4 = new GameEntry("Giovanni", 2);
		GameEntry gameEntry5 = new GameEntry("Lucas", 1);
		
		scoreBuggedImpl.add(gameEntry1);
		scoreBuggedImpl.add(gameEntry2);
		scoreBuggedImpl.add(gameEntry3);
		scoreBuggedImpl.add(gameEntry4);
		scoreBuggedImpl.add(gameEntry5);
		
		int index = -1;
		
		scoreBuggedImpl.remove(index);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveGreaterThanListIndex(){
		//[(John, 10), (Carol, 5), (Dan, 3), (Giovanni, 2), (Lucas, 1)]
		GameEntry gameEntry1 = new GameEntry("John", 10);
		GameEntry gameEntry2 = new GameEntry("Carol", 5);
		GameEntry gameEntry3 = new GameEntry("Dan", 3);
		GameEntry gameEntry4 = new GameEntry("Giovanni", 2);
		GameEntry gameEntry5 = new GameEntry("Lucas", 1);
		
		scoreBuggedImpl.add(gameEntry1);
		scoreBuggedImpl.add(gameEntry2);
		scoreBuggedImpl.add(gameEntry3);
		scoreBuggedImpl.add(gameEntry4);
		scoreBuggedImpl.add(gameEntry5);
		
		int index = 20;
		
		scoreBuggedImpl.remove(index);
	}
	
	@Test
	public void testRemove(){
		//[(John, 10), (Carol, 5), (Dan, 3), (Giovanni, 2), (Lucas, 1)]
		GameEntry gameEntry1 = new GameEntry("John", 10);
		GameEntry gameEntry2 = new GameEntry("Carol", 5);
		GameEntry gameEntry3 = new GameEntry("Dan", 3);
		GameEntry gameEntry4 = new GameEntry("Giovanni", 2);
		GameEntry gameEntry5 = new GameEntry("Lucas", 1);
		
		scoreBuggedImpl.add(gameEntry1);
		scoreBuggedImpl.add(gameEntry2);
		scoreBuggedImpl.add(gameEntry3);
		scoreBuggedImpl.add(gameEntry4);
		scoreBuggedImpl.add(gameEntry5);
		
		int index = 4;
		
		GameEntry gameEntry = scoreBuggedImpl.remove(index);
		
		Assert.assertTrue(gameEntry.getName().equalsIgnoreCase(gameEntry5.getName()));
	}
	
}
