Feature: Validate VelocityEcom application dashboard
  Scenario: Validate Dashboard
    Given user clicks on admin button of VelocityEcom application
    When user enters userName as "9923478751"
     And user enters password as "Velocity@123"
     And user clicks on access dashboard button
    Then user navigates to VelocityEcom dashboard page and validate details

Scenario: Validate Inventory update details
    Given user clicks on admin button of VelocityEcom application
    When user enters userName as "9923478751"
    And user enters password as "Velocity@123"
    And user clicks on access dashboard button
    And user clicks on Inventory update
    Then user validates total entries, open_partial, fullyreceived orders