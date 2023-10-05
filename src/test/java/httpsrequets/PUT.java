package httpsrequets;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PUT {

	public static String url = "https://petstore.swagger.io/v2/pet";
	public static String payload = "{\r\n"
			+ "  \"id\": 2,\r\n"
			+ "  \"name\": \"Tata\",\r\n"
			+ "  \"tags\": [\r\n"
			+ "    {\r\n"
			+ "      \"id\": 2,\r\n"
			+ "      \"name\": \"54\"\r\n"
			+ "    }\r\n"
			+ "  ]\r\n"
			+ "}";

	@Test(priority=0)
	public void verifystatuscode() {
		System.out.println("===========Test01 is started===========");
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload.toString())
		.when()
		.post(url)
		.then()
		.statusCode(200);
		System.out.println("Statuscode is as expected");
		System.out.println("===========Test01 is ended===========");
	}

	@Test(priority=1)
	public void verifyname() {

		System.out.println("===========Test02 is started===========");
		Response res= given()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload.toString())
				.when()
				.post(url);

		String name = res.jsonPath().get("name");
		Assert.assertEquals(name, "Tata");
		System.out.println("name is as expected");
		System.out.println("===========Test02 is ended===========");
	}

	@Test(priority=2)
	public void vefifyid() {
		System.out.println("===========Test03 is started===========");
		Response res= given()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload.toString())
				.when()
				.post(url);

		int id = res.jsonPath().get("tags[0].id");
		Assert.assertEquals(id, 2);
		System.out.println("id is as expected");
		System.out.println("===========Test03 is ended===========");

	}
}
