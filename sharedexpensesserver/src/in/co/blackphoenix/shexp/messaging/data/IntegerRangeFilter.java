package in.co.blackphoenix.shexp.messaging.data;

public class IntegerRangeFilter extends HistoryFilter {

	// Name of the column to be queried
	private String columnName;
	
	// Lower Limit of the range
	private int min;
	
	//Higher Limit of the range
	private int max;
	
	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}
	

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}
	


	/**
	 * Construct a filter with the following details
	 * @param columnName - name of the column to be filtered
	 * @param min - lower limit
	 * @param max - higher limit
	 */
	public IntegerRangeFilter(String columnName, int min, int max) {
		super();
		this.columnName = columnName;
		this.min = min;
		this.max = max;
	}

	/**
	 * function to convert the details into condition in the SQL format
	 * @return - condition of values between min and max
	 */
	public String toSqlCondition(){
		
		return columnName + " < " + max + " AND "
		+ columnName + " > " + min;
	}
	
}
