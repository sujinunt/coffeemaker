Feature: User add recipe, delete recipe and purchase beverage.

Scenario: add recipe
 	Given I create new recipe is Mocha
 	Then add Mocha recipe

 Scenario: delete recipe
 	Given Have Mocha recipe
 	When I delete Mocha recipe
 	Then The recipe is gone
 	
 Scenario: purchase beverage
 	Given Have Coffee recipe
 	When I purchase Coffee
 	Then Paid 75 and I got change 25