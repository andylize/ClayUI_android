package com.netinfocentral.ClayUI;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ElementOptionDataAdapter {
	// define class variables
    private SQLiteDatabase db;
    private ElementOptionDatabaseHelper dbHelper;
    private String[] columns = { ElementOptionDatabaseHelper.COLUMN_ID,
		ElementOptionDatabaseHelper.COLUMN_ELEMENT_ID,
		ElementOptionDatabaseHelper.COLUMN_VALUE,
		ElementOptionDatabaseHelper.COLUMN_DESCRIPTION,
		ElementOptionDatabaseHelper.COLUMN_VERSION};
    
    //default constructor
    public ElementOptionDataAdapter(Context context) { 
    	dbHelper = new ElementOptionDatabaseHelper(context);
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
		    int result = db.delete(ElementOptionDatabaseHelper.TABLE_NAME, null, null);
		}
		catch (SQLException e) {
		    Log.e(ElementOptionDatabaseHelper.class.getName(), e.getMessage());
		}
		catch (Exception e) {
		    Log.e(ElementOptionDatabaseHelper.class.getName(), e.getMessage());
		}
    }
    
    /** method to add a record to database
     **
     ** Returns the record id of the new record
     **/
    public ElementOption createElementOption(int appPartID, int elementID, String value, String description, int version) {
		ContentValues values = new ContentValues();
		values.put(ElementOptionDatabaseHelper.COLUMN_ELEMENT_ID, elementID);
		values.put(ElementOptionDatabaseHelper.COLUMN_VALUE, value);
		values.put(ElementOptionDatabaseHelper.COLUMN_VERSION, version);
		long insertID = db.insert(ElementOptionDatabaseHelper.TABLE_NAME, null, values);
		
		// query the database to get inserted record and return to calling method
		Cursor cursor = db.query(ElementOptionDatabaseHelper.TABLE_NAME, columns, ElementOptionDatabaseHelper.COLUMN_ID + " = " + insertID, null, null, null, null);
		cursor.moveToFirst();
		
		return cursorToElementOption(cursor);
	
    }
    /** TODO: Add update element table if new version is available **/
    
    // method to return a list array of AppPart objects
    public List<ElementOption> getAllElementOptions() {
		List<ElementOption> elementOptions = new ArrayList<ElementOption>();
		Cursor cursor = db.query(ElementOptionDatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			ElementOption elementOption = cursorToElementOption(cursor);
			elementOptions.add(elementOption);
		    cursor.moveToNext();
		}
		//close cursor
		cursor.close();
		return elementOptions;
    }
    
    // method to convert a record to a AppPart object
    private ElementOption cursorToElementOption(Cursor cursor)
    {
    	ElementOption elementOption = new ElementOption(cursor.getLong(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4));
    	return elementOption;
    }
}
