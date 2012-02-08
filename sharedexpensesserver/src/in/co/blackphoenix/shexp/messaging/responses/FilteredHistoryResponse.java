package in.co.blackphoenix.shexp.messaging.responses;

import in.co.blackphoenix.shexp.messaging.data.Bills;
import java.util.List;
import com.grl.json.messages.Response;

public class FilteredHistoryResponse extends Response {

	private List<Bills> reportedBills; // Bill that have been reported

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

	/**
	 * Construct the message with reported bills
	 * @param reportedBills
	 */
	public FilteredHistoryResponse(List<Bills> reportedBills) {
		super();
		this.reportedBills = reportedBills;
		
		//TODO: Check for NULL and return exception
	}
	
	
} 
