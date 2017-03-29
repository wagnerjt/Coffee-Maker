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
		String deletedRecipe = null;
		int indexToDelete = -1;
		
		//Test to add one recipe
		added = recipes.addRecipe(testRecipe);
		
		//See if the recipe was added
		listOfRecipes = recipes.getRecipes();
		for(int i = 0; i < listOfRecipes.length; i++)
		{
			Recipe recipe = listOfRecipes[i];
			if(recipe != null && recipe.equals(testRecipe))
			{
				doesExist = true;
				indexToDelete = i;
				break;
			}
		}
		
		//Ensures the recipe was added, actually exists in the array 
		//and is at the first index
		Assert.assertTrue(added == true); 
		Assert.assertTrue(doesExist == true); 
		Assert.assertTrue(indexToDelete == 0);
		
		
		//Test for an existing recipe to be deleted.
		deletedRecipe = recipes.deleteRecipe(indexToDelete);
		
		Assert.assertNotNull(deletedRecipe);
		Assert.assertEquals(testRecipe.getName(), deletedRecipe);
		
		//Test to delete the same index
		deletedRecipe = recipes.deleteRecipe(indexToDelete);
		Assert.assertNull(deletedRecipe);
		
		//Test out of bounds in the negative direction
		deletedRecipe = recipes.deleteRecipe(-1);
		Assert.assertNull(deletedRecipe);
		
		//Test out of bounds in the positive direction. 
		//Note: listOfRecipes is the array within recipes, so this works.
		deletedRecipe = recipes.deleteRecipe(listOfRecipes.length);
		Assert.assertNull(deletedRecipe);
	}
	
	@Test
	public void testEditRecipe()
	{
		RecipeBook recipes = new RecipeBook();
		Recipe[] listOfRecipes = null;
		boolean added = false;
		boolean doesExist = false;
		String editedRecipe = null;
		int indexToEdit = -1;
		
		//Test to add one recipe
		added = recipes.addRecipe(testRecipe);
		
		//See if the recipe was added
		listOfRecipes = recipes.getRecipes();
		for(int i = 0; i < listOfRecipes.length; i++)
		{
			Recipe recipe = listOfRecipes[i];
			if(recipe != null && recipe.equals(testRecipe))
			{
				doesExist = true;
				indexToEdit = i;
				break;
			}
		}
		
		//Ensures the recipe was added, actually exists in the array 
		//and is at the first index
		Assert.assertTrue(added == true); 
		Assert.assertTrue(doesExist == true); 
		Assert.assertTrue(indexToEdit == 0);
		
		//Alter the name
		Recipe newRecipe = new Recipe();
		newRecipe.setName(Constants.RECIPE_NAME_NEW);
		
		//Test for an existing recipe to be edited.
		editedRecipe = recipes.editRecipe(indexToEdit, newRecipe);
		
		Assert.assertNotNull(editedRecipe);
		Assert.assertEquals(testRecipe.getName(), editedRecipe);
		
		//Test to edit the same index
		editedRecipe = recipes.editRecipe(indexToEdit, testRecipe);
		Assert.assertNotNull(editedRecipe);
		Assert.assertEquals(editedRecipe, newRecipe.getName());
		
		//Test editing a valid recipe with a null object
		editedRecipe = recipes.editRecipe(indexToEdit, null);
		Assert.assertEquals(editedRecipe, testRecipe.getName());
		
		//Test editing a valid bounds null recipe.
		editedRecipe = recipes.editRecipe(2, testRecipe);
		Assert.assertNull(editedRecipe);
		
		//Test out of bounds in the negative direction
		editedRecipe = recipes.deleteRecipe(-1);
		Assert.assertNull(editedRecipe);
		
		//Test out of bounds in the positive direction. 
		//Note: listOfRecipes is the array within recipes, so this works.
		editedRecipe = recipes.deleteRecipe(listOfRecipes.length);
		Assert.assertNull(editedRecipe);
		
	}

}//RecipeBookTest class.
