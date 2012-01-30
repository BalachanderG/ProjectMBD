/**
 * 
 */
package in.co.blackphoenix.shexp.mysql.datastructure;

/**
 * Data Structure that holds the foreign key Constraint for a table
 * @author Manoj
 *
 */
public class ForeignKey {

	public enum ReferentialActionType {
		RESTRICT{
			public String toString(){
				return "RESTRICT";
			}
		},
		CASCADE{
			public String toString(){
				return "CASCADE";
			}
		},
		NOACTION{
			public String toString(){
				return "NO ACTION";
			}
		},
		SETNULL{
			public String toString(){
				return "SET NULL";
			}
		}	
	}
	
	private Field myField = null; // field in table 
	private Field myReferenceField = null;
	private Table myReferenceTable = null;
	private ReferentialActionType onUpdate = ReferentialActionType.RESTRICT;
	private ReferentialActionType onDelete = ReferentialActionType.RESTRICT;
	
	/**
	 * Construct a constraint for foreign key
	 * @param myField - field
	 * @param myReferenceField - reference field
	 * @param myReferenceTable - reference table
	 */
	public ForeignKey(Field myField, Field myReferenceField,
			Table myReferenceTable) {
		super();
		this.myField = myField;
		this.myReferenceField = myReferenceField;
		this.myReferenceTable = myReferenceTable;
	}

	/**
	 * @return the myField
	 */
	public Field getMyField() {
		return myField;
	}

	/**
	 * @return the myReferenceField
	 */
	public Field getMyReferenceField() {
		return myReferenceField;
	}

	/**
	 * @return the myReferenceTable
	 */
	public Table getMyReferenceTable() {
		return myReferenceTable;
	}
	
	public String toString(){
		
		//foreign key in the sql query form
		// CONSTRAINT constraintname FOREIGN KEY (fieldname) REFERENCES tablename(fieldname) [ON UPDATE ACTION] [ON DELETE ACTION] 
		String constraintFK = "CONSTRAINT fk_" + myField.getMyName()
				+ " FOREIGN KEY ";
		
		constraintFK += "(" + myField.getMyName() + ")";
		constraintFK += " REFERENCES " + myReferenceTable.getMyName();
		constraintFK += "(" + myReferenceField.getMyName() + ")";
		
		// Append the on delete only if it is difference from DEFAULT ACTION RESTRICT
		if(onDelete != ReferentialActionType.RESTRICT){
			
			constraintFK += " ON DELETE " + onDelete;
		}
		
		// Append the on update only if it is difference from DEFAULT ACTION RESTRICT
		if(onUpdate != ReferentialActionType.RESTRICT){
			
			constraintFK += " ON UPDATE " + onUpdate;
		}
		
		return constraintFK;
	}
}
