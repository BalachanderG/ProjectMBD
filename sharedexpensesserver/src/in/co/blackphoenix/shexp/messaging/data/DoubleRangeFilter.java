package in.co.blackphoenix.shexp.messaging.data;

public class DoubleRangeFilter extends HistoryFilter {

	// Name of the column to be queried
	private String columnName;
	
	// Lower Limit of the range
	private double min;
	
	//Higher Limit of the range
	private double max;
	
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
	public double getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(double min) {
		this.min = min;
	}
	

	/**
	 * @return the max
	 */
	public double getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(double max) {
		this.max = max;
	}
	


	/**
	 * Construct a filter with the following details
	 * @param columnName - name of the column to be filtered
	 * @param min - lower limit
	 * @param max - higher limit
	 */
	public DoubleRangeFilter(String columnName, double min, double max) {
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
