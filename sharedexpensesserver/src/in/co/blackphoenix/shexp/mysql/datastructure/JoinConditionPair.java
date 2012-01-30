/**
 * 
 */
package in.co.blackphoenix.shexp.mysql.datastructure;

/**
 * JoinConditionPair
 * 
 * Data Structure to store the left and right side of a join column condition
 * 
 * @author Manoj
 *
 */
public class JoinConditionPair extends Pair {

	private String myLeftTable = null;
	private String myRightTable = null;
	
	/**
	 * 
	 * @param leftTable - Table to which the left field belongs
	 * @param leftField - Field to be matched for Join
	 * @param rightTable - Table to which the right field belongs
	 * @param rightField - Field to be matched for Join
	 */
	public JoinConditionPair(String leftTable,
			String leftField, 
			String rightTable,
			String rightField) {
		
		super(leftField, rightField);
		
		this.setMyLeftTable(leftTable);
		this.setMyRightTable(rightTable);
	}

	/**
	 * @return the myLeftTable
	 */
	public String getMyLeftTable() {
		return myLeftTable;
	}

	/**
	 * @param myLeftTable the myLeftTable to set
	 */
	public void setMyLeftTable(String myLeftTable) {
		this.myLeftTable = myLeftTable;
	}

	/**
	 * @return the myRightTable
	 */
	public String getMyRightTable() {
		return myRightTable;
	}

	/**
	 * @param myRightTable the myRightTable to set
	 */
	public void setMyRightTable(String myRightTable) {
		this.myRightTable = myRightTable;
	}
	
	public String toString(){
		
		return this.myLeftTable + "." + this.getMyLeft() +
				" = " + this.myRightTable + "." + this.getMyRight();
	}

}
