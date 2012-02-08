package in.co.blackphoenix.shexp.messaging.data;

/**
 * Value Filter 
 * Filter that sets a value to the condition
 * @author Manoj
 *
 */
public class ValueFilter extends HistoryFilter {

	private String columnName; // Column name to be filtered
	private String filterValue; // Value of the filter
	
	/**
	 * Construct a filter with 
	 * @param columnName - name of the column to filter
	 * @param filterValue - value to filter
	 */
	public ValueFilter(String columnName, String filterValue) {
		super();
		this.columnName = columnName;
		this.filterValue = filterValue;
	}
	
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
	 * @return the filterValue
	 */
	public String getFilterValue() {
		return filterValue;
	}
	/**
	 * @param filterValue the filterValue to set
	 */
	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}
	
	
}
