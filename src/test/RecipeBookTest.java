package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//Imports from Coffee Maker System
import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.RecipeBook;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class RecipeBookTest 
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
		
	}
	
	@Test
	public void testAddRecipes()
	{
		
	}
	
	@Test
	public void testDeleteRecipe()
	{
		
	}
	
	@Test
	public void testEditRecipe()
	{
		
	}

}//RecipeBookTest class.
