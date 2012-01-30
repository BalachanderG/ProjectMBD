/**
 * 
 */
package in.co.blackphoenix.shexp.mysql.datastructure;

/**
 * Pair
 * 
 * Class that stores the queries condition / update / join conditions
 * 
 * left = right expression
 * @author Manoj
 *
 */
public class Pair {
	
	private String myLeft = null;
	private String myRight = null;
	
	public Pair(String left, String right){
		
		this.setMyLeft(left);
		this.setMyRight(right);
	}

	/**
	 * @return the left
	 */
	public String getMyLeft() {
		return myLeft;
	}

	/**
	 * @param left the left to set
	 */
	public void setMyLeft(String left) {
		this.myLeft = left;
	}

	/**
	 * @return the right
	 */
	public String getMyRight() {
		return myRight;
	}

	/**
	 * @param right the right to set
	 */
	public void setMyRight(String right) {
		this.myRight = right;
	}

	public String toString(){
		
		return myLeft + " = '" + myRight + "'";
	}
}
