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
import java.util.Date;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Mrs_scan_session.
 * 
 * @version $Revision$ $Date$
 */
public class Mrs_scan_session implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ursi
     */
    private java.lang.String _ursi;

    /**
     * Field _scan_label
     */
    private java.lang.String _scan_label;

    /**
     * Field _study_id
     */
    private int _study_id;

    /**
     * keeps track of state for field: _study_id
     */
    private boolean _has_study_id;

    /**
     * Field _site_id
     */
    private int _site_id;

    /**
     * keeps track of state for field: _site_id
     */
    private boolean _has_site_id;

    /**
     * Field _scanner_id
     */
    private int _scanner_id;

    /**
     * keeps track of state for field: _scanner_id
     */
    private boolean _has_scanner_id;

    /**
     * Field _scan_date
     */
    private java.util.Date _scan_date;

    /**
     * Field _notes
     */
    private java.lang.String _notes;


      //----------------/
     //- Constructors -/
    //----------------/

    public Mrs_scan_session() 
     {
        super();
    } //-- Mrs_scan_session()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteScanner_id
     * 
     */
    public void deleteScanner_id()
    {
        this._has_scanner_id= false;
    } //-- void deleteScanner_id() 

    /**
     * Method deleteSite_id
     * 
     */
    public void deleteSite_id()
    {
        this._has_site_id= false;
    } //-- void deleteSite_id() 

    /**
     * Method deleteStudy_id
     * 
     */
    public void deleteStudy_id()
    {
        this._has_study_id= false;
    } //-- void deleteStudy_id() 

    /**
     * Returns the value of field 'notes'.
     * 
     * @return String
     * @return the value of field 'notes'.
     */
    public java.lang.String getNotes()
    {
        return this._notes;
    } //-- java.lang.String getNotes() 

    /**
     * Returns the value of field 'scan_date'.
     * 
     * @return Date
     * @return the value of field 'scan_date'.
     */
    public java.util.Date getScan_date()
    {
        return this._scan_date;
    } //-- java.util.Date getScan_date() 

    /**
     * Returns the value of field 'scan_label'.
     * 
     * @return String
     * @return the value of field 'scan_label'.
     */
    public java.lang.String getScan_label()
    {
        return this._scan_label;
    } //-- java.lang.String getScan_label() 

    /**
     * Returns the value of field 'scanner_id'.
     * 
     * @return int
     * @return the value of field 'scanner_id'.
     */
    public int getScanner_id()
    {
        return this._scanner_id;
    } //-- int getScanner_id() 

    /**
     * Returns the value of field 'site_id'.
     * 
     * @return int
     * @return the value of field 'site_id'.
     */
    public int getSite_id()
    {
        return this._site_id;
    } //-- int getSite_id() 

    /**
     * Returns the value of field 'study_id'.
     * 
     * @return int
     * @return the value of field 'study_id'.
     */
    public int getStudy_id()
    {
        return this._study_id;
    } //-- int getStudy_id() 

    /**
     * Returns the value of field 'ursi'.
     * 
     * @return String
     * @return the value of field 'ursi'.
     */
    public java.lang.String getUrsi()
    {
        return this._ursi;
    } //-- java.lang.String getUrsi() 

    /**
     * Method hasScanner_id
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasScanner_id()
    {
        return this._has_scanner_id;
    } //-- boolean hasScanner_id() 

    /**
     * Method hasSite_id
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasSite_id()
    {
        return this._has_site_id;
    } //-- boolean hasSite_id() 

    /**
     * Method hasStudy_id
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasStudy_id()
    {
        return this._has_study_id;
    } //-- boolean hasStudy_id() 

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
     * Sets the value of field 'notes'.
     * 
     * @param notes the value of field 'notes'.
     */
    public void setNotes(java.lang.String notes)
    {
        this._notes = notes;
    } //-- void setNotes(java.lang.String) 

    /**
     * Sets the value of field 'scan_date'.
     * 
     * @param scan_date the value of field 'scan_date'.
     */
    public void setScan_date(java.util.Date scan_date)
    {
        this._scan_date = scan_date;
    } //-- void setScan_date(java.util.Date) 

    /**
     * Sets the value of field 'scan_label'.
     * 
     * @param scan_label the value of field 'scan_label'.
     */
    public void setScan_label(java.lang.String scan_label)
    {
        this._scan_label = scan_label;
    } //-- void setScan_label(java.lang.String) 

    /**
     * Sets the value of field 'scanner_id'.
     * 
     * @param scanner_id the value of field 'scanner_id'.
     */
    public void setScanner_id(int scanner_id)
    {
        this._scanner_id = scanner_id;
        this._has_scanner_id = true;
    } //-- void setScanner_id(int) 

    /**
     * Sets the value of field 'site_id'.
     * 
     * @param site_id the value of field 'site_id'.
     */
    public void setSite_id(int site_id)
    {
        this._site_id = site_id;
        this._has_site_id = true;
    } //-- void setSite_id(int) 

    /**
     * Sets the value of field 'study_id'.
     * 
     * @param study_id the value of field 'study_id'.
     */
    public void setStudy_id(int study_id)
    {
        this._study_id = study_id;
        this._has_study_id = true;
    } //-- void setStudy_id(int) 

    /**
     * Sets the value of field 'ursi'.
     * 
     * @param ursi the value of field 'ursi'.
     */
    public void setUrsi(java.lang.String ursi)
    {
        this._ursi = ursi;
    } //-- void setUrsi(java.lang.String) 

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
        return (Mrs_scan_session) Unmarshaller.unmarshal(Mrs_scan_session.class, reader);
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
