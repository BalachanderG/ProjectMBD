/**
 * 
 */
package in.co.blackphoenix.shexp.mysql.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Ordering
 * 
 * Structure to hold the details for order by in a sql query
 * @author Manoj
 *
 */
public class Ordering {

	public enum OrderType {
		ASC {
			public String toString(){
				
				return "ASC";
			}
		},
		DESC {
			public String toString(){
				
				return "DESC";
			}
		}
	}
	
	private List<Field> myOrderFields = null;
	private OrderType myOrderType = OrderType.ASC;
	
	/**
	 * 
	 * Ordering based on Mutiple Fields 
	 * @param myOrderFields - list of fields to order by
	 * @param myOrderType - ASC | DESC
	 */
	public Ordering(List<Field> myOrderFields, OrderType myOrderType) {
		super();
		this.myOrderFields = myOrderFields;
		this.myOrderType = myOrderType;
	}
	
	/**
	 * Order by single field
	 * @param myOrderField - field to order by
	 * @param myOrderType - ASC | DESC
	 */
	public Ordering(Field myOrderField, OrderType myOrderType) {
		super();
		this.myOrderFields = new ArrayList<Field>();
		this.myOrderFields.add(myOrderField);
		this.myOrderType = myOrderType;
	}

	/**
	 * @return the myOrderFields
	 */
	public Iterator<Field> getMyOrderFields() {
		return myOrderFields.iterator();
	}

	/**
	 * @return the myOrderType
	 */
	public OrderType getMyOrderType() {
		return myOrderType;
	}
	
	public String toString(){
		
		String ordering = "ORDER BY ";
		
		for(Field field : myOrderFields){
			
			ordering += field.getMyName() + ",";
		}
		
		ordering = ordering.substring(0, ordering.length() - 1) + " ";
		ordering += myOrderType;
		
		return ordering;
	}
}
