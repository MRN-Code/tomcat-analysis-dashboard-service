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

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Mrs_scan_series.
 * 
 * @version $Revision$ $Date$
 */
public class Mrs_scan_series implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _series_id
     */
    private int _series_id;

    /**
     * keeps track of state for field: _series_id
     */
    private boolean _has_series_id;

    /**
     * Field _study_condition_id
     */
    private java.lang.String _study_condition_id;

    /**
     * Field _study_code_id
     */
    private java.lang.String _study_code_id;

    /**
     * Field _usable
     */
    private java.lang.String _usable;

    /**
     * Field _note
     */
    private java.lang.String _note;


      //----------------/
     //- Constructors -/
    //----------------/

    public Mrs_scan_series() 
     {
        super();
    } //-- Mrs_scan_series()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteSeries_id
     * 
     */
    public void deleteSeries_id()
    {
        this._has_series_id= false;
    } //-- void deleteSeries_id() 

    /**
     * Returns the value of field 'note'.
     * 
     * @return String
     * @return the value of field 'note'.
     */
    public java.lang.String getNote()
    {
        return this._note;
    } //-- java.lang.String getNote() 

    /**
     * Returns the value of field 'series_id'.
     * 
     * @return int
     * @return the value of field 'series_id'.
     */
    public int getSeries_id()
    {
        return this._series_id;
    } //-- int getSeries_id() 

    /**
     * Returns the value of field 'study_code_id'.
     * 
     * @return String
     * @return the value of field 'study_code_id'.
     */
    public java.lang.String getStudy_code_id()
    {
        return this._study_code_id;
    } //-- java.lang.String getStudy_code_id() 

    /**
     * Returns the value of field 'study_condition_id'.
     * 
     * @return String
     * @return the value of field 'study_condition_id'.
     */
    public java.lang.String getStudy_condition_id()
    {
        return this._study_condition_id;
    } //-- java.lang.String getStudy_condition_id() 

    /**
     * Returns the value of field 'usable'.
     * 
     * @return String
     * @return the value of field 'usable'.
     */
    public java.lang.String getUsable()
    {
        return this._usable;
    } //-- java.lang.String getUsable() 

    /**
     * Method hasSeries_id
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasSeries_id()
    {
        return this._has_series_id;
    } //-- boolean hasSeries_id() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return boolean
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param out
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param handler
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Sets the value of field 'note'.
     * 
     * @param note the value of field 'note'.
     */
    public void setNote(java.lang.String note)
    {
        this._note = note;
    } //-- void setNote(java.lang.String) 

    /**
     * Sets the value of field 'series_id'.
     * 
     * @param series_id the value of field 'series_id'.
     */
    public void setSeries_id(int series_id)
    {
        this._series_id = series_id;
        this._has_series_id = true;
    } //-- void setSeries_id(int) 

    /**
     * Sets the value of field 'study_code_id'.
     * 
     * @param study_code_id the value of field 'study_code_id'.
     */
    public void setStudy_code_id(java.lang.String study_code_id)
    {
        this._study_code_id = study_code_id;
    } //-- void setStudy_code_id(java.lang.String) 

    /**
     * Sets the value of field 'study_condition_id'.
     * 
     * @param study_condition_id the value of field
     * 'study_condition_id'.
     */
    public void setStudy_condition_id(java.lang.String study_condition_id)
    {
        this._study_condition_id = study_condition_id;
    } //-- void setStudy_condition_id(java.lang.String) 

    /**
     * Sets the value of field 'usable'.
     * 
     * @param usable the value of field 'usable'.
     */
    public void setUsable(java.lang.String usable)
    {
        this._usable = usable;
    } //-- void setUsable(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (Mrs_scan_series) Unmarshaller.unmarshal(Mrs_scan_series.class, reader);
    } //-- java.lang.Object unmarshal(java.io.Reader) 

    /**
     * Method validate
     * 
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
