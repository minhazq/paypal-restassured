package mq.com.restassured02;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class Test01 {

	
	@Test
	public void getAccessToken(){
		
		 Response response = given().
			accept(ContentType.JSON)
				.header("Accept-Language", "en_US")
					.contentType("application/x-www-form-urlencoded")
						.auth().preemptive().basic("ATyfHxBENx8S400y_mxFfS3LpFEYNjOKR8MsJCFACWYutFjsK5pt0eyb5IxXqGv-0GVu3ZY-0liLe4pv", "EOIpohWlqYQrDX2kOzE256fBN2dNjCCfhid7xRPUg58FVW9Tap2QTmN96KnTjL5BmwgL9BXO")
						.formParam("grant_type", "client_credentials")
						.post("https://api.sandbox.paypal.com/v1/oauth2/token").then().extract().response();
		
		
		
		System.out.print(response.jsonPath().prettify());
		
		
		
	}
}
