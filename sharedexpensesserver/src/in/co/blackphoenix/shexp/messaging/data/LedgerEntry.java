package in.co.blackphoenix.shexp.messaging.data;

/**
 * Ledger Entry 
 * 
 * Entry in the balance sheet for the payables and receivables 
 * - stores the amount of the transaction
 * @author Manoj
 *
 */
public abstract class LedgerEntry {
	
	//balance amount
	private double amount;

	/**
	 * get the balance amount
	 * @return - balance amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * set the balance amount
	 * @param amount - balance amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/** Construct a ledger entry with the balance amount
	 * 
	 * @param amount - balance amount
	 */
	public LedgerEntry(double amount) {
		this.amount = amount;
	}
	
}