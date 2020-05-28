Feature: Changing the style of hotel address

Scenario: Change  text color of hotel address to red and change background color of hotel to green

Given ("I begin to run test")
When I navigate to the page "https://booking.com/"
And I pick any trip with parameters: city, date of arriving, duration, adults, rooms, children
And I choose hotels with 3 and 4 stars
And I scroll to the tenth hotel in the list of hotels
And I move cursor to the address of tenth hotel
And I change background color of hotel address to green
And I change text color of hotel address to red
Then I check that text color of hotel address is red

