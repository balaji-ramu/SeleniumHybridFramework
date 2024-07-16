Feature: Dashboard page feature

  Background: 
    Given user has already logged in to application
      | username | password |
      | Admin    | admin123 |

  Scenario: Dashboard menu counts
    Given user is on Dashboard page
    Then user views hamburger menu options
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |
      | Claim       |
      | Buzz        |
    And accounts section count should be 12
