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
	private RecipeBook testRecipeBook = null;
		
	/**
	 * Before each test is ran, perform this.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		testRecipe = RecipeTest.genDefaultRecipe();
		testRecipeBook = new RecipeBook();
	}
	
	@Test
	public void testConstructor() 
	{
		RecipeBook recipes = new RecipeBook();
		
		//Test default constructor, all of the recipes will be null
		Recipe[] listOfRecipes = recipes.getRecipes();
		
		//Ensure we have allocated memory
		Assert.assertNotNull("Fail: List of Recipes should not be null.", listOfRecipes);
		
		//Test to ensure each recipe is null
		for(Recipe recipe : listOfRecipes)
		{
			Assert.assertNull("Fail: Default Constructor created a recipe.", recipe);
		}
	}
	
	@Test
	public void testAddRecipes()
	{
		RecipeBook recipes = new RecipeBook();
		Recipe[] listOfRecipes = null;
		boolean added = false;
		boolean doesExist = false;
		
		//Test to add one recipe
		added = recipes.addRecipe(testRecipe);
		
		listOfRecipes = recipes.getRecipes();
		
		for(Recipe recipe : listOfRecipes)
		{
			if(recipe != null && recipe.equals(testRecipe))
				doesExist = true;
		}
		
		//If we add, it exists in the array and the method returns true
		Assert.assertTrue(added == doesExist && added == true);
		
		//Test to add two recipes
		Recipe newRecipe = new Recipe();
		newRecipe.setName(Constants.RECIPE_NAME_NEW);
		
		//add the recipe
		added = recipes.addRecipe(newRecipe);
		
		//ensure the recipe was added
		listOfRecipes = recipes.getRecipes();
		doesExist = false;
		for(Recipe recipe : listOfRecipes)
		{
			if(recipe != null && recipe.equals(newRecipe))
				doesExist = true;
		}
		
		//If we add, it exists in the array and the method returns true
		Assert.assertTrue(added == doesExist && added == true);
		
		//TODO: Test to add more than NUM_RECIPES
		
		//Test to add duplicate recipe
		added = recipes.addRecipe(testRecipe);
		
		//ensure the recipe was added
		listOfRecipes = recipes.getRecipes();
		doesExist = false;
		for(Recipe recipe : listOfRecipes)
		{
			if(recipe != null && recipe.equals(newRecipe))
				doesExist = true;
		}
		
		//If we add, it exists in the array and the method returns true
		Assert.assertTrue(added != doesExist && added == false);
		
		//Test to add null recipe
		added = recipes.addRecipe(null);
		//Assert false on adding null
		Assert.assertTrue(added == false);
	}
	
	//TODO;
	private Recipe[] genNDifferentRecipes()
	{
		return null;
	}
	
	@Test
	public void testDeleteRecipe()
	{
		RecipeBook recipes = new RecipeBook();
		Recipe[] listOfRecipes = null;
		boolean added = false;
		boolean doesExist = false;
		boolean deleted = false;
		
		//Test to add one recipe
		added = recipes.addRecipe(testRecipe);
		
		listOfRecipes = recipes.getRecipes();
	}
	
	@Test
	public void testEditRecipe()
	{
		
	}

}//RecipeBookTest class.
