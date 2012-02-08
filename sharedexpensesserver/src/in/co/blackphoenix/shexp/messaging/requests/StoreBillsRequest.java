package in.co.blackphoenix.shexp.messaging.requests;

import in.co.blackphoenix.shexp.messaging.data.Bills;
import in.co.blackphoenix.shexp.messaging.responses.GeneralACKResponse;
import in.co.blackphoenix.shexp.mysql.DataManager;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.grl.json.messages.Response;

public class StoreBillsRequest extends AuthorizedRequest {

	private List<Bills> reportedBills; // list of bills reported
	
	/**
	 * Construct a request to store bills
	 * @param fbId - Id of the user in facebook
	 * @param fbAuthToken - fb authorization token
	 * @param c2dmToken - Cloud to Device Messaging Token
	 * @param reportedBills - list of bills reported
	 */
	public StoreBillsRequest(int fbId, long fbAuthToken, long c2dmToken,
			List<Bills> reportedBills) {
		super(fbId, fbAuthToken, c2dmToken);
		this.reportedBills = reportedBills;
		
		//TODO : DO a NULL CHECK and return Exception
	}

	public StoreBillsRequest(){}
	/**
	 * Construct a request to store bills
	 * @param fbId - Id of the user in facebook
	 * @param fbAuthToken - fb authorization token
	 * @param c2dmToken - Cloud to Device Messaging Token
	 * @param reportedBills - list of bills reported
	 */
	public StoreBillsRequest(int fbId, long fbAuthToken, long c2dmToken,
			Bills reportedBill) {
		
		super(fbId, fbAuthToken, c2dmToken);
		this.reportedBills = new ArrayList<Bills>();
		reportedBills.add(reportedBill);
	}
	
	/**
	 * @return the reportedBills
	 */
	public List<Bills> getReportedBills() {
		return reportedBills;
	}

	/**
	 * @param reportedBills the reportedBills to set
	 */
	public void setReportedBills(List<Bills> reportedBills) {
		this.reportedBills = reportedBills;
	}

	@Override
	public Response performService(HttpSession arg0) {
		
		// TODO perform FB Auth Check
		
		// TODO perform C2DM check and push notifications
		
		DataManager.storeTheBills(reportedBills);
		
		System.out.println("Exitting service");
		
		// TODO Create appropriate bill response
		return new GeneralACKResponse("Bills Stored");
	}

}
