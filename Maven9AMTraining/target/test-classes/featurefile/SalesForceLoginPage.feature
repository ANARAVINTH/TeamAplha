Feature: To validate the functionality of salesforce login page

  @SmokeTest
  Scenario: To validate the login functionality with valid username
    Given User Navigates to the salesforce login page
    When User Enter the Username "Apple" and password "123"
    And User clicks the login button
    Then User should navigate to the homepage

   @RegressionTest
  Scenario: To validate the login functionality with invalid username
    Given User Navigates to the salesforce login page
    When User Enter the Username "LearnMore" and password "4567"
    And User clicks the login button
    Then User Validate the error message

   @PerformanceTest @RegressionTest
  Scenario Outline:  To validate the login functionality with multiple username
    Given User Navigates to the salesforce login page
    When User Enter the Username "<username>" and password "<password>"
    And User clicks the login button
    Then User should navigate to the homepage
    Examples:
      | username  | password |
      | Aksya     | 1234     |
      | Keerthana | ehehe    |
      | Raja      | 567      |
      | Ranjith   | 3445     |

  @StaticDropdown
  Scenario:  To Handle the static dropdown
    Given User Navigate to the required URL
    Then User selects the values from the dropdown
    And User get the dropdown value

  @DynamicDropdown
  Scenario:  To Handle the dynamic dropdown
    Given User Navigate to the required URL
    Then User selects the values from the dynamic dropdown

@AutoSuggestive
  Scenario: To Handle Auto Suggestive dropdown
    Given User Navigate to the required URL
    Then User selects the value from Autosuggestive dropdown

@Frame
Scenario: To Handle Frame & Mouse Actions
  Given User Navigate to the required URL
  Then Handle the frame

  @Table
  Scenario:  Tablel Handling
    Given User Navigate to the required URL
    Then handle frame

  @CountLinks
  Scenario: Links
     Given User Navigate to the required URL
    Then count links
    And Handle Calander

