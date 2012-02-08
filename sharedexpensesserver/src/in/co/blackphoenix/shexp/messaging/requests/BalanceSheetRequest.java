package in.co.blackphoenix.shexp.messaging.requests;

import in.co.blackphoenix.shexp.messaging.data.BalanceSheet;
import in.co.blackphoenix.shexp.messaging.responses.BalanceSheetResponse;
import in.co.blackphoenix.shexp.mysql.DataManager;

import javax.servlet.http.HttpSession;

import com.grl.json.messages.Response;

/**
 * Request message for requesting Balance Sheet from server
 * @author Manoj
 *
 */
public class BalanceSheetRequest extends AuthorizedRequest {

	/**
	 * Construct a request message for balance sheet
	 * @param fbId - Id of the user in facebook
	 * @param fbAuthToken - authorization token from fb
	 * @param c2dmToken - Cloud to Device message Token
	 */
	public BalanceSheetRequest(int fbId, long fbAuthToken, long c2dmToken) {
		
		super(fbId, fbAuthToken, c2dmToken);
	}

	@Override
	public Response performService(HttpSession arg0) {
		// TODO perform FB Auth check
		
		//Get the balance sheet from the data manager
		BalanceSheet ledger = DataManager.getBalanceSheet(getFbId());
		
		//Create the response message
		BalanceSheetResponse response = new BalanceSheetResponse(ledger);
		
		//off you go 
		return response;
	}

}
