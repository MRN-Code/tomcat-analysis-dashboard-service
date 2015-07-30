/*
 * Created on Jun 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Conditions;

import java.sql.SQLException;

import general.RowWrapper;
import Database.databaseHandler;

/**
 * @author mscully
 *
 * Method to get the condition information from the database using the
 * submitted study_id.
 */
public class GetConditionsImpl {

	/* (non-Javadoc)
	 * @see Conditions.GetConditons#getConditions(int)
	 */
	public static RowWrapper getConditions(int studyID) {
		RowWrapper wrapper = new RowWrapper();
		try {
			databaseHandler database = new databaseHandler();
			
			String sqlString = "select condition_id, label, description " +
			  "from mrsdba.mrs_study_conditions_vw " +
			  "where study_id='" + studyID + "' " +
			  "order by label";
			
			wrapper = database.getResults(sqlString);
		}
		catch(SQLException sqlException){			
			if(sqlException.toString().indexOf("unique constraint") != -1){
				wrapper.setErrorMessage("Unique Constraint Violation");
			}
			else if (sqlException.toString().indexOf("MAX_PER_SEGMENT") != -1){
				wrapper.setErrorMessage("MAX_PER_SEGMENT Violation");
			}
			else
				wrapper.setErrorMessage("SQL Exception");
			// Log this
			//myLog.fatal("Abnormal SQL Exception " + sqlException + sqlException.getStackTrace());
			wrapper.setError(1);
			}
		catch(Exception e){
			System.out.println("Exception Caught: " + e + " " + e.getStackTrace());
			wrapper.setError(1);
			wrapper.setErrorMessage("Exception Caught: " + e + " " + e.getStackTrace());
		}
		
		return wrapper;
	}

}
