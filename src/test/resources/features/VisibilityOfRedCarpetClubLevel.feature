Feature: Cinema

Scenario: Login app

Given I navigate to the app
When I login with <login> and <password>
Then I can see Red Carpet Club <level> in upper right corner