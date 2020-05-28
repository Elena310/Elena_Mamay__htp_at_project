Feature: The highest hotel price
Scenario: Compare price of hotel with daily hotel price. When user filters hotels with maximum price for the day,
hotels should be filtered with relevant price.

Given ("I start the test")
When I go to the page "https://booking.com/"
And I select any trip with parameters: city, date of arriving, duration, adults, rooms, children
And I choose hotels with maximum price for the day
And I filter hotels starting with a low-cost
And I compare price of hotel with daily price
Then the price should be "<expected>"

|city|           date_of_arriving|   duration|  adults|     rooms|    children|   expected|
|Value-"Москва"  |Value-10|          Value-5|   Value-4|    Value-2|  Value-0|    price of hotel >= daily hotel price|
| Value-"Париж"  |Value-3|           Value-7|   Value-4|    Value-2|  Value-0|    price of hotel >= daily hotel price|
| Value-"Oslo"   |Value-1|           Value-1|   Value-2|    Value-1|  Value-1|    price of hotel >= daily hotel price|