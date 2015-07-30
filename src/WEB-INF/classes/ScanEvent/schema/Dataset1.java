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
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Dataset1.
 * 
 * @version $Revision$ $Date$
 */
public class Dataset1 implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items
     */
    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public Dataset1() 
     {
        super();
        _items = new Vector();
    } //-- Dataset1()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDataset1Item
     * 
     * 
     * 
     * @param vDataset1Item
     */
    public void addDataset1Item(Dataset1Item vDataset1Item)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vDataset1Item);
    } //-- void addDataset1Item(Dataset1Item) 

    /**
     * Method addDataset1Item
     * 
     * 
     * 
     * @param index
     * @param vDataset1Item
     */
    public void addDataset1Item(int index, Dataset1Item vDataset1Item)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vDataset1Item, index);
    } //-- void addDataset1Item(int, Dataset1Item) 

    /**
     * Method enumerateDataset1Item
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateDataset1Item()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateDataset1Item() 

    /**
     * Method getDataset1Item
     * 
     * 
     * 
     * @param index
     * @return Dataset1Item
     */
    public Dataset1Item getDataset1Item(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("getDataset1Item: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        
        return (Dataset1Item) _items.elementAt(index);
    } //-- Dataset1Item getDataset1Item(int) 

    /**
     * Method getDataset1Item
     * 
     * 
     * 
     * @return Dataset1Item
     */
    public Dataset1Item[] getDataset1Item()
    {
        int size = _items.size();
        Dataset1Item[] mArray = new Dataset1Item[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (Dataset1Item) _items.elementAt(index);
        }
        return mArray;
    } //-- Dataset1Item[] getDataset1Item() 

    /**
     * Method getDataset1ItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getDataset1ItemCount()
    {
        return _items.size();
    } //-- int getDataset1ItemCount() 

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
     * Method removeAllDataset1Item
     * 
     */
    public void removeAllDataset1Item()
    {
        _items.removeAllElements();
    } //-- void removeAllDataset1Item() 

    /**
     * Method removeDataset1Item
     * 
     * 
     * 
     * @param index
     * @return Dataset1Item
     */
    public Dataset1Item removeDataset1Item(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (Dataset1Item) obj;
    } //-- Dataset1Item removeDataset1Item(int) 

    /**
     * Method setDataset1Item
     * 
     * 
     * 
     * @param index
     * @param vDataset1Item
     */
    public void setDataset1Item(int index, Dataset1Item vDataset1Item)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("setDataset1Item: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        _items.setElementAt(vDataset1Item, index);
    } //-- void setDataset1Item(int, Dataset1Item) 

    /**
     * Method setDataset1Item
     * 
     * 
     * 
     * @param dataset1ItemArray
     */
    public void setDataset1Item(Dataset1Item[] dataset1ItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < dataset1ItemArray.length; i++) {
            _items.addElement(dataset1ItemArray[i]);
        }
    } //-- void setDataset1Item(Dataset1Item) 

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
        return (Dataset1) Unmarshaller.unmarshal(Dataset1.class, reader);
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
