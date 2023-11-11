package api.testscript;
import static io.restassured.RestAssured.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Usertest {
	
	
	Faker faker;
	User userPayload;
	public static Logger logger;
	@BeforeClass
	public void generateTestData() {
		faker=new Faker();
		userPayload=new  User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		//obtain logger
		logger=LogManager.getLogger("RestPracticeFramework");
		//log
		logger.info("read user data");
	}
	
	@Test(priority=1)
	public void createUserTest() {
		Response resp = UserEndpoints.createUser(userPayload);
		resp.then().log().all()
		.statusCode(200)
		.contentType(ContentType.JSON)
		;
		//log
				logger.info("create user data");
	}
	
	
	@Test(priority = 2)
	public void getUserTest() {
		Response resp = UserEndpoints.getUser(this.userPayload.getUsername());
		resp.then().log().all()
		.statusCode(200)
		.contentType(ContentType.JSON)
		;
		//log
				logger.info("get user data");
	}
	
	@Test(priority=3)
	public void updateUserTest() {
		userPayload.setFirstName(faker.name().firstName());

		Response resp = UserEndpoints.updateUser(userPayload,this.userPayload.getUsername());
		
		resp.then().log().all()
		.statusCode(200)
		.contentType(ContentType.JSON)
		;
		//log
				logger.info("update user data");
	}
	
	@Test(priority=4)
	public void deleteUserTest() {
		Response resp = UserEndpoints.deleteUser(this.userPayload.getUsername());
		resp.then().log().all()
		.statusCode(200)
		.contentType(ContentType.JSON)
		;
		//log
				logger.info("delete user data");
	}
	

}
