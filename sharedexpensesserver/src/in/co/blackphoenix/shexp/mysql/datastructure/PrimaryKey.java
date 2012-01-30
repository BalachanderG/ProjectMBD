/**
 * 
 */
package in.co.blackphoenix.shexp.mysql.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * PrimaryKey
 * 
 * Data Structure to store the primary key constraint
 * 
 * list of the fields that make the primary key
 * @author Manoj
 *
 */
public class PrimaryKey {

	// List that contains a list of primary key fields
	private List<Field> myPKFields = null;
	
	/**
	 * Construct a primary key with one field in table
	 * @param primaryKey
	 */
	public PrimaryKey(Field primaryKey){
		
		myPKFields = new ArrayList<Field>();
		myPKFields.add(primaryKey);
	}
	
	/**
	 * Construct a primary key with list of fields from a table
	 * @param primaryKeys
	 */
	public PrimaryKey(List<Field> primaryKeys){
		
		myPKFields = new ArrayList<Field>();
		myPKFields.addAll(primaryKeys);
	}

	/***
	 * iterator to read the fields in the primary key list
	 * @return
	 */
	public Iterator<Field> getIterator(){
		
		return myPKFields.iterator();
	}
	

	public String toString(){
		
		// follows the sql representation of primary key constraint
		// CONSTRAINT constraint_name PRIMARY KEY (field1, field2,...)
		String primaryKeyString = "CONSTRAINT pk_1 PRIMARY KEY (";
		
		for(Field pkField : myPKFields){
			
			primaryKeyString += pkField.getMyName() + ",";
		}
		
		primaryKeyString = primaryKeyString.substring(0, primaryKeyString.length() - 1) + ")";
		
		return primaryKeyString;
	} 
} 
