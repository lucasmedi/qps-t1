package tests.classes;

import org.junit.Assert;
import org.junit.Test;

import classes.GameEntry;

public class GameEntryTest {
	
	
	@Test
	public void testEmptyName(){
		
	}
	
	@Test
	public void testGreatName(){
		
	}
	
	@Test
	public void testaSmallNome(){
		
	}
	
	@Test
	public void testMaxScore(){
		
	}
	
	@Test
	public void testScore(){
	
	}
	
	@Test
	public void testToString(){
		GameEntry gameEntry = new GameEntry("user1", 100);
		String result = "(user1,100)";
		
		Assert.assertEquals(gameEntry.toString(), result);
	}

}
