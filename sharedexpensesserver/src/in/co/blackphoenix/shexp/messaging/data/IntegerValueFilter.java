package in.co.blackphoenix.shexp.messaging.data;

/**
 * Value Filter 
 * Filter that sets a value to the condition
 * @author Manoj
 *
 */
public class IntegerValueFilter extends HistoryFilter {

	private int columnName; // Column name to be filtered
	private int filterValue; // Value of the filter
	
	/**
	 * Construct a filter with 
	 * @param columnName - name of the column to filter
	 * @param filterValue - value to filter
	 */
	public IntegerValueFilter(int columnName, int filterValue) {
		super();
		this.columnName = columnName;
		this.filterValue = filterValue;
	}
	
	/**
	 * @return the columnName
	 */
	public int getColumnName() {
		return columnName;
	}
	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(int columnName) {
		this.columnName = columnName;
	}
	/**
	 * @return the filterValue
	 */
	public int getFilterValue() {
		return filterValue;
	}
	/**
	 * @param filterValue the filterValue to set
	 */
	public void setFilterValue(int filterValue) {
		this.filterValue = filterValue;
	}
	
	
}
