package in.co.blackphoenix.shexp.messaging.requests;

import in.co.blackphoenix.shexp.jdo.PMF;
import in.co.blackphoenix.shexp.messaging.data.Bills;
import in.co.blackphoenix.shexp.messaging.responses.GeneralACKResponse;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;
import javax.servlet.http.HttpSession;

import com.grl.json.messages.Response;

public class StoreBillsRequest extends AuthorizedRequest {

	private List<Bills> reportedBills; // list of bills reported
	
	/**
	 * Construct a request to store bills
	 * @param fbAuthToken - fb authorization token
	 * @param c2dmToken - Cloud to Device Messaging Token
	 * @param reportedBills - list of bills reported
	 */
	public StoreBillsRequest(long fbAuthToken, long c2dmToken,
			List<Bills> reportedBills) {
		super(fbAuthToken, c2dmToken);
		this.reportedBills = reportedBills;
		
		//TODO : DO a NULL CHECK and return Exception
	}

	public StoreBillsRequest(){}
	/**
	 * Construct a request to store bills
	 * @param fbAuthToken - fb authorization token
	 * @param c2dmToken - Cloud to Device Messaging Token
	 * @param reportedBills - list of bills reported
	 */
	public StoreBillsRequest(long fbAuthToken, long c2dmToken,
			Bills reportedBill) {
		
		super(fbAuthToken, c2dmToken);
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
		
		// Creating a persistence manager that talks to the data base
		PersistenceManager pm = PMF.get();
		
		// creating transaction
		Transaction tx= pm.currentTransaction();
		
		System.out.println("Entered service");
		
		try{
			tx.begin();
			{
				
				//adding the details of the bills to the transaction
				for(Bills reportedBill : reportedBills){
					
					pm.makePersistent(reportedBill);
				}
				
				//committing the transaction
				tx.commit();
			}
		
		}finally{
			if(tx.isActive())
				tx.rollback();
			pm.close();
		}
		
		System.out.println("Exitting service");
		
		// TODO Create appropriate bill response
		return new GeneralACKResponse("Bills Stored");
	}

}
