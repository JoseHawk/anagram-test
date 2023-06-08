Feature: The user checks if two words are anagrams

  Background: The user is using the application to check if two words are anagrams

  Scenario: User calls the simple anagram end-point with two words without choosing to remove special characters
    When The user checks for simple anagram comparison without removing special characters
    Then The user receives a response saying that is not an anagram

  Scenario: User calls the simple anagram end-point with two words choosing to remove special characters
    When The user checks for simple anagram comparison removing special characters
    Then The user receives a response saying that is an anagram

  Scenario: User calls the meaningful anagram end-point with two words choosing to remove special characters
    When The user checks for meaningful anagram comparison removing special characters
    Then The user receives a response saying that is an anagram but not meaningful