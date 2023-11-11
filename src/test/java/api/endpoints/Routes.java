package api.endpoints;

public class Routes {
public static String base_url="https://petstore.swagger.io/v2";
	
	
	//user module url
	public static String post_url= base_url+"/user";
	public static String post_url_array= base_url+"/user/createWithArray";
	public static String post_url_list= base_url+"/user/createWithList";
	public static String get_url= base_url+"/user/{username}";
	public static String get_url_login= base_url+"/user/login";
	public static String get_url_logout= base_url+"/user/logout";
	public static String put_url= base_url+"/user/{username}";
	public static String delete_url= base_url+"/user/{username}";
	
	//store module urls
	
	public static String post_url_store= base_url+"/store/order";
	public static String get_url_store= base_url+"/store/order/{orderId}";
	public static String delete_url_store= base_url+"/store/order/{orderId}";


   
}
