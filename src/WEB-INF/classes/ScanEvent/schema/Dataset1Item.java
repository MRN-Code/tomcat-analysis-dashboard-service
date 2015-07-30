package ScanEvent.schema;

/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id$
 */

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class Dataset1Item.
 * 
 * @version $Revision$ $Date$
 */
public class Dataset1Item implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _mrs_scan_series
     */
    private Mrs_scan_series _mrs_scan_series;

    /**
     * Field _mrs_scan_session
     */
    private Mrs_scan_session _mrs_scan_session;


      //----------------/
     //- Constructors -/
    //----------------/

    public Dataset1Item() 
     {
        super();
    } //-- Dataset1Item()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return Object
     * @return the value of field 'choiceValue'.
     */
    public java.lang.Object getChoiceValue()
    {
        return this._choiceValue;
    } //-- java.lang.Object getChoiceValue() 

    /**
     * Returns the value of field 'mrs_scan_series'.
     * 
     * @return Mrs_scan_series
     * @return the value of field 'mrs_scan_series'.
     */
    public Mrs_scan_series getMrs_scan_series()
    {
        return this._mrs_scan_series;
    } //-- Mrs_scan_series getMrs_scan_series() 

    /**
     * Returns the value of field 'mrs_scan_session'.
     * 
     * @return Mrs_scan_session
     * @return the value of field 'mrs_scan_session'.
     */
    public Mrs_scan_session getMrs_scan_session()
    {
        return this._mrs_scan_session;
    } //-- Mrs_scan_session getMrs_scan_session() 

    /**
     * Sets the value of field 'mrs_scan_series'.
     * 
     * @param mrs_scan_series the value of field 'mrs_scan_series'.
     */
    public void setMrs_scan_series(Mrs_scan_series mrs_scan_series)
    {
        this._mrs_scan_series = mrs_scan_series;
        this._choiceValue = mrs_scan_series;
    } //-- void setMrs_scan_series(Mrs_scan_series) 

    /**
     * Sets the value of field 'mrs_scan_session'.
     * 
     * @param mrs_scan_session the value of field 'mrs_scan_session'
     */
    public void setMrs_scan_session(Mrs_scan_session mrs_scan_session)
    {
        this._mrs_scan_session = mrs_scan_session;
        this._choiceValue = mrs_scan_session;
    } //-- void setMrs_scan_session(Mrs_scan_session) 

}
