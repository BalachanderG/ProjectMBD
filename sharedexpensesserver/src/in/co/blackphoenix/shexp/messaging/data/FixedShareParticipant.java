package in.co.blackphoenix.shexp.messaging.data;


/***
 * Participant with a fixed amount to pay in the bill
 * @author Manoj
 *
 */


public class FixedShareParticipant extends Participant {

	/**
	 * fill in the details about a participant of a bill
	 * @param myFBId - his fb ID 
	 * @param myShareOfBill - his fixed amount share of the bill 
	 */
	public FixedShareParticipant(int myFBId, double myShareOfBill) {
		
		super(myFBId, myShareOfBill);
	}

	
	public FixedShareParticipant() {
		super();
	}

}
