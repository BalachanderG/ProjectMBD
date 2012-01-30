/**
 * 
 */
package in.co.blackphoenix.shexp.mysql.datastructure;

/**
 * ConditionPair
 * 
 * Data Structure to store the Condition for a query
 * 
 * left = 'right' expression
 * @author Manoj
 *
 */
public class ConditionPair extends Pair {

	public enum OperatorType {
		
		EQUALS {
			public String toString(){
				
				return "=";
			}
		},
		NOTEQUALS{
			public String toString(){
				
				return "<>";
			}
		},
		GREATERTHAN{
			public String toString(){
				
				return ">";
			}
		},
		GREATERTHANEQUALS{
			public String toString(){
				
				return ">=";
			}
		},
		LESSTHAN{
			public String toString(){
				
				return "<";
			}
		},
		LESSTHANEQUALS{
			public String toString(){
				
				return "<=";
			}
		}
	}
	
	private OperatorType myOperator = OperatorType.EQUALS;
	
	/**
	 * @param left - field name in the query condition
	 * @param right - value for the field 
	 */
	public ConditionPair(String left, String right) {
		super(left, right);
	}
	
	public ConditionPair(String left, String right, OperatorType operator) {
		super(left, right);
		this.setMyOperator(operator);
	}

	public String toString(){
		
		return super.getMyLeft() + " " + myOperator + " '" + super.getMyRight() + "'";
	}

	/**
	 * @return the myOperator
	 */
	public OperatorType getMyOperator() {
		return myOperator;
	}

	/**
	 * @param myOperator the myOperator to set
	 */
	public void setMyOperator(OperatorType myOperator) {
		this.myOperator = myOperator;
	}
	
}
