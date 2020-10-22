@petstorefeature
Feature: PetStore

  @petstore
  Scenario: verify petstore
  Given I get the available pets 
  Then I verify status of first pet as "available"
  Then I add a new available pet "beagu" to the store
  And I verify pet "beagu" is added
  Then I update status of pet "beagu" to "sold"
  And I verify status of pet "beagu" updated to "sold" successsfully
  Then I delete pet "beagu"
  And I verify pet "beagu" deleted successfully