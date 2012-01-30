/**
 * 
 */
package in.co.blackphoenix.shexp.mysql.datastructure;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Table 
 * Data Structure that holds the details about single table in a database
 * @author Manoj
 *
 */
public class Table {
	
	/**
	 * JOIN Types allowed in a SQL SELECT query
	 * @author Manoj
	 *
	 */
	public enum JoinType{
		
		INNERJOIN{
			
			public String toString(){
				
				return "INNER JOIN";
			}
		},
		FULLJOIN{
			
			public String toString(){
				
				return "FULL JOIN";
			}
		},
		LEFTJOIN{
			
			public String toString(){
				
				return "LEFT JOIN";
			}
		},
		RIGHTJOIN{
			
			public String toString(){
				
				return "RIGHT JOIN";
			}
		}
	}
	
	/**
	 * Functions that are allowed on a field in a SQL query
	 * @author Manoj
	 *
	 */
	public enum FunctionType {
		
		SUM{
			public String toString(){
				
				return "SUM";
			}
		},
		AVERAGE{
			public String toString(){
				
				return "AVG";
			}
		},
		
		NONE
	}
	
	private String myName = null; // Name of the table
	private Map<String, Field> myFields = null; // List of fields in the table
	private PrimaryKey myPrimaryKey = null; // Primary Key constraint for the table
	private Map<String, ForeignKey> myForiegnKeys = null; // list of foreign key constraints
	
	/**
	 * Construct a table with following details
	 * @param myName - name of the table
	 * @param myFields - fields in the table
	 * @param myPrimaryKey - primary key constraint for the table
	 */
	public Table(String myName, Map<String, Field> myFields, PrimaryKey myPrimaryKey) {
		super();
		this.myName = myName;
		this.myFields = myFields;
		this.myPrimaryKey = myPrimaryKey;
	}

	/**
	 * Construct a table with following details
	 * @param myName - name of the table
	 * @param myFields - fields in the table
	 * @param myPrimaryKey - primary key constraint for the table
	 * @param myForiegnKeys - list of foreign key constraints for the table
	 */
	public Table(String myName, Map<String, Field> myFields, PrimaryKey myPrimaryKey,
			Map<String, ForeignKey> myForiegnKeys) {
		super();
		this.myName = myName;
		this.myFields = myFields;
		this.myPrimaryKey = myPrimaryKey;
		this.myForiegnKeys = myForiegnKeys;
	}

	/**
	 * @return the myName
	 */
	public String getMyName() {
		return myName;
	}

	/**
	 * @return the myFields
	 */
	public Iterator<Field> getMyFields() {
		return myFields.values().iterator();
	}
	
	/**
	 * 
	 * @return number of fields in the table
	 */
	public int getNumberOfFields(){
		
		return myFields.size();
	}
	
	/**
	 * get the field details from
	 * @param fieldName - name of the field
	 * @return -  field object containing the details about a field
	 */
	public Field getField(String fieldName){
		
		return myFields.get(fieldName);
	}

	/**
	 * check if the field is there in the table
	 * @param fieldName - name of the field
	 * @return - true if the table contains field name false otherwise
	 */
	public boolean hasField(String fieldName){
		
		return myFields.containsKey(fieldName);
	}
	
	/**
	 * @return the myPrimaryKey
	 */
	public PrimaryKey getMyPrimaryKey() {
		return myPrimaryKey;
	}
	
	/**
	 * Access to the foreign key constraints
	 * @return 
	 */
	public Iterator<ForeignKey> getForeignKeys(){
		
		return myForiegnKeys.values().iterator();
	}
	
	/**
	 * Compiles a query to create the table 
	 * @return - query to create the table
	 */
	public String queryToCreateMe(){
		
		String createQuery = "CREATE TABLE " + myName + " (\n"; 
		
		for(Field field : myFields.values()){
			
			createQuery += field + ",\n";
		}
		
		if(myForiegnKeys != null && myForiegnKeys.size() > 0){
			
			for(ForeignKey fkey : myForiegnKeys.values()){
				
				createQuery += fkey + ",\n";
			}
		}
		
		createQuery += myPrimaryKey;
		createQuery += ")";
		return createQuery;
	}
	
	/**
	 * delete table query
	 * @return query to delete this table
	 */
	public String queryToDeleteMe(){
		
		String deleteQuery = "DELETE TABLE " + myName;
		
		return deleteQuery;
	}
	
	/**
	 * Select records from the table
	 * @param neededFields - list of fields and the corresponding function to be executed on the field. set FunctionType to NONE for no function.
	 * @return - SELECT query
	 */
	public String queryToSelectRecords(Map<String, FunctionType> neededFields){
		 
		String selectQuery = "SELECT ";
		
		for(String fieldName: neededFields.keySet()){
			
			if(neededFields.get(fieldName) == FunctionType.NONE){

				selectQuery += fieldName + ",";
			}else{
				
				selectQuery += neededFields.get(fieldName) + "(" + fieldName + "),";
			}
		}
		
		selectQuery = selectQuery.substring(0, selectQuery.length() - 1);
		
		selectQuery += " FROM " + myName;
		
		return selectQuery;
	}
	
	/**
	 * Select records from table
	 * @param neededFields - list of fields and the corresponding function to be executed on the field. set FunctionType to NONE for no function.
	 * @param conditions - conditions that go with WHERE clause 
	 * @return - SELECT query
	 */
	public String queryToSelectRecords(Map<String, FunctionType> neededFields,
			Expression conditions){
		
		String selectQuery = this.queryToSelectRecords(neededFields);
		
		selectQuery += " WHERE " + conditions;
		
		return selectQuery;
	}
	
	/**
	 * Select records from table
	 * @param neededFields -  list of fields and the corresponding function to be executed on the field. set FunctionType to NONE for no function.
	 * @param conditions - conditions in WHERE clause
 	 * @param groupByFieldName - groupBy clause details
	 * @return - SELECT query
	 */
	public String queryToSelectRecords(Map<String, FunctionType> neededFields,
			Expression conditions,
			String groupByFieldName){
		
		String selectQuery = this.queryToSelectRecords(neededFields, conditions);
		selectQuery += " GROUP BY " + groupByFieldName;
		
		return selectQuery;
	}
	
	/**
	 * Select records from table
	 * @param neededFields - list of fields and the corresponding function to be executed on the field. set FunctionType to NONE for no function.
	 * @param ordering - ORDER BY clause 
	 * @return - SELECT query
	 */
	public String queryToSelectRecords(Map<String, FunctionType> neededFields,
			Ordering ordering){
		 
		String selectQuery = queryToSelectRecords(neededFields);
		selectQuery += " " + ordering;
		
		return selectQuery;
	}
	
	/**
	 * Select records from table
	 * @param neededFields - list of fields and the corresponding function to be executed on the field. set FunctionType to NONE for no function.
	 * @param conditions - Conditions in WHERE clause
	 * @param ordering - ORDER By Clause details
	 * @return - SELECT query
	 */
	public String queryToSelectRecords(Map<String, FunctionType> neededFields,
			Expression conditions,
			Ordering ordering){
		
		String selectQuery = this.queryToSelectRecords(neededFields, conditions);
		selectQuery += " " + ordering;
		
		return selectQuery;
	}
	
	/**
	 * Select records from table
	 * @param neededFields - list of fields and the corresponding function to be executed on the field. set FunctionType to NONE for no function.
	 * @param conditions - Conditions in WHERE clause
	 * @param groupByFieldName - GROUP By details
	 * @param ordering - ORDER BY clause details
	 * @return - SELECT query
	 */
	public String queryToSelectRecords(Map<String, FunctionType> neededFields,
			Expression conditions,
			String groupByFieldName,
			Ordering ordering){
		
		String selectQuery = this.queryToSelectRecords(neededFields, conditions, groupByFieldName);
		
		return selectQuery;
	}
	
	/**
	 * INSERT record into table
	 * @param valuesToInsert - Values to be inserted into table
	 * @return - INSERT query
	 */
	public String queryToInsertRecords(List<UpdateKeyValuePair> valuesToInsert){
		
		String insertQuery = "INSERT INTO " + myName + " ";
		
		String fields = "(";
		String values = "(";
		
		for(UpdateKeyValuePair insertPair: valuesToInsert){
			
			fields += insertPair.getMyLeft() + ",";
			values += "'" + insertPair.getMyRight() + "',";
		}
		
		fields = fields.substring(0, fields.length() - 1) + ")";
		values = values.substring(0 , values.length() - 1) + ")";
		
		insertQuery += fields + " VALUES " + values;
		
		return insertQuery;
	}
	
	/**
	 * Update existing records in table
	 * @param valuesToUpdate - values to be updated
	 * @return - UPDATE query
	 */
	public String queryToUpdateRecords(List<UpdateKeyValuePair> valuesToUpdate){
		
		String updateQuery = "UPDATE " + myName + " SET ";
		
		for(UpdateKeyValuePair updatePair: valuesToUpdate){
			
			updateQuery += updatePair + ",";
		}
		
		updateQuery = updateQuery.substring(0, updateQuery.length() - 1);
		return updateQuery;
	}
	
	/**
	 * Update existing records in table
	 * @param valuesToUpdate - values to be updated
	 * @param conditions - conditions in WHERE clause
	 * @return - UPDATE query
	 */
	public String queryToUpdateRecords(List<UpdateKeyValuePair> valuesToUpdate,
			Expression conditions){
		
		String updateQuery = queryToUpdateRecords(valuesToUpdate);
		updateQuery = " WHERE " + conditions;
		
		return updateQuery;
	}
	
	/**
	 * Delete records from table
	 * @param conditions - conditions in WHERE clause
	 * @return - DELETE query
	 */
	public String queryToDeleteRecords(Expression conditions){
		
		String deleteQuery = "DELETE FROM " + myName + " WHERE ";
		deleteQuery += conditions;
		
		return deleteQuery;
	}
	
	/**
	 * select records from two or more tables
	 * @param neededFields - list of fields (use <b>TABLENAME.FIELDNAME</b>) and the corresponding function to be executed on the field. set FunctionType to NONE for no function.
	 * @param joiningTables - list of tables to select records from. <i> does not include current table </i>
	 * @param joinType - Type of JOIN that should be performed. INNER | FULL | LEFT | RIGHT
	 * @return - SELECT query
	 */
	public String queryToJoinTable(Map<String, FunctionType> neededFields,
			List<Table> joiningTables,
			JoinType joinType){
		
		String selectQuery = queryToSelectRecords(neededFields);
		
		String joinTables = "";
		for(Table joiningTable : joiningTables){
			
			if(!joiningTable.getMyName().equals(myName))
				joinTables += joiningTable.getMyName() + ",";
		}
		
		selectQuery += " " + joinType;
		selectQuery += joinTables.substring(0, joinTables.length() - 1);
		
		return selectQuery;
	}
	

	/**
	 * select records from two or more tables
	 * @param neededFields - list of fields (use <b>TABLENAME.FIELDNAME</b>) and the corresponding function to be executed on the field. set FunctionType to NONE for no function.
	 * @param joiningTables - list of tables to select records from. <i> does not include current table </i>
	 * @param joinType - Type of JOIN that should be performed. INNER | FULL | LEFT | RIGHT
	 * @param joinConditions - conditions for ON clause  					
	 * @return - SELECT query
	 */
	public String queryToJoinTable(Map<String, FunctionType> neededFields,
			List<Table> joiningTables,
			JoinType joinType,
			Expression joinConditions){
	
		String selectQuery = queryToJoinTable(neededFields, joiningTables, joinType);
		selectQuery += " ON " + joinConditions;
		
		return selectQuery;
	}
	
	/**
	 * select records from two or more tables
	 * @param neededFields - list of fields (use <b>TABLENAME.FIELDNAME</b>) and the corresponding function to be executed on the field. set FunctionType to NONE for no function.
	 * @param joiningTables - list of tables to select records from. <i> does not include current table </i>
	 * @param joinType - Type of JOIN that should be performed. INNER | FULL | LEFT | RIGHT
	 * @param joinConditions - conditions for ON clause
	 * @param whereConditions - conditions for WHERE clause
	 * @return - SELECT query
	 */
	public String queryToJoinTable(Map<String, FunctionType> neededFields,
			List<Table> joiningTables,
			JoinType joinType,
			Expression whereConditions,
			Expression joinConditions){
		
		String selectQuery = queryToJoinTable(neededFields, joiningTables, joinType, joinConditions);
		selectQuery += " WHERE " + whereConditions;
		
		return selectQuery;
	}
}
