Feature: Search feature

  Scenario Outline: User wants to search a song, artist, or combination of both
    Given Open web url "http://music.youtube.com"
    When User click search button
    And User input "<keywords>"
    And User press Enter
    Then Showing top result(s) on result page

    Examples:
      |keywords|
      |polyphia yas|
      |plini       |
      |selenium forest|

  Scenario Outline: User wants to search a song using invalid keyword
    Given Open web url "http://music.youtube.com"
    When User click search button
    And User input "<keywords>"
    And User press Enter
    Then Showing No result

    Examples:
      |keywords|
      |!(**(^^^^^^^^^^^^(*%%%%%|