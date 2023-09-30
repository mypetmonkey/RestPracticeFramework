package ap.endpoints;

import static io.restassured.RestAssured.*;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
	
	public static Response createUser(User paylod) {
		Response response = given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(paylod)
			
			.when()
			.post(Routes.post_url);
		
		return response;
		}
		
		
		
		public static Response getUser(String username) {
			Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", username)
				
				.when()
				.get(Routes.get_url);
			
			return response;
			}

		
		
		public static Response updateUser(User paylod,String username) {
			Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(paylod)
				.pathParam("username", username)
				
				.when()
				.put(Routes.put_url);
			
			return response;
			}
		
		
		public static Response deleteUser(String username) {
			Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", username)
				
				.when()
				.delete(Routes.delete_url);
			
			return response;
			}
	}



