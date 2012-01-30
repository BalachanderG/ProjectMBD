/**
 * 
 */
package in.co.blackphoenix.shexp.mysql.datastructure;

/**
 * Field 
 * 
 * Details about a single column in a table.
 * @author Manoj
 */
public class Field {

	private String myName = null;
	private String myDataType = null;
	private boolean isUnique = false;
	private boolean isNULL = false;
	private boolean isAutoIncrement = false;
	private String myDefaultValue = null;
	
	/**
	 * Construct a new field with a name and its data type
	 * @param name - name of the new Field
	 * @param dataType - name of the data Type
	 */
	public Field(String name, String dataType){
		
		this.myName = name;
		this.myDataType = dataType;
	}

	/**
	 * @return the myName
	 */
	public String getMyName() {
		return myName;
	}

	/**
	 * @param myName the myName to set
	 */
	public void setMyName(String myName) {
		this.myName = myName;
	}

	/**
	 * @return the myDataType
	 */
	public String getMyDataType() {
		return myDataType;
	}

	/**
	 * @param myDataType the myDataType to set
	 */
	public void setMyDataType(String myDataType) {
		this.myDataType = myDataType;
	}

	/**
	 * @return the isUnique
	 */
	public boolean isUnique() {
		return isUnique;
	}

	/**
	 * @param isUnique the isUnique to set
	 */
	public void setUnique(boolean isUnique) {
		this.isUnique = isUnique;
	}

	/**
	 * @return the isNULL
	 */
	public boolean isNULL() {
		return isNULL;
	}

	/**
	 * @param isNULL the isNULL to set
	 */
	public void setNULL(boolean isNULL) {
		this.isNULL = isNULL;
	}

	/**
	 * @return the isAutoIncrement
	 */
	public boolean isAutoIncrement() {
		return isAutoIncrement;
	}

	/**
	 * @param isAutoIncrement the isAutoIncrement to set
	 */
	public void setAutoIncrement(boolean isAutoIncrement) {
		this.isAutoIncrement = isAutoIncrement;
	}

	/**
	 * @return the myDefaultValue
	 */
	public String getMyDefaultValue() {
		return myDefaultValue;
	}

	/**
	 * @param myDefaultValue the myDefaultValue to set
	 */
	public void setMyDefaultValue(String myDefaultValue) {
		this.myDefaultValue = myDefaultValue;
	}
	
	public String toString(){
		
		String fieldDetails = myName + " " + myDataType;
		
		if(!isNULL){
			
			fieldDetails += " NOT NULL";
		}
		
		if(!isUnique){
			
			fieldDetails += " UNIQUE";
		}
		
		if(!isAutoIncrement){
			
			
			fieldDetails += " AUTOINCREMENT";
		}
		
		if(myDefaultValue != null){
			
			fieldDetails += " DEFAULT '" + myDefaultValue + "'";
		}
		
		return fieldDetails;
	}
}
