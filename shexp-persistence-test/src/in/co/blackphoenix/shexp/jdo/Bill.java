/**
 * 
 */
package in.co.blackphoenix.shexp.jdo;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author Manoj
 *
 */

@PersistenceCapable
public class Bill {

	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@PrimaryKey
	long id = 0;
	
	String paidBy = "Manoj";
	@Persistent
	public int description = 0;
	@Persistent
	public int amount = 0;
	@Persistent
	public int numberOfParticipants = 1;

	@Element(column = "bill_id")
	List<PerUserTransaction> myParticipants;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the description
	 */
	public int getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(int description) {
		this.description = description;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the numberOfParticipants
	 */
	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}

	/**
	 * @param numberOfParticipants the numberOfParticipants to set
	 */
	public void setNumberOfParticipants(int numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}



	
	/**
	 * @return the myParticipants
	 */
	public List<PerUserTransaction> getMyParticipants() {
		return myParticipants;
	}

	/**
	 * @param myParticipants the myParticipants to set
	 */
	public void setMyParticipants(List<PerUserTransaction> myParticipants) {
		this.myParticipants = myParticipants;
	}

	/**
	 * @return the paidBy
	 */
	public String getPaidBy() {
		return paidBy;
	}

	/**
	 * @param paidBy the paidBy to set
	 */
	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}

	/**
	 * @param description
	 * @param amount
	 * @param numberOfParticipants
	 */
	public Bill(String paidBy, int description, int amount, int numberOfParticipants) {
		super();
		this.paidBy = paidBy;
		this.description = description;
		this.amount = amount;
		this.numberOfParticipants = numberOfParticipants;
		this.myParticipants = new ArrayList<PerUserTransaction>();
	}
	
	public Bill(){
		
		
	}
}
