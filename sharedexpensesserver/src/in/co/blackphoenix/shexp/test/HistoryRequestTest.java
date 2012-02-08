package in.co.blackphoenix.shexp.test;

import in.co.blackphoenix.shexp.messaging.requests.HistoryRequest;
import in.co.blackphoenix.shexp.messaging.responses.ErrorResponse;
import in.co.blackphoenix.shexp.messaging.responses.HistoryResponse;

import java.net.MalformedURLException;
import java.net.URL;

import com.grl.json.client.Client;
import com.grl.json.messages.Response;

public class HistoryRequestTest {

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
		
		// Request the server for the bills reported
		HistoryRequest historyRequest = new HistoryRequest(StoreBillReportTest.FBID, StoreBillReportTest.FBAUTH, StoreBillReportTest.C2DMAUTH);
		
		//send the Request to the server
		Response historyResponse = shexpClient.sendRequest(historyRequest);
		
		if(ErrorResponse.class.isInstance(historyResponse)){
			
			System.out.println("Error occured while adding the bill");
		}else if(HistoryResponse.class.isInstance(historyResponse)){
			
			System.out.println("Success");
		}else{
			
			System.out.println("No communication between server and client");
		}
	}

}
