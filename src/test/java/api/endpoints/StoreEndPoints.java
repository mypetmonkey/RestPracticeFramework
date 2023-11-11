package api.endpoints;


import static io.restassured.RestAssured.*;

import api.payloads.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	
	public static Response createStore(Store payload) {
		Response resp = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.post_url_store);
		
		return resp;
	}

	public static Response getOrder(int orderId) {
		Response resp = given()
		.accept(ContentType.JSON)
		.pathParam("orderId",orderId)
        		
		.when()
		.get(Routes.get_url_store);
		
		return resp;
	}
	
	public static Response deleteOrder(int orderId) {
		Response resp = given()
		.accept(ContentType.JSON)
		.pathParam("orderId",orderId)
		
		.when()
		.delete(Routes.delete_url_store);
		return resp;
		
	}

	
	
}
