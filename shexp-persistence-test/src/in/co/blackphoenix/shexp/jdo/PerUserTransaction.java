/**
 * 
 */
package in.co.blackphoenix.shexp.jdo;

import javax.jdo.annotations.PersistenceCapable;

/**
 * @author Manoj
 *
 */

@PersistenceCapable
public class PerUserTransaction{
//	
//	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
//	@PrimaryKey
//	long myid;
	String myName = null;
	int myPart = 0;
		
//	/**
//	 * @return the id
//	 */
//	public long getId() {
//		return myid;
//	}
//
//	/**
//	 * @param id the id to set
//	 */
//	public void setId(long id) {
//		this.myid = id;
//	}
	
	/**
	 * @return the myName
	 */
	public String getMyName() {
		return myName;
	}

	/**
	 * @param myName the myName to set
	 */
	public void setMyName(String myName) {
		this.myName = myName;
	}

	/**
	 * @return the myPart
	 */
	public int getMyPart() {
		return myPart;
	}

	/**
	 * @param myPart the myPart to set
	 */
	public void setMyPart(int myPart) {
		this.myPart = myPart;
	}

//	/**
//	 * @return the myBill
//	 */
//	public Bill getMyBill() {
//		return myBill;
//	}
//
//	/**
//	 * @param myBill the myBill to set
//	 */
//	public void setMyBill(Bill myBill) {
//		this.myBill = myBill;
//	}


	
	
	/**
	 * @param myName
	 * @param myPart
	 * @param myBill
	 */
	public PerUserTransaction(String myName, int myPart) {
		super();
		this.myName = myName;
		this.myPart = myPart;
	}

	public PerUserTransaction(){
		
	}

	

}
