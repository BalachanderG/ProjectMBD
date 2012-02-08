package in.co.blackphoenix.shexp.messaging.responses;

import com.grl.json.messages.Response;

public class GeneralACKResponse extends Response{
	
	private String ackMessage;

	/**
	 * @param ackMessage
	 */
	public GeneralACKResponse(String ackMessage) {
		super();
		this.ackMessage = ackMessage;
	}
	
	/**
	 * @param ackMessage
	 */
	public GeneralACKResponse() {
		super();
	}

	/**
	 * @return the ackMessage
	 */
	public String getAckMessage() {
		return ackMessage;
	}

	/**
	 * @param ackMessage the ackMessage to set
	 */
	public void setAckMessage(String ackMessage) {
		this.ackMessage = ackMessage;
	}

}
