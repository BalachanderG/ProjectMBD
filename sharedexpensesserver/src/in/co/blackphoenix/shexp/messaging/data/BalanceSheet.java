package in.co.blackphoenix.shexp.messaging.data;

import java.util.ArrayList;
import java.util.List;

public class BalanceSheet {
	
	
	/**
	 * Construct a balance sheet with all the details.
	 * @param myIOweYouList - details of people who have to pay me
	 * @param myYouOweMeList - details of peopple whom you have to pay
	 */
	public BalanceSheet(List<Payables> myIOweYouList,
			List<Receivables> myYouOweMeList) {
		
		this.myIOweYouList = myIOweYouList;
		this.myYouOweMeList = myYouOweMeList;
	}
	
	/** Construct an empty balance Sheet
	 * 
	 */
	public BalanceSheet(){
		
		this.myIOweYouList = new ArrayList<Payables>();
		this.myYouOweMeList = new ArrayList<Receivables>();
	}
	
	
	private List<Payables> myIOweYouList; // List of person who I owe money
	private List<Receivables> myYouOweMeList; // List of person who owe me money
	
	
	/***
	 * Add your details and how much I have to pay you
	 * @param YourDetails
	 */
	public void addToIOweYouList(Payables yourDetails){
		
		myIOweYouList.add(yourDetails);
	}
	
	/**
	 * Add your details and how much you have to pay me
	 * @param yourDetails
	 */
	public void addToYouOweList(Receivables yourDetails){
		
		myYouOweMeList.add(yourDetails);
	}
	/**
	 * @return the myIOweYouList
	 */
	public List<Payables> getMyIOweYouList() {
		return myIOweYouList;
	}
	/**
	 * @param myIOweYouList the myIOweYouList to set
	 */
	public void setMyIOweYouList(List<Payables> myIOweYouList) {
		this.myIOweYouList = myIOweYouList;
	}
	/**
	 * @return the myYouOweMeList
	 */
	public List<Receivables> getMyYouOweMeList() {
		return myYouOweMeList;
	}
	/**
	 * @param myYouOweMeList the myYouOweMeList to set
	 */
	public void setMyYouOweMeList(List<Receivables> myYouOweMeList) {
		this.myYouOweMeList = myYouOweMeList;
	}
	

}
