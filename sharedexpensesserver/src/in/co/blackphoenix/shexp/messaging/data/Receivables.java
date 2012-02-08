package in.co.blackphoenix.shexp.messaging.data;

/**
 * Payables
 * 
 * The amount that needs to be paid to a person
 * @author Manoj
 *
 */
public class Receivables extends LedgerEntry {

	private int receiveFromId; // the person to be paid to
	
	/**
	 * Construct a balance sheet transaction 
	 * @param amount - balance amount
	 * @param payToId - person to be paid to.
	 */
	public Receivables(double amount, int receiveFromId) {
		super(amount);
		this.receiveFromId = receiveFromId;
	}

	/**
	 * get the id of the person to receive
	 * @return - id of the person
	 */
	public int getPayToId() {
		return receiveFromId;
	}

	/**
	 * set id of the person to be received from
	 * @param payToId - id of the person
	 */
	public void setReceiveFromId(int receiveFromId) {
		this.receiveFromId = receiveFromId;
	}
	
	
}
