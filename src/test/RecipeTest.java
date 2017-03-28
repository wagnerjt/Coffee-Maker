package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//Imports from Coffee Maker System
import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class RecipeTest 
{
	//Defined in setUp() method
	private Recipe testRecipe = null;
	
	/**
	 * Before each test is ran, perform this.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		testRecipe = new Recipe();
	}
	
	
	
	@Test
	public void testConstructor() 
	{
		Recipe recipe = new Recipe();
	}
	
	@Test
	public void testAmtChocolate()
	{
		
	}
	
	@Test
	public void testAmtCoffee()
	{
		
	}
	
	@Test
	public void testAmtMilk()
	{
		
	}
	
	@Test
	public void testAmtSugar()
	{
		
	}
	

	@Test
	/**
	 * Tests the name of the Recipe and the toString()
	 */
	public void testName()
	{
		
	}
	
	@Test
	public void testHashCode()
	{
		
	}
	
	@Test
	public void testEquals()
	{
		
	}
	

}//RecipeTest class.
