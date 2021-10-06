Feature: Search by keyword
  As a normal user
  I want to be able to seacrh for interesting things
  In order to learn new things

  Rule: User can search using any term
  User should be able to search using any term

    Example: Searching for a term
      Given Sergey is researching things on the internet
      When he looks up "Cucumber"
      Then he should see information about "Cucumber"

    Example: Try to search without term
      Given Sergey is researching things on the internet
      When he tries to search without typing any term
      Then he should see an advance search page


