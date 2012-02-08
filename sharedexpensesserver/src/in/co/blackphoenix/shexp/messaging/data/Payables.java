package in.co.blackphoenix.shexp.messaging.data;

/**
 * Payables
 * 
 * The amount that needs to be paid to a person
 * @author Manoj
 *
 */
public class Payables extends LedgerEntry {

	private int payToId; // the person to be paid to
	
	/**
	 * Construct a balance sheet transaction 
	 * @param amount - balance amount
	 * @param payToId - person to be paid to.
	 */
	public Payables(double amount, int payToId) {
		super(amount);
		this.payToId = payToId;
	}

	/**
	 * get the id of the person to pay
	 * @return - id of the person
	 */
	public int getPayToId() {
		return payToId;
	}

	/**
	 * set id of the person to be paid to
	 * @param payToId - id of the person
	 */
	public void setPayToId(int payToId) {
		this.payToId = payToId;
	}
		
}
