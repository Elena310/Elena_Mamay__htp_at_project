Feature: Cinema

Scenario: Login app no such user

Given I turn up on the home page
When I login with wrong <login> and wrong <password>
Then I see warning message