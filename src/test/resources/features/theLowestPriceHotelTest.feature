Feature: The lowest hotel price
Scenario: Compare price of hotel with daily hotel price. When user filters hotels with minimum price for the day,
hotels should be filtered with relevant price.

Given ("I start driver")
When I open the page "https://booking.com/"
And I choose any trip with parameters: city, date of arriving, duration, adults, rooms, children
And I filter hotels with minimum price
And I compare price of hotel with daily hotel price
Then the result should be "<expected>"

|city|           date_of_arriving|   duration|  adults|     rooms|    children|   expected|
|Value-"Москва"  |Value-10|          Value-5|   Value-4|    Value-2|  Value-0|    price of hotel <= daily hotel price|
| Value-"Париж"  |Value-3|           Value-7|   Value-4|    Value-2|  Value-0|    price of hotel <= daily hotel price|
| Value-"Oslo"   |Value-1|           Value-1|   Value-2|    Value-1|  Value-1|    price of hotel <= daily hotel price|