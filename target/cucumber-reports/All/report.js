$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/petstore.feature");
formatter.feature({
  "name": "PetStore",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@petstorefeature"
    }
  ]
});
formatter.scenario({
  "name": "verify petstore",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@petstorefeature"
    },
    {
      "name": "@petstore"
    }
  ]
});
formatter.step({
  "name": "I get the available pets",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.i_get_the_available_pets()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify status of first pet as \"available\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.i_verify_pet_is_available_in_the_list(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add a new available pet \"peta\" to the store",
  "keyword": "Then "
});
