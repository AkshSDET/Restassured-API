package httpsrequets;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class POST {

	public static String url = "https://petstore.swagger.io/v2/store/order";
	public static String payload = "{\r\n" + "  \"id\": 0,\r\n" + "  \"petId\": 12,\r\n" + "  \"quantity\": 45,\r\n" + "  \"shipDate\": \"2023-10-04T08:53:51.108Z\",\r\n" + "  \"status\": \"placed\",\r\n" + "  \"complete\": true\r\n" + "}";

	@Test(priority=0)
	public void verifypestatuscode() {
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
	public void verifypetid() {
		System.out.println("===========Test02 is started===========");

		Response res =given()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload.toString())
				.when()
				.post(url);

		int petid = res.jsonPath().get("petId");
		Assert.assertEquals(petid, 12);
		System.out.println("Id is as expected");

		System.out.println("===========Test02 is ended===========");
	}

	@Test(priority=2)
	public void verifystatus() {

		System.out.println("===========Test03 is started===========");

		Response res =given()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload.toString())
				.when()
				.post(url);

		String status = res.jsonPath().get("status");
		Assert.assertEquals(status, "placed");
		System.out.println("Status is as expected");
		System.out.println("===========Test03 is ended===========");
	}

}
