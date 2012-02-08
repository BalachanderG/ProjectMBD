package in.co.blackphoenix.shexp.messaging.responses;

import com.grl.json.messages.Response;

public class ErrorResponse extends Response{

	private int errNo; // Number associated with the error
	private String errMessage; // error message
	
	
	/**
	 * construct a error message with
	 *  
	 * @param errNo - error number
	 * @param errMessage - error message
	 */
	public ErrorResponse(int errNo, String errMessage) {
		super();
		this.errNo = errNo;
		this.errMessage = errMessage;
	}


	/**
	 * @return the errNo
	 */
	public int getErrNo() {
		return errNo;
	}


	/**
	 * @param errNo the errNo to set
	 */
	public void setErrNo(int errNo) {
		this.errNo = errNo;
	}


	/**
	 * @return the errMessage
	 */
	public String getErrMessage() {
		return errMessage;
	}


	/**
	 * @param errMessage the errMessage to set
	 */
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	
	
	
	
	
}
