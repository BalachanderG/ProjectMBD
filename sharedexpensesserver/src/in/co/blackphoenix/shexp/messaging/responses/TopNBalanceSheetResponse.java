package in.co.blackphoenix.shexp.messaging.responses;

import in.co.blackphoenix.shexp.messaging.data.BalanceSheet;

import com.grl.json.messages.Response;

public class TopNBalanceSheetResponse extends Response  {

	private BalanceSheet ledger; // ledger that contains the top N balances with each person
	
	/**
	 * Construct a balance sheet 
	 * 
	 * @param ledger - the balance sheet
	 */
	public TopNBalanceSheetResponse(BalanceSheet ledger) {
		super();
		this.ledger = ledger;
	}

	/**
	 * @return the ledger
	 */
	public BalanceSheet getLedger() {
		return ledger;
	}

	/**
	 * @param ledger the ledger to set
	 */
	public void setLedger(BalanceSheet ledger) {
		this.ledger = ledger;
	}
	
}
