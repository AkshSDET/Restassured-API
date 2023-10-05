package httpsrequets;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class GET {
	public static String url = "https://reqres.in/api/users/2";

	@Test(priority=0)
	public void verifystatuscode() {
		System.out.println("===========Test01 is started===========");
		given()
		.get(url)
		.then()
		.statusCode(200);
		System.out.println("Statuscode is as expected");
		System.out.println("===========Test01 is ended===========");
	}

	@Test(priority=1)
	public void verifyid() {
		System.out.println("===========Test02 is started===========");
		given()
		.get(url)
		.then()
		.body("data.id", equalTo(2));
		System.out.println("Id is as expected");
		System.out.println("===========Test02 is ended===========");
	}

	@Test(priority=2)
	public void verifyemail() {
		System.out.println("===========Test03 is started===========");
		given()
		.get(url)
		.then()
		.body("data.email", equalTo("janet.weaver@reqres.in"));
		System.out.println("Email is as expected");
		System.out.println("===========Test03 is ended===========");
	}

	@Test(priority=3)
	public void verifyfirstname() {
		System.out.println("===========Test04 is started===========");
		given()
		.get(url)
		.then()
		.body("data.first_name", equalTo("Janet"));
		System.out.println("Firstname is as expected");
		System.out.println("===========Test04 is ended===========");
	}

	@Test(priority=4)
	public void verifylastname() {
		System.out.println("===========Test05 is started===========");
		given()
		.get(url)
		.then()
		.body("data.last_name", equalTo("Weaver"))
		.log()
		.all();
		System.out.println("Lastname is as expected");
		System.out.println("===========Test05 is ended===========");
	}
}
