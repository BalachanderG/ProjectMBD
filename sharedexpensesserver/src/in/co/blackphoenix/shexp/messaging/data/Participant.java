package in.co.blackphoenix.shexp.messaging.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * 
 * Details of the participant in the bill
 * @author Manoj
 *
 */

@PersistenceCapable
public class Participant {

	public enum SHARETYPE{
		
		FIXED{
			
			public String toString(){
				
				return "FIXED";
			}
		},
		
		PIESLICE{
			
			public String toString(){
				
				return "PIESLICE";
			}
		}
	}
	
	@Persistent
	private int myFBId; // FB ID of the participant
	
	@Persistent
	private double myShareOfBill; // Amount of the bill

	@Persistent
	private SHARETYPE myShareType = SHARETYPE.PIESLICE;
	
	@Persistent
	private double totalAmount;
	
	@Persistent
	private double myPartOfBill; // Part is the ratio of the share / total
	
	
	/**
	 * 
	 * fill in the details about a participant of a bill
	 * @param myFBId - his fb ID 
	 * @param myShareOfBill - his share of the bill 
	 */
	public Participant(int myFBId, double myShareOfBill) {
		
		this.myFBId = myFBId;
		this.myShareOfBill = myShareOfBill;
		this.myShareType = SHARETYPE.FIXED;
	}
	
	/**
	 * Create a participant who got a slice with
	 * @param myFBId - his fb id 
	 * @param myShareOFBill - his share in amount of the bill
	 * @param totalAmount - total amount of the bill
	 * @param myPartOfBill - ratio of his share to the total
	 */
	public Participant(int myFBId, 
			double myShareOFBill,
			double totalAmount,
			double myPartOfBill){
		
		this.myFBId = myFBId;
		this.myShareOfBill = myShareOFBill;
		this.totalAmount = totalAmount;
		this.myPartOfBill = myPartOfBill;
		
		this.myShareType = SHARETYPE.PIESLICE;
		
	}

	/**
	 * @return the myFBId
	 */
	public int getMyFBId() {
		return myFBId;
	}

	/**
	 * @param myFBId the myFBId to set
	 */
	public void setMyFBId(int myFBId) {
		this.myFBId = myFBId;
	}

	/**
	 * @return the myShareOfBill
	 */
	public double getMyShareOfBill() {
		return myShareOfBill;
	}

	/**
	 * @param myShareOfBill the myShareOfBill to set
	 */
	public void setMyShareOfBill(double myShareOfBill) {
		this.myShareOfBill = myShareOfBill;
	}
	
	/**
	 * @return the myShareType
	 */
	public SHARETYPE getMyShareType() {
		return myShareType;
	}

	/**
	 * @param myShareType the myShareType to set
	 */
	public void setMyShareType(SHARETYPE myShareType) {
		this.myShareType = myShareType;
	}

	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the myPartOfBill
	 */
	public double getMyPartOfBill() {
		return myPartOfBill;
	}

	/**
	 * @param myPartOfBill the myPartOfBill to set
	 */
	public void setMyPartOfBill(double myPartOfBill) {
		this.myPartOfBill = myPartOfBill;
	}

	public Participant(){}
}