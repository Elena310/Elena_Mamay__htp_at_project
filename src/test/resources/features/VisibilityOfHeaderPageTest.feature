Feature: Visibility of header on the Booking page


Scenario: When user login to Booking site, all elements in the header should be displayed

Given ("I start")
When I go to booking page
And I go to login page
And I enter email address
And I enter password
Then I check that all elements in the header are displayed

