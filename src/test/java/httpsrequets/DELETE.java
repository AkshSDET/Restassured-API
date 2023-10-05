package httpsrequets;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class DELETE {

	public static String url = "https://reqres.in/api/users/2";

	@Test
	public void verifystatuscode() {
		System.out.println("===========Test01 is started===========");
		when().
		delete(url)
		.then()
		.statusCode(204);
		System.out.println("Deleted successfully");
		System.out.println("===========Test01 is ended===========");
	}
}
