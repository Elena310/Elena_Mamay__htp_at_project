Feature: Visibility of header on the Booking page

Scenario: When user login to Booking site, all elements in the header should be displayed

Given ("I start")
When I turn up on the page "https://booking.com/"
And I go to login page
And I enter email address
And I enter password
And User is redirected to home page
Then the all elements in the header are displayed and consistent with "<elements>"

|elements|
|logo|
|home icon|
|flights icon|
|car rentals icon|
|attraction icon|
|airport taxis icon|
|currency icon|
|language icon|
|email icon|
|question icon|
|property icon|
|avatar icon|
|your account|