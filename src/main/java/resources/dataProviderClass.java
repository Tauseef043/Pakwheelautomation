package resources;

import org.testng.annotations.DataProvider;

public class dataProviderClass {
	   @DataProvider(name = "data-provider-PakwheelProducts")
	    public static Object[][] provideTestData() {
	        return new Object[][] {
	            {"PakWheels Certified Cars"},
	            {"PakWheels Car Inspection"},
	            {"Auction Sheet Verification"},
	            {"PakWheels Sell It For Me"},
	            {"Car Finance"},
	            {"Car Insurance"},
	            {"Pakwheels Partner Workshop"},
	            {"Car Registration"},
	            {"Car Ownership Transfer"},
	            // Add more test data as needed
	        };
	    }
}
