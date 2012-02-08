package in.co.blackphoenix.shexp.messaging.data;

/**
 * Value Filter 
 * Filter that sets a value to the condition
 * @author Manoj
 *
 */
public class DoubleValueFilter extends HistoryFilter {

	private double columnName; // Column name to be filtered
	private double filterValue; // Value of the filter
	
	/**
	 * Construct a filter with 
	 * @param columnName - name of the column to filter
	 * @param filterValue - value to filter
	 */
	public DoubleValueFilter(double columnName, double filterValue) {
		super();
		this.columnName = columnName;
		this.filterValue = filterValue;
	}
	
	/**
	 * @return the columnName
	 */
	public double getColumnName() {
		return columnName;
	}
	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(double columnName) {
		this.columnName = columnName;
	}
	/**
	 * @return the filterValue
	 */
	public double getFilterValue() {
		return filterValue;
	}
	/**
	 * @param filterValue the filterValue to set
	 */
	public void setFilterValue(double filterValue) {
		this.filterValue = filterValue;
	}
	
	
}
