package test;

//JUnit imports
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//Core Imports
import edu.ncsu.csc326.coffeemaker.Inventory;
import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class InventoryTest 
{
	//Defined in setUp() method
	private Inventory invent;
	
	@Before
	public void setUp() throws Exception 
	{
		invent = new Inventory();
	}
	
	@Test //Test the default values
	public void test1() {
		invent = new Inventory();
		Assert.assertEquals(15, invent.getChocolate());
		Assert.assertEquals(15, invent.getCoffee());
		Assert.assertEquals(15, invent.getMilk());
		Assert.assertEquals(15, invent.getSugar());
	}
	
	@Test  //Test the simple set for each item
	public void test2() {
		invent = new Inventory();
		invent.setChocolate(10);
		Assert.assertEquals(10, invent.getChocolate());
		
		invent.setCoffee(10);
		Assert.assertEquals(10, invent.getCoffee());
		
		invent.setMilk(10);
		Assert.assertEquals(10, invent.getMilk());
		
		invent.setSugar(0);
		Assert.assertEquals(0, invent.getSugar());
	}
	
	
	@Test  //Test setting  negative values for each item
	public void test3() {
		invent = new Inventory();
		invent.setChocolate(-1);
		Assert.fail("Fail: No a valid value");
		
		invent.setCoffee(-4);
		Assert.fail("Fail: No a valid value");
		
		invent.setMilk(-6);
		Assert.fail("Fail: No a valid value");
		
		invent.setSugar(-100);
		Assert.fail("Fail: No a valid value");
	}
	
	@Test  //Test consecutive additions
	public void test4() {
		invent = new Inventory();
		
		try {
			invent.addChocolate("3");
			invent.addChocolate("0");
			invent.addChocolate("2");
			
		} catch (InventoryException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(20, invent.getChocolate());
	}
	
	@Test  //Test the add method for positive values and zero
	public void test5() {
		Inventory invent = new Inventory();
		
		try {
			invent.addMilk("3");
			invent.addSugar("0");
			invent.addChocolate("2");
			invent.addCoffee("100");
			
		} catch (InventoryException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(18, invent.getMilk());
		Assert.assertEquals(15, invent.getSugar());
		Assert.assertEquals(17, invent.getChocolate());
		Assert.assertEquals(115, invent.getCoffee());
	}
	
	@Test //Test the add method for invalid values
	public void test6v1() {
		Inventory invent = new Inventory();
		
		try {
			invent.addMilk("-3");
			Assert.fail("Fail: No a valid value");
			
		} catch (InventoryException e) {
			e.printStackTrace();
		}
	}
	
	@Test //Test the add method for invalid values
	public void test6v2() {
		Inventory invent = new Inventory();
		
		try {
			
			invent.addChocolate("0.0");
			Assert.fail("Fail: No a valid value");
			
		} catch (InventoryException e) {
			e.printStackTrace();
		}
	}
	
	@Test //Test the add method for invalid values
	public void test6v3() {
		Inventory invent = new Inventory();
		
		try {
			
			invent.addSugar("18.2");
			Assert.fail("Fail: No a valid value");
			
		} catch (InventoryException e) {
			e.printStackTrace();
		}
	}
	
	@Test //Test the add method for invalid values
	public void test6v4() {
		Inventory invent = new Inventory();
		
		try {
			
			invent.addCoffee(("-18"));
			Assert.fail("Fail: No a valid value");
			
		} catch (InventoryException e) {
			e.printStackTrace();
		}
	}
	
	@Test //Test the add method for invalid values
	public void test6v5() {
		Inventory invent = new Inventory();
		
		try {
			
			invent.addCoffee("14.5");
			Assert.fail("Fail: No a valid value");
			
		} catch (InventoryException e) {
			e.printStackTrace();
		}
	}
	
	@Test //Test the add method for invalid values
	public void test6v6() {
		Inventory invent = new Inventory();
		
		try {
			
			invent.addSugar("14.5");
			Assert.fail("Fail: No a valid value");
			
		} catch (InventoryException e) {
			e.printStackTrace();
		}
	}
	
	@Test //Test the add method for invalid values
	public void test6v7() {
		Inventory invent = new Inventory();
		
		try {
			
			invent.addMilk("-2");
			Assert.fail("Fail: No a valid value");
			
		} catch (InventoryException e) {
			e.printStackTrace();
		}
	}
	
	@Test //Test the add method for invalid values
	public void test6v8() {
		Inventory invent = new Inventory();
		
		try {
			
			invent.addChocolate("-2");
			Assert.fail("Fail: No a valid value");
			
		} catch (InventoryException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test //Test the use useIngredients method for the default recipe
	public void test7() {
		Inventory invent = new Inventory();
		Recipe recipe = new Recipe();
		Assert.assertTrue(invent.useIngredients(recipe));
	}
	
	@Test //Test the use useIngredients method for one recipe
	public void test8() {
		Inventory invent = new Inventory();
		Recipe recipe = new Recipe();
		try {
			recipe.setAmtChocolate("15");
			recipe.setAmtMilk("16");
			recipe.setAmtSugar("12");
			Assert.assertFalse(invent.useIngredients(recipe));
			
		} catch (RecipeException e) {
			e.printStackTrace();
		}
	}
	
	@Test //Test the use useIngredients method for one recipe
	public void test9() {
		Inventory invent = new Inventory();
		Recipe recipe = new Recipe();
		try {
			recipe.setAmtChocolate("18");
			recipe.setAmtMilk("14");
			recipe.setAmtSugar("12");
			Assert.assertFalse(invent.useIngredients(recipe));
			
		} catch (RecipeException e) {
			e.printStackTrace();
		}
	}
	
	@Test //Test the use useIngredients method for one recipe
	public void test10() {
		Inventory invent = new Inventory();
		Recipe recipe = new Recipe();
		try {
			recipe.setAmtChocolate("11");
			recipe.setAmtMilk("14");
			recipe.setAmtSugar("120");
			recipe.setAmtCoffee("29");
			Assert.assertFalse(invent.useIngredients(recipe));
			
		} catch (RecipeException e) {
			e.printStackTrace();
		}
	}
	
	@Test //Test the use toString method for the default inventory
	public void test11() {
		Inventory invent = new Inventory();
		String expected = "Coffee: " + 15 + "\n" + "Milk: " + 15 + 
				"\n" + "Sugar: " + 15 + "\n" + "Chocolate: " + 15 + "\n";
		Assert.assertEquals(expected, invent.toString());
	}

}//InventoryTest class.
