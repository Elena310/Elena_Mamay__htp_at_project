Feature: Cinema

Scenario: Search movie

Given I open an app
When I search for <search word> word
Then I see each  movie item in the list contains <search word> in the title or description



