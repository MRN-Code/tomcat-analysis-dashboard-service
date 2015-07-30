package acceptAssessment;
import java.sql.SQLException;
import java.util.Vector;

/*
 * This class validates the properties information of the xml submission by connecting to the database.
 * The database connection itself is handled by the databaseHandler, an object that gets passed in.
 */

public class ValidateAssessment {
	
	// need to handle exceptions
	
	/*
	 * This function accepts the URSI, the RatorID, and a databaseHandler.  It uses sql select
	 * statements to query the database for the existence of the URSI and the RatorID.  The select
	 * statements are sent to the database via the handleStatement call.
	 * 
	 * First, this should all be in a common library
	 * Second, if we are checking this validity we should also be checking the protocol
	 * and rejecting assessments inappropriate for a subject type or visit.
	 */
	static public String validateAssessment(String ursi, String raterId, int studyID, databaseHandler database) throws ClassNotFoundException, SQLException {
		Vector databaseResult = new Vector();
		
		
		/* check studies table to see if this is a valid study id */
		databaseResult = database.handleStatement("Select study_id " + 
					"from mrsdba.mrs_studies_vw " +
					"where study_id = " + studyID);
		
		if(databaseResult.isEmpty()){
			return "Invalid Study ID";
		}
		
		
		/* check that:
		 * a) URSI is valid
		 * b) URSI is enrolled in study
		 * c) URSI is active in study
		 * d) assumes that study_id has been checked
		 * 
		 * Reject if not all of these
		 */ 
		databaseResult = database.handleStatement("Select ursi " +
				"from mrsdba.mrs_subject_details_active_vw  " +
				"where ursi='" + ursi + "'" + 
				"and study_id = " + studyID);
		
		if (databaseResult.isEmpty()) {
			return "URSI: '" + ursi + "' is not enrolled or active in study.";
		}
		
		
		/* check that rater alias_id is valid */
		databaseResult = 
			database.handleStatement("Select alias_id " +
					"from mrsdba.mrs_raters_vw " +
					"where alias_label='" + raterId + "'");
		
		if (databaseResult.isEmpty()) {
			return "Invalid Rater";
		}
		

		
		return "No error";
	}

}
