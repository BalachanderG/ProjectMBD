package in.co.blackphoenix.shexp.messaging.requests;

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
	 * @param fbAuthToken - authorization token from fb
	 * @param c2dmToken - Cloud to Device message Token
	 */
	public BalanceSheetRequest(long fbAuthToken, long c2dmToken) {
		
		super(fbAuthToken, c2dmToken);
	}

	@Override
	public Response performService(HttpSession arg0) {
		// TODO Request for balance sheet server
		return null;
	}

}