package in.co.blackphoenix.shexp.messaging.responses;

public class StoreBillsResponse extends GeneralACKResponse {

	
	/**
	 * Send an ACk of success ful completion
	 * @param ackMessage
	 */
	public StoreBillsResponse(String ackMessage) {
		super(ackMessage);
	}

}
