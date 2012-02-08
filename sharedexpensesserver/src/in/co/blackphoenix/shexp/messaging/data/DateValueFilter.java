package in.co.blackphoenix.shexp.messaging.data;

import java.sql.Date;

/**
 * Value Filter 
 * Filter that sets a value to the condition
 * @author Manoj
 *
 */
public class DateValueFilter extends HistoryFilter {

	private Date columnName; // Column name to be filtered
	private Date filterValue; // Value of the filter
	
	/**
	 * Construct a filter with 
	 * @param columnName - name of the column to filter
	 * @param filterValue - value to filter
	 */
	public DateValueFilter(Date columnName, Date filterValue) {
		super();
		this.columnName = columnName;
		this.filterValue = filterValue;
	}
	
	/**
	 * @return the columnName
	 */
	public Date getColumnName() {
		return columnName;
	}
	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(Date columnName) {
		this.columnName = columnName;
	}
	/**
	 * @return the filterValue
	 */
	public Date getFilterValue() {
		return filterValue;
	}
	/**
	 * @param filterValue the filterValue to set
	 */
	public void setFilterValue(Date filterValue) {
		this.filterValue = filterValue;
	}
	
	
}