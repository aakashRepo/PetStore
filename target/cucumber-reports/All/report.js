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
  "name": "I verify status code as \"200\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.i_verify_status_code(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add a new available pet \"beagu2\" to the store",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.i_add_a_new_available_pet_to_the_store(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify pet \"beagu2\" is added",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.i_verify_pet_is_added(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I update status of pet \"beagu2\" to \"sold\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.i_updae_status_of_pet_to(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify status of pet \"beagu2\" updated to \"sold\" successfully",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.i_verify_status_of_pet_updated_to_successsfully(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I delete pet \"beagu2\"",
  "keyword": "Then "
});
