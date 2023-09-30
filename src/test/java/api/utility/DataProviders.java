package api.utility;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="alldata")
	public String[][] allDataProviders() throws Throwable{
		String fname=System.getProperty("user.dir")+".\\src\\test\\resources\\customer.xlsx";
		int trowcount=ReadExcelFile.getRownum(fname, "customer");
		int tcolcount=ReadExcelFile.getcolcount(fname, "customer");
		
		String userdata[][]=new String[trowcount-1][tcolcount];
		
		for(int rownum=1;rownum<trowcount;rownum++) {
			
			for(int colnum=0;colnum<tcolcount;colnum++) {
				userdata[rownum-1][colnum]=ReadExcelFile.getCellValue(fname, "customer", rownum, colnum);
					
				
			}
		}
		return userdata;
	}
	
	
	
	@DataProvider(name="usernamedata")
	public String[] username() throws Throwable{
		String fname=System.getProperty("user.dir")+".\\src\\test\\resources\\customer.xlsx";
		int trowcount=ReadExcelFile.getRownum(fname, "customer");
		
		String username[]=new String[trowcount-1];
		
		for(int rownum=1;rownum<trowcount;rownum++) {
			
			username[rownum-1]=ReadExcelFile.getCellValue(fname,"customer", rownum, 1);
		}
		return username;
	}

}
