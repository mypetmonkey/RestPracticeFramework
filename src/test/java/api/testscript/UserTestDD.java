package api.testscript;

import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payloads.User;
import api.utility.DataProviders;
import io.restassured.response.Response;

public class UserTestDD {
	
	@Test(priority = 1,dataProvider = "alldata", dataProviderClass = DataProviders.class)
	public void ddTest(String userid,String username,String fname,String lname,String email,String pwd,String phone) {
		
		User userPayload=new  User();
		userPayload.setId(Integer.parseInt(userid));
		userPayload.setUsername(username);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		Response resp = UserEndpoints.createUser(userPayload);
		resp.then().log().all();
	}
	
	
	
	@Test(priority = 2,dataProvider = "usernamedata", dataProviderClass = DataProviders.class)
	public void ddTest(String username) {
		
		
		Response resp = UserEndpoints.deleteUser(username);
		resp.then().log().all();
	}
	

}
