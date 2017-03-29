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
	
	public static Recipe genDefaultRecipe() throws Exception
	{
		Recipe defaultRecipe = new Recipe();
		
		//Set the recipe		
		defaultRecipe.setName(Constants.RECIPE_NAME_DEFAULT);
		defaultRecipe.setAmtChocolate(String.valueOf(Constants.RECIPE_AMTCHOCOLATE_DEFAULT));
		defaultRecipe.setAmtCoffee(String.valueOf(Constants.RECIPE_AMTCOFFEE_DEFAULT));
		defaultRecipe.setAmtMilk(String.valueOf(Constants.RECIPE_AMTMILK_DEFAULT));
		defaultRecipe.setAmtSugar(String.valueOf(Constants.RECIPE_AMTSUGAR_DEFAULT));
		defaultRecipe.setPrice(String.valueOf(Constants.RECIPE_PRICE_DEFAULT));
		
		return defaultRecipe;
	}
	
	/**
	 * Before each test is ran, perform this.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		testRecipe = RecipeTest.genDefaultRecipe();
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
		String validCoffee = "10";
		String negativeCoffee = "-1";
		String notNumberCoffee = "weirdInput";
		String nullCoffee = null;
				
		//Test Default Amount of Coffee
		Assert.assertEquals(testRecipe.getAmtCoffee(), Constants.RECIPE_AMTCOFFEE_DEFAULT);
		
		//Create a new recipe
		Recipe recipe = new Recipe();
		
		//Try to set and accept valid coffee amount
		try {
			recipe.setAmtCoffee(validCoffee);
			Assert.assertEquals(Integer.parseInt(validCoffee), recipe.getAmtCoffee());
		} catch (RecipeException e) {
			Assert.fail("Fail: Setting Valid Coffee Amount");
		}
		
		//Try to set and accept negative chocolate amount
		try {
			recipe.setAmtCoffee(negativeCoffee);
			Assert.fail("Fail: Negative Coffee Amount was accepted");
		} catch (RecipeException e) {
			Assert.assertEquals(Integer.parseInt(validCoffee), recipe.getAmtCoffee());
		}
		
		//Try to set and non integer chocolate amount
		try {
			recipe.setAmtCoffee(notNumberCoffee);
			Assert.fail("Fail: Not a number Coffee Amount was accepted");
		} catch (RecipeException e) {
			Assert.assertEquals(Integer.parseInt(validCoffee), recipe.getAmtCoffee());
		}
		
		//Try to set and null chocolate amount
		try {
			recipe.setAmtCoffee(nullCoffee);
			Assert.fail("Fail: Null Coffee Amount was accepted");
		} catch (RecipeException e) {
			Assert.assertEquals(Integer.parseInt(validCoffee), recipe.getAmtCoffee());
		}
	}
	
	@Test
	public void testAmtMilk()
	{
		String validMilk = "10";
		String negativeMilk = "-1";
		String notNumberMilk = "weirdInput";
		String nullMilk = null;
				
		//Test Default Amount of Milk
		Assert.assertEquals(testRecipe.getAmtMilk(), Constants.RECIPE_AMTMILK_DEFAULT);
		
		//Create a new recipe
		Recipe recipe = new Recipe();
		
		//Try to set and accept valid milk amount
		try {
			recipe.setAmtMilk(validMilk);
			Assert.assertEquals(Integer.parseInt(validMilk), recipe.getAmtMilk());
		} catch (RecipeException e) {
			Assert.fail("Fail: Setting Valid Milk Amount");
		}
		
		//Try to set and accept negative milk amount
		try {
			recipe.setAmtMilk(negativeMilk);
			Assert.fail("Fail: Negative Milk Amount was accepted");
		} catch (RecipeException e) {
			Assert.assertEquals(Integer.parseInt(validMilk), recipe.getAmtMilk());
		}
		
		//Try to set and non integer milk amount
		try {
			recipe.setAmtMilk(notNumberMilk);
			Assert.fail("Fail: Not a number Milk Amount was accepted");
		} catch (RecipeException e) {
			Assert.assertEquals(Integer.parseInt(validMilk), recipe.getAmtMilk());
		}
		
		//Try to set and null milk amount
		try {
			recipe.setAmtMilk(nullMilk);
			Assert.fail("Fail: Null Milk Amount was accepted");
		} catch (RecipeException e) {
			Assert.assertEquals(Integer.parseInt(validMilk), recipe.getAmtMilk());
		}
	}
	
	@Test
	public void testAmtSugar()
	{
		String validSugar = "10";
		String negativeSugar = "-1";
		String notNumberSugar = "weirdInput";
		String nullSugar = null;
				
		//Test Default Amount of Sugar
		Assert.assertEquals(testRecipe.getAmtSugar(), Constants.RECIPE_AMTSUGAR_DEFAULT);
		
		//Create a new recipe
		Recipe recipe = new Recipe();
		
		//Try to set and accept valid sugar amount
		try {
			recipe.setAmtSugar(validSugar);
			Assert.assertEquals(Integer.parseInt(validSugar), recipe.getAmtSugar());
		} catch (RecipeException e) {
			Assert.fail("Fail: Setting Valid Sugar Amount");
		}
		
		//Try to set and accept negative sugar amount
		try {
			recipe.setAmtSugar(negativeSugar);
			Assert.fail("Fail: Negative Sugar Amount was accepted");
		} catch (RecipeException e) {
			Assert.assertEquals(Integer.parseInt(validSugar), recipe.getAmtSugar());
		}
		
		//Try to set and non integer sugar amount
		try {
			recipe.setAmtSugar(notNumberSugar);
			Assert.fail("Fail: Not a number Sugar Amount was accepted");
		} catch (RecipeException e) {
			Assert.assertEquals(Integer.parseInt(validSugar), recipe.getAmtSugar());
		}
		
		//Try to set and null sugar amount
		try {
			recipe.setAmtSugar(nullSugar);
			Assert.fail("Fail: Null Sugar Amount was accepted");
		} catch (RecipeException e) {
			Assert.assertEquals(Integer.parseInt(validSugar), recipe.getAmtSugar());
		}
	}
	
	@Test
	public void testPrice()
	{
		String validPrice = "10";
		String negativePrice = "-1";
		String notNumberPrice = "weirdInput";
		String nullPrice = null;
				
		//Test Default Amount of Price
		Assert.assertEquals(testRecipe.getPrice(), Constants.RECIPE_PRICE_DEFAULT);
		
		//Create a new recipe
		Recipe recipe = new Recipe();
		
		//Try to set and accept valid price amount
		try {
			recipe.setPrice(validPrice);
			Assert.assertEquals(Integer.parseInt(validPrice), recipe.getPrice());
		} catch (RecipeException e) {
			Assert.fail("Fail: Setting Valid Price Amount");
		}
		
		//Try to set and accept negative price amount
		try {
			recipe.setPrice(negativePrice);
			Assert.fail("Fail: Negative Price Amount was accepted");
		} catch (RecipeException e) {
			Assert.assertEquals(Integer.parseInt(validPrice), recipe.getPrice());
		}
		
		//Try to set and non integer price amount
		try {
			recipe.setPrice(notNumberPrice);
			Assert.fail("Fail: Not a number Price Amount was accepted");
		} catch (RecipeException e) {
			Assert.assertEquals(Integer.parseInt(validPrice), recipe.getPrice());
		}
		
		//Try to set and null price amount
		try {
			recipe.setPrice(nullPrice);
			Assert.fail("Fail: Null Price Amount was accepted");
		} catch (RecipeException e) {
			Assert.assertEquals(Integer.parseInt(validPrice), recipe.getPrice());
		}
	}
	

	@Test
	/**
	 * Tests the name of the Recipe and the toString()
	 */
	public void testName()
	{
		//Ensure the name is equivalent
		Assert.assertEquals(Constants.RECIPE_NAME_DEFAULT, testRecipe.getName());
		Assert.assertEquals(Constants.RECIPE_NAME_DEFAULT, testRecipe.toString());
		
		//Try to insert null as name
		testRecipe.setName(null);
		
		//Ensure name did not change
		Assert.assertEquals(Constants.RECIPE_NAME_DEFAULT, testRecipe.getName());
		Assert.assertEquals(Constants.RECIPE_NAME_DEFAULT, testRecipe.toString());
		
		//Actually test the changing of the name.
		testRecipe.setName(Constants.RECIPE_NAME_NEW);
		
		//Ensure name did change
		Assert.assertEquals(Constants.RECIPE_NAME_NEW, testRecipe.getName());
		Assert.assertEquals(Constants.RECIPE_NAME_NEW, testRecipe.toString());
	}
	
	@Test
	public void testHashCode()
	{
		//tests the hash code from the default name of our test
		int hashCodeValue = 31 + Constants.RECIPE_NAME_DEFAULT.hashCode();
		
		//checks for equality
		Assert.assertEquals(hashCodeValue, testRecipe.hashCode());
	}
	
	/**
	 * Recipes are defined for equality if their names match.
	 */
	@Test
	public void testEquals()
	{
		//Test for equality on a shallow copy 
		Recipe testRecipeMemCopy = testRecipe;
		Assert.assertTrue("Fail: Shallow copy is not equal", testRecipe.equals(testRecipeMemCopy));
		
		//Test for equality on an equal recipe
		Recipe equalRecipe = new Recipe();
		equalRecipe.setName(testRecipe.getName());
		Assert.assertTrue("Fail: Truly equal recipes are not equal", testRecipe.equals(equalRecipe));
		
		//Test for equality on a recipe differed by caps
		Recipe cappedRecipe = new Recipe();
		cappedRecipe.setName(Constants.RECIPE_NAME_DEFAULT_CAPS);
		Assert.assertFalse("Fail: Accepted Recipes of different caps", testRecipe.equals(cappedRecipe));
		
		//Test for equality on a recipe that is truly different
		Recipe differentRecipe = new Recipe();
		differentRecipe.setName(Constants.RECIPE_NAME_NEW);
		Assert.assertFalse("Fail: Accepted Recipes that are not equal", testRecipe.equals(differentRecipe));
		
		//Test for equality on a null object
		Recipe nullRecipe = null;
		Assert.assertFalse("Fail: Accepted Recipes that are equal to null", testRecipe.equals(nullRecipe));
		
		//Test for equality on a different class type
		String string = Constants.STRING_EMPTY;
		Assert.assertFalse("Fail: Accepted Recipes that are equal to other classes", testRecipe.equals(string));
	}
	

}//RecipeTest class.
