package in.co.blackphoenix.shexp.test;

import in.co.blackphoenix.shexp.messaging.responses.ErrorResponse;

import java.net.MalformedURLException;
import java.net.URL;

import com.grl.json.client.Client;
import com.grl.json.messages.PingRequest;
import com.grl.json.messages.PingResponse;
import com.grl.json.messages.Response;

public class ConnectivityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Client shexpClient = null;
		try {
			
			shexpClient = new Client(new URL("http://localhost:8080/sharedexpensesserver/serveme/"));
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		// Request the server for the balance sheet
		PingRequest connectivityRequest = new PingRequest(100);
		
		//send the Request to the server
		Response connectivityResponse = shexpClient.sendRequest(connectivityRequest);
		
		if(ErrorResponse.class.isInstance(connectivityResponse)){
			
			System.out.println("Error occured while adding the bill");
		}else if(PingResponse.class.isInstance(connectivityResponse)){
			
			System.out.println("Success");
		}else{
			
			System.out.println("No communication between server and client");
		}
	}

}
