Feature: Booking registration with new temporary email

Scenario: User can create new temporary email on "https://trashmail.com"
and create new account with temporary email on the "https://booking.com"

Given ("Test is started")
When I navigate to the  home page "https://trashmail.com/"
And I open login page
And I enter existing username
And I enter  existing password
And I turn up on the my home page
And I add new temporary email
When I switch to home page "https://booking.com"
And I choose registration option
And I enter new temporary trashmail email in the email address field
And I enter any new password in the password field
And I confirm my password in the confirm password field
And I create my account
Then I check that Welcome modal is displayed after successful registration




