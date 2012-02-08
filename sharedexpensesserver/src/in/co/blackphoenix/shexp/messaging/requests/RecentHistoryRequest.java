package in.co.blackphoenix.shexp.messaging.requests;

import javax.servlet.http.HttpSession;

import com.grl.json.messages.Response;

/**
 * Request message for requesting report of the recent bills from server
 * @author Manoj
 *
 */
public class RecentHistoryRequest extends AuthorizedRequest {

	/**
	 * Construct a request message for report of the recent bills
	 * @param fbId - facebook user id
	 * @param fbAuthToken - authorization token from fb
	 * @param c2dmToken - Cloud to Device message Token
	 */
	public RecentHistoryRequest(int fbId, long fbAuthToken, long c2dmToken) {
		
		super(fbId, fbAuthToken, c2dmToken);
	}

	@Override
	public Response performService(HttpSession arg0) {
		// TODO Request for recent bill history server
		return null;
	}

}
