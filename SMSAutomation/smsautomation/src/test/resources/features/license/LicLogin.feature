Feature: To verify that the user is able to log into the licensee portal, access the homepage and then log out 
	Existing user should be able to log into License SMS using correct credentials
Scenario: Log in, Access the License Portal and Log out of SMS Mastermind Portal 
	Given User navigate to License url 
	And User enters valid username 
	And User enters valid password 
	When User clicks on the SignIn button 
	Then User is taken to the License homepage
	And User click the Username displayed on the side menu
	And User clicks Sign Out option
	Then User is successfully signed out 
	
	
	
	