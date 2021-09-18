Feature: User add recipe, delete recipe and purchase beverage.

Scenario: add recipe
 	Given I create new recipe is Mocha
 	Then add Mocha recipe

 Scenario: delete recipe
 	Given Have Mocha recipe
 	When I delete Mocha recipe
 	Then The recipe is gone
 	
 Scenario: purchase beverage
 	Given Have Mocha recipe
 	When I purchase Mocha price 100
 	Then Paid 100 and I got change 25