Feature: Booking registration with new temporary email

Scenario: User can create new temporary email on "https://trashmail.com"
and create new account with temporary email on the "https://booking.com"

Given ("Test is started")
When I get temporary address
And I navigate to booking page
And I choose registration option
And I enter new temporary email in the email address field
And I enter new password in the password field
And I confirm my password and create new account
Then I check that Welcome modal is displayed after successful registration




