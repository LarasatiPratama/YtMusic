Feature: YoutubeMusic play test

  Scenario Outline: User wants to play a song by searching the song title
    Given Open web url "http://music.youtube.com/"
    And User click search button
    And User input "<keywords>"
    And User press Enter
    When User click on the result
    Then the song is playing

    Examples:
      |keywords|
      |give it away|