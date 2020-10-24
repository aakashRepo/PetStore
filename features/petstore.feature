@petstorefeature
Feature: PetStore

  @petstore
  Scenario: verify petstore
  Given I get the available pets 
  Then I verify status code as "200"
  Then I add a new available pet "beagu2" to the store
  And I verify pet "beagu2" is added
  Then I update status of pet "beagu2" to "sold"
  And I verify status of pet "beagu2" updated to "sold" successfully
  Then I delete pet "beagu2"
  And I verify pet "beagu2" deleted successfully