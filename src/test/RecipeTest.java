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
		
		//Set the recipe		
		testRecipe.setName(Constants.RECIPE_NAME_DEFUALT);
		testRecipe.setAmtChocolate(String.valueOf(Constants.RECIPE_AMTCHOCOLATE_DEFAULT));
		testRecipe.setAmtMilk(String.valueOf(Constants.RECIPE_AMTMILK_DEFAULT));
		testRecipe.setAmtSugar(String.valueOf(Constants.RECIPE_AMTSUGAR_DEFAULT));
		testRecipe.setPrice(String.valueOf(Constants.RECIPE_PRICE_DEFAULT));
	}
	
	
	@Test
	public void testConstructor() 
	{
		Recipe recipe = new Recipe();
		
		//Testing for name
		Assert.assertEquals(Constants.STRING_EMPTY, recipe.getName());
		
		//Testing other private members for default value
		Assert.assertEquals(0, recipe.getPrice());
		Assert.assertEquals(0,  recipe.getAmtCoffee());
		Assert.assertEquals(0, recipe.getAmtMilk());
		Assert.assertEquals(0, recipe.getAmtSugar());
		Assert.assertEquals(0, recipe.getAmtChocolate());
	}
	
	@Test
	public void testAmtChocolate()
	{
		String validChocolate = "10";
		String negativeChocolate = "-1";
		String notNumberChocolate = "weirdInput";
		String nullChocolate = null;
				
		//Test Default Amount of Chocolate
		Assert.assertEquals(testRecipe.getAmtChocolate(), Constants.RECIPE_AMTCHOCOLATE_DEFAULT);
		
		//Create a new recipe
		Recipe recipe = new Recipe();
		
		//Try to set and accept valid chocolate amount
		try {
			recipe.setAmtChocolate(validChocolate);
			Assert.assertEquals(Integer.parseInt(validChocolate), recipe.getAmtChocolate());
		} catch (RecipeException e) {
			Assert.fail("Fail: Setting Valid Chocolate Amount");
		}
		
		//Try to set and accept negative chocolate amount
		try {
			recipe.setAmtChocolate(negativeChocolate);
			Assert.fail("Fail: Negative Chocolate Amount was accepted");
		} catch (RecipeException e) {
			Assert.assertEquals(Integer.parseInt(validChocolate), recipe.getAmtChocolate());
		}
		
		//Try to set and non integer chocolate amount
		try {
			recipe.setAmtChocolate(notNumberChocolate);
			Assert.fail("Fail: Not a number Chocolate Amount was accepted");
		} catch (RecipeException e) {
			Assert.assertEquals(Integer.parseInt(validChocolate), recipe.getAmtChocolate());
		}
		
		//Try to set and null chocolate amount
		try {
			recipe.setAmtChocolate(nullChocolate);
			Assert.fail("Fail: Null Chocolate Amount was accepted");
		} catch (RecipeException e) {
			Assert.assertEquals(Integer.parseInt(validChocolate), recipe.getAmtChocolate());
		}
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
		//Ensure the name is equivelent
		Assert.assertEquals(Constants.RECIPE_NAME_DEFUALT, testRecipe.getName());
		
		//Try to insert null as name
		testRecipe.setName(null);
		//Ensure name did not change
		Assert.assertEquals(Constants.RECIPE_NAME_DEFUALT, testRecipe.getName());
		
		//Actually test the changing of the name.
		testRecipe.setName(Constants.RECIPE_NAME_NEW);
		//Ensure name did change
		Assert.assertEquals(Constants.RECIPE_NAME_NEW, testRecipe.getName());
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
