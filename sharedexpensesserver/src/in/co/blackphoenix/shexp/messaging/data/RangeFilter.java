package in.co.blackphoenix.shexp.messaging.data;

public class RangeFilter extends HistoryFilter {

	// Name of the column to be queried
	private String columnName;
	
	// Lower Limit of the range
	private String min;
	
	//Higher Limit of the range
	private String max;
	
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
	public String getMin() {
		return min;
	}
	
	/**
	 * @param min the min to set
	 */
	public void setMin(String min) {
		this.min = min;
	}

	/**
	 * @return the max
	 */
	public String getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(String max) {
		this.max = max;
	}

	/**
	 * Construct a filter with the following details
	 * @param columnName - name of the column to be filtered
	 * @param min - lower limit
	 * @param max - higher limit
	 */
	public RangeFilter(String columnName, String min, String max) {
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
