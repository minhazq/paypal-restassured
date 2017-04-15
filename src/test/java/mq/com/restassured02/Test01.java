package mq.com.restassured02;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.preemptive;

public class Test01 {

	
	@Test
	public void getAccessToken(){
		
		String clientId = "ATyfHxBENx8S400y_mxFfS3LpFEYNjOKR8MsJCFACWYutFjsK5pt0eyb5IxXqGv-0GVu3ZY-0liL";
		String secret = "EOIpohWlqYQrDX2kOzE256fBN2dNjCCfhid7xRPUg58FVW9Tap2QTmN96KnTjL5BmwgL9BXO-JB";
		
		RestAssured.baseURI = "https://api.sandbox.paypal.com/"; //--->Service End Point 
		RestAssured.basePath = "v1/oauth2/token"; // --------------->Method
		
		//Basic Authentication [ need to do the static import for preemptive]
		RestAssured.authentication = preemptive().basic(clientId, secret); 
		
		
		Response response = given()
			//accept is header specifing the  media type of the response that i am expecting
			.accept(ContentType.JSON)
					//contentType is sepcifing the media type of the request being sent
					.contentType("application/x-www-form-urlencoded") 
						.formParam("grant_type", "client_credentials")
							.post().then().extract().response();
					
		
		
		System.out.println(response.jsonPath().prettify());
		
		
		
	}
}
