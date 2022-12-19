Feature: Salesforce with resuable files

  Background:
    Given launch URL

  @xyx
  Scenario: Login
    When US and PW
    And Click login
    Then Validate error

    @DropList
  Scenario: 2 Dropdown Handling Using List
    When Iterate the dropdown value with the help of list

      @LinkList
  Scenario: Count Links with the help of set
    When count links using list

        @New
        Scenario:  Demo
          Given Hello
          When Hi
          Then ZYZ

