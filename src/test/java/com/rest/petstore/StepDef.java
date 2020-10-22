package com.rest.petstore;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StepDef {

    private static Response resp;
    private static String baseUri = "https://petstore.swagger.io/v2/pet";

    @Given("^I get the available pets$")
    public void i_get_the_available_pets() {
	String getAvailablePets = "/findByStatus?status=available";
	resp = given().get(baseUri + getAvailablePets);
	resp.then().log().all();
    }

    @Then("^I verify status of first pet as \"([^\"]*)\"$")
    public void i_verify_pet_is_available_in_the_list(String arg1) {
	String pet = resp.then().contentType(ContentType.JSON).extract().path("[0].status");
	Assert.assertTrue("Incorrect value fetched from json. Expected: " + arg1 + " Actual: " + pet,
		pet.equalsIgnoreCase(arg1));
    }

    @Then("^I add a new available pet \"([^\"]*)\" to the store$")
    public void i_add_a_new_available_pet_to_the_store(String arg1) {
	String json = "{\n" + "  \"id\": 0,\n" + "  \"category\": {\n" + "    \"id\": 0,\n"
		+ "    \"name\": \"string\"\n" + "  },\n" + "  \"name\": \"beagu\",\n" + "  \"photoUrls\": [\n"
		+ "    \"string\"\n" + "  ],\n" + "  \"tags\": [\n" + "    {\n" + "      \"id\": 176,\n"
		+ "      \"name\": \"string\"\n" + "    }\n" + "  ],\n" + "  \"status\": \"available\"\n" + "}";

	resp = given().when().body(json).post(baseUri + "/pet");
	System.out.println("Status code: " + resp.getStatusCode());
	int statusCode = resp.getStatusCode();
	Assert.assertTrue("Issue while adding new pet", statusCode == 200);
    }

    @Then("^I verify pet \"([^\"]*)\" is added$")
    public void i_verify_pet_is_added(String arg1) {

    }

    @Then("^I update status of pet \"([^\"]*)\" to \"([^\"]*)\"$")
    public void i_updae_status_of_pet_to(String arg1, String arg2) {
    }

    @Then("^I verify status of pet \"([^\"]*)\" updated to \"([^\"]*)\" successsfully$")
    public void i_verify_status_of_pet_updated_to_successsfully(String arg1, String arg2) {
    }

    @Then("^I delete pet \"([^\"]*)\"$")
    public void i_delete_pet(String arg1) {
    }

    @Then("^I verify pet \"([^\"]*)\" deleted successfully$")
    public void i_verify_pet_deleted_successfully(String arg1) {
	// Write code here that turns the phrase above into concrete actions
	throw new PendingException();
    }

}
