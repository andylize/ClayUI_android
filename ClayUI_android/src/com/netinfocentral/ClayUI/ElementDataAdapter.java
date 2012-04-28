package com.netinfocentral.ClayUI;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ElementDataAdapter {
 // define class variables
    private SQLiteDatabase db;
    private ElementDatabaseHelper dbHelper;
    private String[] columns = { ElementDatabaseHelper.COLUMN_ID,
	    ElementDatabaseHelper.COLUMN_APP_PART_ID,
	    ElementDatabaseHelper.COLUMN_ELEMENT_NAME,
	    ElementDatabaseHelper.COLUMN_ELEMENT_TYPE,
	    ElementDatabaseHelper.COLUMN_ELEMENT_LABEL,
	    ElementDatabaseHelper.COLUMN_VERSION};
    
    //default constructor
    public ElementDataAdapter(Context context) { 
	dbHelper = new ElementDatabaseHelper(context);
    }
    
    // method to open the database
    public void open() throws SQLException {
	db = dbHelper.getWritableDatabase();
    }
    
    // method to close the database
    public void close() {
	dbHelper.close();
    }
    
    // clear database
    public void clearDatabase() {
	try {
	    int result = db.delete(ElementDatabaseHelper.TABLE_NAME, null, null);
	}
	catch (SQLException e) {
	    Log.e(ElementDatabaseHelper.class.getName(), e.getMessage());
	}
	catch (Exception e) {
	    Log.e(ElementDatabaseHelper.class.getName(), e.getMessage());
	}
    }
    
    /** method to add a record to database
     **
     ** Returns the record id of the new record
     **/
    public Element createElement(int appPartID, String elementName, int elementType, String elementLabel, int version) {
	ContentValues values = new ContentValues();
	values.put(ElementDatabaseHelper.COLUMN_APP_PART_ID, appPartID);
	values.put(ElementDatabaseHelper.COLUMN_ELEMENT_NAME, elementName);
	values.put(ElementDatabaseHelper.COLUMN_ELEMENT_TYPE, elementType);
	values.put(ElementDatabaseHelper.COLUMN_ELEMENT_LABEL, elementLabel);
	values.put(ElementDatabaseHelper.COLUMN_VERSION, version);
	long insertID = db.insert(ElementDatabaseHelper.TABLE_NAME, null, values);
	
	// query the database to get inserted record and return to calling method
	Cursor cursor = db.query(ElementDatabaseHelper.TABLE_NAME, columns, ElementDatabaseHelper.COLUMN_ID + " = " + insertID, null, null, null, null);
	cursor.moveToFirst();
	
	return cursorToElement(cursor);
	
    }
    /** TODO: Add update element table if new version is available **/
    
    // method to return a list array of AppPart objects
    public List<Element> getAllElements() {
	List<Element> elements = new ArrayList<Element>();
	Cursor cursor = db.query(ElementDatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
	
	cursor.moveToFirst();
	while (!cursor.isAfterLast()) {
	    Element element = cursorToElement(cursor);
	    elements.add(element);
	    cursor.moveToNext();
	}
	//close cursor
	cursor.close();
	return elements;
    }
    
    // method to convert a record to a AppPart object
    private Element cursorToElement(Cursor cursor)
    {
	Element element = new Element(cursor.getLong(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getInt(5));
	return element;
    }
}
