/*
 * Copyright (c) 2009,  Sarah Heckman, Laurie Williams, Dright Ho
 * All Rights Reserved.
 * 
 * Permission has been explicitly granted to the University of Minnesota 
 * Software Engineering Center to use and distribute this source for 
 * educational purposes, including delivering online education through
 * Coursera or other entities.  
 * 
 * No warranty is given regarding this software, including warranties as
 * to the correctness or completeness of this software, including 
 * fitness for purpose.
 * 
 * 
 * Modifications 
 * 20171114 - Ian De Silva - Updated to comply with JUnit 4 and to adhere to 
 * 							 coding standards.  Added test documentation.
 */
package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

/**
 * Unit tests for CoffeeMaker class.
 * 
 * @author Sarah Heckman
 */
public class CoffeeMakerTest {
	
	/**
	 * The object under test.
	 */
	private CoffeeMaker coffeeMaker;
	
	// Sample recipes to use in testing.
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;
	private Recipe recipe5;
	private Recipe recipe6;
	private Recipe recipe7;
	private Recipe recipe8;
	private Recipe recipe9;

	/**
	 * Initializes some recipes to test with and the {@link CoffeeMaker} 
	 * object we wish to test.
	 * 
	 * @throws RecipeException  if there was an error parsing the ingredient 
	 * 		amount when setting up the recipe.
	 */
	@Before
	public void setUp() throws RecipeException {
		coffeeMaker = new CoffeeMaker();
		
		//Set up for r1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for r2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for r3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for r4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");
		
		//Set up for r5
		recipe5 = new Recipe();
		recipe5.setName("Milo");
		recipe5.setAmtChocolate("5");
		recipe5.setAmtCoffee("0");
		recipe5.setAmtMilk("10");
		recipe5.setAmtSugar("10");
		recipe5.setPrice("20");
		
		//Set up for r6
		recipe6 = new Recipe();
		recipe6.setName("Big Chocolate");
		recipe6.setAmtChocolate("100");
		recipe6.setAmtCoffee("0");
		recipe6.setAmtMilk("0");
		recipe6.setAmtSugar("0");
		recipe6.setPrice("100");
		
		//Set up for r7
		recipe7 = new Recipe();
		recipe7.setName("Big Coffee");
		recipe7.setAmtChocolate("0");
		recipe7.setAmtCoffee("100");
		recipe7.setAmtMilk("0");
		recipe7.setAmtSugar("0");
		recipe7.setPrice("100");
		
		//Set up for r8
		recipe8 = new Recipe();
		recipe8.setName("Big Milk");
		recipe8.setAmtChocolate("0");
		recipe8.setAmtCoffee("0");
		recipe8.setAmtMilk("100");
		recipe8.setAmtSugar("0");
		recipe8.setPrice("100");
		
		//Set up for r9
		recipe9 = new Recipe();
		recipe9.setName("Big Sugar");
		recipe9.setAmtChocolate("0");
		recipe9.setAmtCoffee("0");
		recipe9.setAmtMilk("0");
		recipe9.setAmtSugar("100");
		recipe9.setPrice("100");

	}
	
	/**
	 * Given a coffee maker with valid recipe
	 * When we add recipe.
	 * Then we not get any error.
	 */
	@Test
	public void testAddRecipe() {
		assertTrue(coffeeMaker.addRecipe(recipe1));
		assertTrue(coffeeMaker.addRecipe(recipe2));
		assertTrue(coffeeMaker.addRecipe(recipe3));
		assertTrue(coffeeMaker.addRecipe(recipe4));
	}
	
	/**
	 * Given a coffee maker with duplicate recipe
	 * When we add the same recipe.
	 * Then we should get false.
	 */
	@Test
	public void testAddDuplicateRecipe() {
		coffeeMaker.addRecipe(recipe5);
		assertFalse(coffeeMaker.addRecipe(recipe5));
	}
	
	/**
	 * Given a coffee maker with one valid recipe.
	 * When we delete a recipe.
	 * Then we should get the coffee name that we delete.
	 */
	@Test
	public void testDeleteRecipe(){
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		assertEquals("Mocha", coffeeMaker.deleteRecipe(1));
	}

	/**
	 * Given a coffee maker with nothing
	 * When we delete the recipe in the empty recipe list.
	 * Then we should get null.
	 */
	@Test 
	public void testDeleteRecipeInEmptyList(){
		assertEquals(null, coffeeMaker.deleteRecipe(0));
	}
	
	/**
	 * Given a coffee maker with one valid recipe 
	 * When we edit the recipe it.
	 * Then the recipe name should not change.
	 */
	@Test
	public void testEditRecipe(){
		coffeeMaker.addRecipe(recipe5);
		assertEquals("Milo", coffeeMaker.editRecipe(0, recipe3));
	}

	/**
	 * Given a coffee maker with one valid recipe
	 * When we edit the recipe that not the recipe that we add.
	 * Then we should get null.
	 */
	@Test 
	public void testEditRecipeNotInList(){
		coffeeMaker.addRecipe(recipe5);
		assertEquals(null, coffeeMaker.editRecipe(1, recipe1));
	}
	
	/**
	 * Given a coffee maker with nothing
	 * When we edit the recipe.
	 * Then we should get null.
	 */
	@Test 
	public void testEditRecipeInEmptyList(){
		assertEquals(null, coffeeMaker.editRecipe(0, recipe1));
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with well-formed quantities
	 * Then we do not get an exception trying to read the inventory quantities.
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test
	public void testAddInventory() throws InventoryException {
		coffeeMaker.addInventory("4","7","0","9");
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add coffee to inventory with negative quantity
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddCoffeeWithNegativeQuantity() throws InventoryException {
		coffeeMaker.addInventory("-1", "1", "1", "1");
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add milk to inventory with negative quantity
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddMilkWithNegativeQuantity() throws InventoryException {
		coffeeMaker.addInventory("1", "-1", "1", "1");
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add sugar to inventory with negative quantity
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddSugarWithNegativeQuantity() throws InventoryException {
		coffeeMaker.addInventory("1", "1", "-1", "1");
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add chocolate to inventory with negative quantity
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddChocolateWithNegativeQuantity() throws InventoryException {
		coffeeMaker.addInventory("1", "1", "-1", "-1");
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add coffee to inventory with non-numeric string
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddCoffeeWithNonNumericString() throws InventoryException {
		coffeeMaker.addInventory("Coffee", "1", "1", "1");
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add milk to inventory with non-numeric string
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddMilkWithNonNumericString() throws InventoryException {
		coffeeMaker.addInventory("1", "Milk", "1", "1");
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add sugar to inventory with non-numeric string
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddSugarWithNonNumericString() throws InventoryException {
		coffeeMaker.addInventory("1", "1", "Sugar", "1");
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add chocolate to inventory with non-numeric string
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddChocolateWithNonNumericString() throws InventoryException {
		coffeeMaker.addInventory("1", "1", "-1", "Chocolate");
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with well-formed quantities
	 * Then the result should match the expected result.
	 */
	@Test 
	public void testCheckInventory() throws InventoryException {
		coffeeMaker.addInventory("4","7","0","9");
		String result = "Coffee: 19\nMilk: 22\nSugar: 15\nChocolate: 24\n";
		assertEquals(result, coffeeMaker.checkInventory());
	}
	
	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying more than 
	 * 		the coffee costs
	 * Then we get the correct change back.
	 */
	@Test
	public void testMakeCoffee() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals(25, coffeeMaker.makeCoffee(0, 75));
	}
	
	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe but not deposit enough money
	 * Then the user money should return.
	 */
	@Test
	public void testMakeCoffeeButNotDepositEnoughMoney() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals(49, coffeeMaker.makeCoffee(0, 49));
	}
	
	/**
	 * Given a coffee maker with null recipe
	 * When we make coffee with null recipe
	 * Then we get the change back.
	 */
	@Test
	public void testMakeNullCoffee() {
		assertEquals(75, coffeeMaker.makeCoffee(0, 75));
	}
	
	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee with the over amount stock of chocolate 
	 * Then we get the change back.
	 */
	@Test
	public void testMakeCoffeeButOverAmountStockOfChocolate(){
		coffeeMaker.addRecipe(recipe6);
		assertEquals(100, coffeeMaker.makeCoffee(0, 100));

	}
	
	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee with the over amount stock of coffee
	 * Then we get the change back.
	 */
	@Test
	public void testMakeCoffeeButOverAmountStockOfCoffee(){
		coffeeMaker.addRecipe(recipe7);
		assertEquals(100, coffeeMaker.makeCoffee(0, 100));

	}
	
	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee with the over amount stock of milk
	 * Then we get the change back.
	 */
	@Test
	public void testMakeCoffeeButOverAmountStockOfMilk(){
		coffeeMaker.addRecipe(recipe8);
		assertEquals(100, coffeeMaker.makeCoffee(0, 100));

	}
	
	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee with the over amount stock of sugar 
	 * Then we get the change back.
	 */
	@Test
	public void testMakeCoffeeButOverAmountStockOfSugar(){
		coffeeMaker.addRecipe(recipe9);
		assertEquals(100, coffeeMaker.makeCoffee(0, 100));

	}
	

	
	

}
