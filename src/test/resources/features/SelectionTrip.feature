Feature: Select different trips

Scenario: Check price of Moscow trip

Given I choose "Москва" at 5 for 10
Then ^I verify Moscow Trip$

Scenario: Check style changes of address trip

Given I choose "Осло" at 1 for 1
Then I verify color

Scenario: Check the price of Paris trip

Given I choose "Париж" at 3 for 10
Then ^I verify Paris Trip$



