package com.rest.petstore;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;
import io.restassured.response.Response;

public class StepDef {

    private static Response resp;
    private static String baseUri = "https://petstore.swagger.io/v2/pet";
    static String petId = null;

    @Given("^I get the available pets$")
    public void i_get_the_available_pets() {
	String getAvailablePets = "/findByStatus?status=available";
	resp = given().get(baseUri + getAvailablePets);
	resp.then().log().all();
    }

    @Then("^I verify status code as \"([^\"]*)\"$")
    public void i_verify_status_code(String arg1) {
	String code = String.valueOf(resp.getStatusCode());
	Assert.assertTrue("Expected: " + arg1 + " Actual: " + code, arg1.equalsIgnoreCase(code));
    }

    @Then("^I add a new available pet \"([^\"]*)\" to the store$")
    public void i_add_a_new_available_pet_to_the_store(String arg1) {
	Random r = new Random();
	petId = String.valueOf(r.nextInt(1000));
	String json = "{\n" + "  \"id\": 0,\n" + "  \"category\": {\n" + "    \"id\": petId,\n"
		+ "    \"name\": \"string\"\n" + "  },\n" + "  \"name\": \"petName\",\n" + "  \"photoUrls\": [\n"
		+ "    \"string\"\n" + "  ],\n" + "  \"tags\": [\n" + "    {\n" + "      \"id\": 0,\n"
		+ "      \"name\": \"string\"\n" + "    }\n" + "  ],\n" + "  \"status\": \"available\"\n" + "}";
	json = json.replace("petName", arg1).replace("petId", petId);
	resp = given().when().headers("content-type", "application/json").body(json).post(baseUri);
	System.out.println("Status code: " + resp.getStatusCode());
	int statusCode = resp.getStatusCode();
	Assert.assertTrue("Issue while adding new pet", statusCode == 200);
	System.out.println("Pet id: " + petId);
    }

    @Then("^I verify pet \"([^\"]*)\" is added$")
    public void i_verify_pet_is_added(String arg1) {
	String getAvailablePets = "/findByStatus?status=available";
	resp = given().get(baseUri + getAvailablePets);
	if (resp.asString().contains(arg1))
	    System.out.println("Pet added Successfully");
    }

    @Then("^I update status of pet \"([^\"]*)\" to \"([^\"]*)\"$")
    public void i_updae_status_of_pet_to(String arg1, String arg2) {
	String json = "{\n" + "  \"id\": 0,\n" + "  \"category\": {\n" + "    \"id\": petid,\n"
		+ "    \"name\": \"string\"\n" + "  },\n" + "  \"name\": \"petName\",\n" + "  \"photoUrls\": [\n"
		+ "    \"string\"\n" + "  ],\n" + "  \"tags\": [\n" + "    {\n" + "      \"id\": 0,\n"
		+ "      \"name\": \"string\"\n" + "    }\n" + "  ],\n" + "  \"status\": \"statusValue\"\n" + "}";
	json = json.replace("petName", arg1).replace("statusValue", arg2).replace("petid", petId);
	resp = given().when().headers("content-type", "application/json").body(json).put(baseUri);
	System.out.println("Status code: " + resp.getStatusCode());
	int statusCode = resp.getStatusCode();
	Assert.assertTrue("Issue while adding new pet", statusCode == 200);
    }

    @Then("^I verify status of pet \"([^\"]*)\" updated to \"([^\"]*)\" successfully$")
    public void i_verify_status_of_pet_updated_to_successsfully(String arg1, String arg2) {
	String getSoldPets = "/findByStatus?status=sold";
	resp = given().when().get(baseUri + getSoldPets);
	String resps = resp.getBody().asString();
	System.out.println(resps);
	Object obj = new JsonParser().parse(resps);
	JsonArray ja = (JsonArray) obj;
	for (int i = 0; i < ja.size(); i++) {
	    JsonObject jo = (JsonObject) ja.get(i);
	    String petName = jo.get("name").toString().replaceAll("\"", "");
	    if (petName.equalsIgnoreCase(arg1)) {
		Assert.assertTrue("Status not updated to: " + arg2,
			jo.get("status").toString().replaceAll("\"", "").equals(arg2));
		break;
	    }
	}
    }

    @Then("^I delete pet \"([^\"]*)\"$")
    public void i_delete_pet(String arg1) {
	String uri = baseUri + "/" + petId;
	resp = given().when().delete(uri);
	System.out.println("Resp: " + resp);
	System.out.println("Code: " + resp.getStatusCode());
	Assert.assertTrue("Pet didn't delete successfully", resp.getStatusCode() == 200);
    }

    @Then("^I verify pet \"([^\"]*)\" deleted successfully$")
    public void i_verify_pet_deleted_successfully(String arg1) {
	resp = given().when().get(baseUri);
	Assert.assertTrue("Pet didn't delete successfully", resp.asString().contains(arg1));
    }
}
