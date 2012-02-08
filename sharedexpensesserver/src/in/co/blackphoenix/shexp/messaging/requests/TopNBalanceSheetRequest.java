package in.co.blackphoenix.shexp.messaging.requests;

import in.co.blackphoenix.shexp.messaging.data.BalanceSheet;
import in.co.blackphoenix.shexp.messaging.responses.TopNBalanceSheetResponse;
import in.co.blackphoenix.shexp.mysql.DataManager;

import javax.servlet.http.HttpSession;

import com.grl.json.messages.Response;

/**
 * Request message for requesting Balance Sheet from server
 * @author Manoj
 *
 */
public class TopNBalanceSheetRequest extends AuthorizedRequest {
	
	private int numberOfToppers; // top n most toppers

	/**
	 * Construct a request message to get top n balances
	 * @param fbId - Facebook id of the user
	 * @param fbAuthToken - fb auth token
	 * @param c2dmToken - cloud to device messaging token
	 * @param numberOfToppers - top balances you need
	 */
	public TopNBalanceSheetRequest(int fbId, long fbAuthToken, long c2dmToken,
			int numberOfToppers) {
		
		super(fbId, fbAuthToken, c2dmToken);
		this.numberOfToppers = numberOfToppers;
	}

	/**
	 * @return the numberOfToppers
	 */
	public int getNumberOfToppers() {
		return numberOfToppers;
	}

	/**
	 * @param numberOfToppers the numberOfToppers to set
	 */
	public void setNumberOfToppers(int numberOfToppers) {
		this.numberOfToppers = numberOfToppers;
	}

	@Override
	public Response performService(HttpSession arg0) {
		// TODO perform the FB Auth check
		
		//get the ledger with top N kadans 
		BalanceSheet ledger = DataManager.getTopNBalanceSheet(getFbId(), numberOfToppers);
		
		//Create the response message
		TopNBalanceSheetResponse response = new TopNBalanceSheetResponse(ledger);
		
		// n say bye
		return response;
	}

}
