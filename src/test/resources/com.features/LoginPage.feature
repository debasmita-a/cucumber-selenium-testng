Feature: Login functionality for OpenCart E-comm application

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forgot Password Link
Given user is on login page
Then forgot password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "debasmita24"
And user enters password "cucumber@24!"
And user clicks on Login button
Then user gets the title of the home page
And page title should be "My account - My Store"
