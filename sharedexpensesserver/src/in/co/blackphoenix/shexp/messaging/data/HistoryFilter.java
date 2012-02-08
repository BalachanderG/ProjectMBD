package in.co.blackphoenix.shexp.messaging.data;

/**
 * HistoryFilter
 * 
 * Filter with no conditions
 * @author Manoj
 *
 */
public class HistoryFilter {

	public HistoryFilter(){}
	
	
	/**
	 * function to convert the details into condition in the SQL format
	 * @return - null since there is no condition
	 */
	public String toSqlCondition(){
		
		return null;
	}
}
