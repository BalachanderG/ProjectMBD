package in.co.blackphoenix.shexp.messaging.requests;

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
	 * @param fbAuthToken - fb auth token
	 * @param c2dmToken - cloud to device messaging token
	 * @param numberOfToppers - top balances you need
	 */
	public TopNBalanceSheetRequest(long fbAuthToken, long c2dmToken,
			int numberOfToppers) {
		
		super(fbAuthToken, c2dmToken);
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
		// TODO Request for top n most balance sheet server
		return null;
	}

}
