Feature: Search by keyword

  Rule: User can search using any term

    Example: Searching for a term
      Given Sergey is researching things on the internet
      When he looks up "Cucumber"
      Then he should see information about "Cucumber"

