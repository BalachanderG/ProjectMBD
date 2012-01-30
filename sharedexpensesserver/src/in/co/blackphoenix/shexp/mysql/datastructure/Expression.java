/**
 * 
 */
package in.co.blackphoenix.shexp.mysql.datastructure;

/**
 * 
 * Expression 
 * DataStructure to store the nested Conditions 
 * Use the in order traversal to combine conditions with AND / OR operation in query
 * 
 * Regular Expression
 * Expression = Left Expression Operator Right Expression 
 * Expression = Condition
 * @author Manoj
 *
 */
public class Expression {

	public enum OperatorType {AND
		{ 
			public String toString(){
				
				return "AND";
			}
		}, OR
		{ 
			public String toString(){
				
				return "OR";
			}
		}
	};
	
	// Operator that combines the left and right expression
	private OperatorType myOperator = OperatorType.AND;
	
	// Condition stored in the expression
	private Pair myCondition = null;
	
	// Left and Right side of the Operator in the expression
	private Expression myLeftExpression = null;
	private Expression myRightExpression = null;
	
	public Expression(Pair condition){
		
		this.myCondition = condition;
	}
	
	public Expression(Expression leftExpression,
			OperatorType operator, 
			Expression rightExpression){
		
		this.myLeftExpression = leftExpression;
		this.myOperator = operator;
		this.myRightExpression = rightExpression;
	}

	/**
	 * Checks if the expression is single condition or a combination of conditions
	 * @return - true if the expression is a single condition
	 */
	public boolean isSingleCondition(){
		
		return (myCondition != null);
	}
	
	/**
	 * @return the myOperator
	 */
	public OperatorType getMyOperator() {
		return myOperator;
	}

	/**
	 * @return the myRightExpression
	 */
	public Expression getMyRightExpression() {
		return myRightExpression;
	}

	/**
	 * @return the myCondition
	 */
	public Pair getMyCondition() {
		return myCondition;
	}

	/**
	 * @return the myLeftExpression
	 */
	public Expression getMyLeftExpression() {
		return myLeftExpression;
	}

	/**
	 * Expands the Expression into a single string to be used in SQL query
	 */
	public String toString(){
		
		if(isSingleCondition()){
			
			return myCondition.toString();
		}else{
			
			String result = "(";
			
			result += myLeftExpression.toString();
			result += " " + myOperator + " ";
			result += myRightExpression.toString();
			
			return result;
		}
	}
}
