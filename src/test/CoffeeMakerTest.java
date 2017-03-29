package test;
 
import static org.junit.Assert.*;
 
import org.junit.*;

import edu.ncsu.csc326.coffeemaker.CoffeeMaker;
import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
 
public class CoffeeMakerTest {
    private Recipe valid_rep1;
    private Recipe valid_rep2;
    private Recipe valid_rep3;
    private Recipe valid_rep4;
    private Recipe valid_rep5;
    private Recipe invalid_rep1;
    private Recipe invalid_rep2;
   
    @Before
    public void config() throws Exception {
        valid_rep1 = new Recipe();
        valid_rep1.setName("Latte");
        valid_rep1.setAmtChocolate("3");
        valid_rep1.setAmtCoffee("3");
        valid_rep1.setAmtMilk("1");
        valid_rep1.setAmtSugar("2");
        valid_rep1.setPrice("50");
       
        valid_rep2 = new Recipe();
        valid_rep2.setName("FrappucinoOrHoweverYouSpellIt");
        valid_rep2.setAmtChocolate("1");
        valid_rep2.setAmtCoffee("1");
        valid_rep2.setAmtMilk("3");
        valid_rep2.setAmtSugar("4");
        valid_rep2.setPrice("75");
    }
   
    @Test
    public void testAddRecipeValid() {
        CoffeeMaker CM = new CoffeeMaker();
       
        try {
            assertEquals("Should be true", true, CM.addRecipe(valid_rep1));
        } catch (Exception e) {
            fail("Should not throw exception");
        }
    }
   
    @Test
    /**
     * Test: add 5 recipes to the coffee maker (an invalid operation - should only accept 3 recipes)
     */
    public void testAddRecipe5TimesAndNull() {
        CoffeeMaker CM = new CoffeeMaker();
       
        try {
            assertEquals("Should return true", true, CM.addRecipe(valid_rep1));
            assertEquals("Should return true", true, CM.addRecipe(valid_rep2));
            assertEquals("Should return true", true, CM.addRecipe(valid_rep3));
            assertEquals("Should return false", false, CM.addRecipe(valid_rep4));
            assertEquals("Should return false", false, CM.addRecipe(valid_rep5));
        } catch (Exception e) {
            fail("Should not throw exception");
        }
    }
 
    @Test
    /**
     * Test to delete all recipes, then attempt to call deleteRecipe on the 0th element
     * Expected Behavior: eventually returns null
     */
    public void testDeleteRecipeOutOfBoundsLow() {
        CoffeeMaker CM = new CoffeeMaker();
       
        try {
            CM.addRecipe(valid_rep1);
            CM.deleteRecipe(0);
            CM.deleteRecipe(0);
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }
   
    @Test
    /**
     * Test: delete all recipes, then attempt to call deleteRecipe on the 0th element
     * Expected Behavior: returns null
     */
    public void testDeleteRecipeOutOfBoundsHigh() {
        CoffeeMaker CM = new CoffeeMaker();
       
        try {
            CM.addRecipe(valid_rep1);
            assertNull("Should be null", CM.deleteRecipe(2));
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }
   
    @Test
    /**
     * Test: deletes recipe at index 4
     * Expected Behavior: returns null
     */
    public void testDeleteRecipeOutOfBoundsAtLimit() {
        CoffeeMaker CM = new CoffeeMaker();
       
        try {
            CM.addRecipe(valid_rep1);
            assertNull("Should be null", CM.deleteRecipe(4));
        } catch (Exception e) {
            fail("Should not throw exception");
        }
    }
   
    @Test
    /**
     * Test: add a distinct recipe to the CM, then edit that recipe by passing in another distinct recipe
     * Expected Behavior: given recipe1 and recipe2 - add recipe1 to the CM and then call editRecipe(0,recipe2) should return the recipe1 name, and all properties of recipe2 should now be where recipe1 once was in the CM.
     */
    public void testEditRecipeValid() {
        CoffeeMaker CM = new CoffeeMaker();
        final String valid_rep2_name = valid_rep2.getName();
        final String valid_rep1_origName = valid_rep1.getName();
       
        try {
            CM.addRecipe(valid_rep1);
            final String edited_rep1_name = CM.editRecipe(0,valid_rep2);
           
            assertEquals("Should be equal", valid_rep1_origName, edited_rep1_name);
            assertNotNull("Shouldn't be null",edited_rep1_name);
            assertEquals("Amt Chocolate should be equal",CM.getRecipes()[0].getAmtChocolate(),valid_rep2.getAmtChocolate());
            assertEquals("Amt Coffee should be equal",CM.getRecipes()[0].getAmtCoffee(),valid_rep2.getAmtCoffee());
            assertEquals("Amt Milk should be equal",CM.getRecipes()[0].getAmtMilk(),valid_rep2.getAmtMilk());
            assertEquals("Amt Sugar should be equal",CM.getRecipes()[0].getAmtSugar(),valid_rep2.getAmtSugar());
            assertEquals("Price should be equal",CM.getRecipes()[0].getPrice(),valid_rep2.getPrice());
        } catch (Exception e) {
            fail("Should not throw exception");
        }
    }
   
    @Test
    /**
     * Test: edit a recipe out of that is negatively beyond out the bounds of the recipe.
     * Expected Behavior: editRecipe(...) returns null
     */
    public void testEditRecipeOutOfBoundsLow() {
        CoffeeMaker CM = new CoffeeMaker();
        try{
            assertNull("Should be null", CM.editRecipe(-1, new Recipe()));
        } catch(Exception e) {
            fail("Should not throw exception");
        }
    }
   
    @Test
    /**
     * Test: edit a recipe out of that is positively beyond out the bounds of the recipe.
     * Expected Behavior: editRecipe(...) returns null
     */
    public void testEditRecipeOutOfBoundsHigh() {
        CoffeeMaker CM = new CoffeeMaker();
        try{
            assertNull("Should be null", CM.editRecipe(5, new Recipe()));
        } catch(Exception e) {
            fail("Should not throw exception");
        }
    }
 
    @Test
    /**
     * Test: add 1 unit of coffee, milk, sugar, and chocolate
     * Expected Behavior:
     */
    public void testAddInventoryValid() {
        CoffeeMaker CM = new CoffeeMaker();
        try {
            CM.addInventory("1", "1", "1", "1");
        }  catch (Exception e) {
            fail("Should not fail");
        }
    }
   
    @Test
    /**
     * Test: add 1 unit of coffee, milk, and chocolate, and -1 units of sugar
     * Expected Behavior: should fail
     */
    public void testAddInventoryInvalid() {
        CoffeeMaker CM = new CoffeeMaker();
        try {
            CM.addInventory("1", "1", "-1", "1");
            fail("Should fail");
        }  catch (Exception e) {
           
        }
    }  
   
    @Test
    /**
     * Test: call checkInventory on a CM with no added inventory.
     * Expected Behavior: should not return null, should not throw exception
     * @throws InventoryException
     */
    public void testCheckInventoryEmpty() throws InventoryException {
        CoffeeMaker CM = new CoffeeMaker();
       
        try {
            assertNotNull("Shouldn't be null", CM.checkInventory());
        } catch (Exception e) {
            fail("Shouldn't throw exception");
        }
    }
   
    @Test
    /**
     * Test: call checkInventory on a CM with inventory
     * Expected Behavior: should not return null, should not throw exception
     * @throws InventoryException
     */
    public void testCheckInventoryNonEmpty() throws InventoryException {
        CoffeeMaker CM = new CoffeeMaker();
        CM.addInventory("1","1","1","1");
        try {
            assertNotNull("Shouldn't be null", CM.checkInventory());
        } catch (Exception e) {
            fail("Shouldn't throw exception");
        }
    }
   
    @Test
    public void testMakeCoffeeWithInventoryAndExactChange() throws InventoryException {
        CoffeeMaker CM = new CoffeeMaker();
        CM.addRecipe(valid_rep1);
        CM.addInventory("3","1","2","3");
       
        final int REP1_PRICE = valid_rep1.getPrice();
        try {
            assertEquals("0 change should be issued when paying with exact change", 0, CM.makeCoffee(0, REP1_PRICE));
        } catch (Exception e) {
            fail("Should not fail");
        }
    }
   
    @Test
    public void testMakeCoffeeWithNoInventory() throws InventoryException {
        CoffeeMaker CM = new CoffeeMaker();
        final int AMT_PAID = 1;
        try {
            assertEquals("0 change should be issued when paying with exact change", AMT_PAID, CM.makeCoffee(0, AMT_PAID));
        } catch (Exception e) {
            fail("Should not fail");
        }
    }
   
    @Test
    public void testMakeCoffeeWithInventoryNotEnoughPaid() throws InventoryException {
        CoffeeMaker CM = new CoffeeMaker();
        final int AMT_PAID = valid_rep1.getPrice() - 1;
        CM.addRecipe(valid_rep1);
        CM.addInventory("3","1","2","3");
        try {
            assertEquals("User's change should be issued when the user did not insert enough change", AMT_PAID, CM.makeCoffee(0, AMT_PAID));
        } catch (Exception e) {
            fail("Should not fail");
        }
    }
   
    @Test
    public void testMakeCoffeeWithNotEnoughInventoryButEnoughPaid() throws InventoryException {
        CoffeeMaker CM = new CoffeeMaker();
        final int AMT_PAID = valid_rep1.getPrice();
        CM.addRecipe(valid_rep1);
        CM.addInventory("1","1","1","1");
        try {
            assertEquals("User's change should be issued when there is not enough inventory", AMT_PAID, CM.makeCoffee(0, AMT_PAID));
        } catch (Exception e) {
            fail("Should not fail");
        }
    }
   
   
   
   
}