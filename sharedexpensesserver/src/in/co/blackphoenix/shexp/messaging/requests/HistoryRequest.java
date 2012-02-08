package in.co.blackphoenix.shexp.messaging.requests;

import java.util.List;

import in.co.blackphoenix.shexp.messaging.data.Bills;
import in.co.blackphoenix.shexp.messaging.responses.HistoryResponse;
import in.co.blackphoenix.shexp.mysql.DataManager;

import javax.servlet.http.HttpSession;

import com.grl.json.messages.Response;

/**
 * Request message for requesting report history from server
 * @author Manoj
 *
 */
public class HistoryRequest extends AuthorizedRequest {

	/**
	 * Construct a request message for report history
	 * @param fbId - Facebook Id
	 * @param fbAuthToken - authorization token from fb
	 * @param c2dmToken - Cloud to Device message Token
	 */
	public HistoryRequest(int fbId, long fbAuthToken, long c2dmToken) {
		
		super(fbId, fbAuthToken, c2dmToken);
	}

	@Override
	public Response performService(HttpSession arg0) {

		//TODO - perform FB Auth check
		
		//get the bill reports from the table
		List<Bills> history = DataManager.getBillHistory(getFbId());
		
		//create the response message
		HistoryResponse response = new HistoryResponse(history);
		
		//send to the client 
		return response;
	}

}
