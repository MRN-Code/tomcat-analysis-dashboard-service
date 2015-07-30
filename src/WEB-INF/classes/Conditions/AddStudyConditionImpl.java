/*
 * Created on Jul 27, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Conditions;

import Database.databaseHandler;

/**
 * @author mscully
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AddStudyConditionImpl {
	
	static public String addStudyCondition(int study_id, String label, String description){
		String result = "All's Well";
		
		try{
			databaseHandler database = new databaseHandler();
			
			result = database.addStudyCondition(study_id, label, description);
		}
		catch(Exception e){
			result = "Exception caught in webservice: " + e;
		}
		
		return result;		
	}
}
