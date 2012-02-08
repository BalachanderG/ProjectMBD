package in.co.blackphoenix.shexp.messaging.data;



/** 
 * Participant with a slice of the pie to be shared in the bill
 * 
 * @author Manoj
 *
 */

public class PieSliceParticipant extends Participant {

	
	private double totalBillAmount; // Total amount of the bill
	
	private double mySliceOfPie; // Slice of the pie that goes to the participant

	/**
	 * 
	 * Participant with slice of the pie to be shared in the bill
	 * @param myFBId - participant FB ID
	 * @param myShareOfBill - Amount that is paid by the participant
	 * @param totalBillAmount - Total amount paid for the bill
	 * @param mySliceOfPie - my part from the total pie
	 */
	public PieSliceParticipant(int myFBId, double myShareOfBill,
			double totalBillAmount, double mySliceOfPie) {
		super(myFBId, myShareOfBill);
		this.totalBillAmount = totalBillAmount;
		this.mySliceOfPie = mySliceOfPie;
	}

	/**
	 * 
	 */
	public PieSliceParticipant() {
		super();
	}

	/**
	 * @return the totalBillAmount
	 */
	public double getTotalBillAmount() {
		return totalBillAmount;
	}

	/**
	 * @param totalBillAmount the totalBillAmount to set
	 */
	public void setTotalBillAmount(double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

	/**
	 * @return the mySliceOfPie
	 */
	public double getMySliceOfPie() {
		return mySliceOfPie;
	}

	/**
	 * @param mySliceOfPie the mySliceOfPie to set
	 */
	public void setMySliceOfPie(double mySliceOfPie) {
		this.mySliceOfPie = mySliceOfPie;
	}
	
	
}
