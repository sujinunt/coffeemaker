package edu.ncsu.csc326.coffeemaker;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import io.cucumber.java.en.*;

public class CoffeeMakerCucumberTest {
	
	private CoffeeMaker coffeeMaker;
	
	// Sample recipes to use in testing.
	private Recipe recipe1;
	
	@Given("I create new recipe is {String}")
	public void iAddCreateRecipe(String recipe_name) throws RecipeException {
		recipe1 = new Recipe();
		recipe1.setName(recipe_name);
		recipe1.setAmtChocolate("20");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("75");
	}
	
	@Then("add {String} recipe")
	public void iAddRecipe(String recipe_name) {
		assertTrue(coffeeMaker.addRecipe(recipe1));
	}
	
	@Given("Have {String} recipe")
	public void haveRecipe(String recipe_name) throws RecipeException {
		recipe1 = new Recipe();
		recipe1.setName(recipe_name);
		recipe1.setAmtChocolate("20");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("75");
		coffeeMaker.addRecipe(recipe1);
	}
	
	@When("I delete {String} recipe")
	public void iDeleteRecipe(String recipe_name) {
		assertEquals(recipe_name, coffeeMaker.deleteRecipe(0));
	}
	
	@Then("The recipe is gone")
	public void deleteRecipeResult() {
		assertEquals(null, coffeeMaker.deleteRecipe(0));
	}
	
	@When("I purchase {String} price {int}")
	public void iPurchaseBeverage(String recipe_name, int money) {
		assertEquals(25, coffeeMaker.makeCoffee(0, money));
	}
	
	@Then("Paid {int} and I got change {int}")
	public void iGotChange(int money_paid, int money_change) {
		assertEquals(money_change, coffeeMaker.makeCoffee(0, money_paid));
	}
	
}