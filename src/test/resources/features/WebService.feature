Feature: Search users

Scenario Outline: Search users by username

Given I start search all users by <index>
When I search users by strict long name
And I search users by strict short name
And I search users by partial long name
Then I search users by partial short name and I validate the web service response <resultName>
Examples:
| index | resultName             |
| 0     | "ALL_USERS"            |
| 1     | "STRICT_LONG_NAME"     |
| 2     | "STRICT_SHORT_NAME"    |
| 3     | "PARTIAL_LONG_NAME"    |
| 4     | "PARTIAL_SHORT_NAME"   |