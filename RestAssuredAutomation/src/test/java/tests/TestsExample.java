package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestsExample {

	@Test
	public void test_0() {

		RestAssured.baseURI = "http://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("content/type", "application/json")
				.body("{\n" + "\"place_id\": \"af16af55f1e744762d6e3aed146cfba6\",\n"
						+ "\"address\":\"This is new address\",\n" + "\"key\":\"qaclick123\"\n" + "}")
				.when().post("map/api/place/add/json").then().assertThat().statusCode(400);
	}

	@Test
	public void test_1() {

		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.body().toString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("Content-type"));

		int statusCode = response.statusCode();

		Assert.assertEquals(statusCode, 200);

	}

	@Test
	public void test_2() {

		baseURI = "https://reqres.in/api";
		given().get("/users?page=2"). // all input details
				then().statusCode(200). // submit the api
				body("data[1].id", equalTo(8)).log().all(); // validate the response

	}

}
