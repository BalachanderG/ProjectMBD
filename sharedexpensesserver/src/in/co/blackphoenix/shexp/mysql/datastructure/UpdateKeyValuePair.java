/**
 * 
 */
package in.co.blackphoenix.shexp.mysql.datastructure;

/**
 * UpdateKeyValuePair
 * 
 * Data Structure to store the key value pair for the update query
 * left - field to be updated
 * right - new Value assigned to the field
 * @author Manoj
 *
 */
public class UpdateKeyValuePair extends Pair {

	/**
	 * @param left
	 * @param right
	 */
	
	/**
	 * 
	 * @param left - field to be updated
	 * @param right - new value for the field
	 */
	public UpdateKeyValuePair(String left, String right) {
		super(left, right);
	}

}
