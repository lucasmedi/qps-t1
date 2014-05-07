package tests.highScores;

import highScores.modified.GameEntry;
import highScores.modified.ScoresBuggedImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ScoreTest {
	
	private ScoresBuggedImpl scoreBuggedImpl;
	
	@Before
	public void initializeValues(){
		scoreBuggedImpl = new ScoresBuggedImpl();
	}
	
	/*
	 * 
	 * 
	 * 
	 * Test NumElements
	 * 
	 * 
	 * 
	 * */
	@Test
	public void testNumElementsEmptyList(){
		int numElements = 0;
		
		Assert.assertEquals(numElements, scoreBuggedImpl.getNumElements());
	}
	
	@Test
	public void testNumElements() throws Exception{
		GameEntry gameEntry1 = new GameEntry("John", 10);
		GameEntry gameEntry2 = new GameEntry("Carol", 5);
				
		scoreBuggedImpl.add(gameEntry1);
		scoreBuggedImpl.add(gameEntry2);
		
		int numElements = 2;
		
		Assert.assertEquals(numElements, scoreBuggedImpl.getNumElements());
	}
	
	
	@Test
	public void testNumElementsFullList() throws Exception{
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
		
		int numElements = 5;
		
		Assert.assertEquals(numElements, scoreBuggedImpl.getNumElements());
	}
		 
	
	/*
	 * 
	 * 
	 * 
	 * Test Capacity
	 * 
	 * 
	 * 
	 * */
	@Test
	public void testCapacity(){
		int numElements = 5;
		
		Assert.assertEquals(numElements, scoreBuggedImpl.getCapacity());
	}
	
	
	/*
	 * 
	 * 
	 * 
	 * Test Add
	 * 
	 * 
	 * 
	 * */
	@Test 
	public void testAddScoresEmptyList() throws Exception{
		GameEntry gameEntry1 = new GameEntry("João", 5);
		
		Assert.assertTrue(scoreBuggedImpl.add(gameEntry1));
	}
	
	@Test 
	public void testAddNull(){
		Assert.assertFalse(scoreBuggedImpl.add(null));
	}
	
	@Test 
	public void testAddScore() throws Exception{
		GameEntry gameEntry1 = new GameEntry("John", 10);
		GameEntry gameEntry2 = new GameEntry("Carol", 5);
		GameEntry gameEntry3 = new GameEntry("Giovanni", 11);
		GameEntry gameEntry4 = new GameEntry("Lucas", 10);
		
		scoreBuggedImpl.add(gameEntry1);
		scoreBuggedImpl.add(gameEntry2);
		scoreBuggedImpl.add(gameEntry3);
		scoreBuggedImpl.add(gameEntry4);
		
		GameEntry gameEntry5 = new GameEntry("Frodo", 3);
		
		Assert.assertTrue(scoreBuggedImpl.add(gameEntry5));
	}

	@Test 
	public void testNotAddedScoreFullList() throws Exception{
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
	public void testAddedScoreFullList() throws Exception{
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
	
	/*
	 * 
	 * 
	 * 
	 * Test Remove
	 * 
	 * 
	 * 
	 * */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveNegativeIndex() throws Exception{
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
	public void testRemoveGreaterThanListIndex() throws Exception{
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
	public void testRemove() throws Exception{
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
	
	/*
	 * 
	 * 
	 * 
	 * Test ToString
	 * 
	 * 
	 * 
	 * */
	@Test
	public void testToString() throws Exception{
		GameEntry gameEntry1 = new GameEntry("John", 10);
		GameEntry gameEntry2 = new GameEntry("Carol", 5);
				
		scoreBuggedImpl.add(gameEntry1);
		scoreBuggedImpl.add(gameEntry2);
	
		String list = "["+gameEntry1.toString()+", " + gameEntry2.toString()+"]";
		
		Assert.assertEquals(list.toLowerCase(),scoreBuggedImpl.toString().toLowerCase());
	}
	
	
}
