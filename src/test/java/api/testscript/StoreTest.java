package api.testscript;

import org.junit.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.StoreEndPoints;
import api.payloads.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreTest {

	Faker faker;
	Store storepayload;
	
//	@BeforeClass 
//	public void fakedata() {
//		faker=new Faker();
//		storepayload=new Store();
//		storepayload.setId(faker.idNumber().hashCode()); 
//		storepayload.setPetId(faker.idNumber().hashCode());
//		storepayload.setQuantity(faker.number().numberBetween(2, 19));
//		storepayload.setShipDate(faker.date().toString());
//		storepayload.setStatus(faker.name().firstName());
//		storepayload.setComplete(true);
//	
//	}
	
	
	
	@Test(priority=1)
	public void test() {
		
		storepayload=new Store(101, 77, 5,"2023-11-11T09:48:18.201Z", "done",true);
		
		Response resp = StoreEndPoints.createStore(storepayload);
		resp.then().log().ifError()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
	
	@Test(priority=2)
	public void getOrderTest() {
		Response resp = StoreEndPoints.getOrder(101);
		resp.then().log().ifError()
		.assertThat()
		.statusCode(200)
		.log().all();
			
		
	}
	
	@Test
	public void deleteTest() {
		Response resp = StoreEndPoints.deleteOrder(101);
		
		resp.then().log().ifError()
		.assertThat()
		.log().all();
	}
	
}
