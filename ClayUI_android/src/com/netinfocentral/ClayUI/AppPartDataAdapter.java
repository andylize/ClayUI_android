package com.netinfocentral.ClayUI;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class AppPartDataAdapter {
    
    // define class variables
    private SQLiteDatabase db;
    private AppPartDatabaseHelper dbHelper;
    private String[] columns = { AppPartDatabaseHelper.COLUMN_ID,
	    AppPartDatabaseHelper.COLUMN_APP_PART_NAME,
	    AppPartDatabaseHelper.COLUMN_VERSION};
    
    //default constructor
    public AppPartDataAdapter(Context context) { 
    	dbHelper = new AppPartDatabaseHelper(context);
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
		    int result = db.delete(AppPartDatabaseHelper.TABLE_NAME, null, null);
		}
		catch (SQLException e) {
		    Log.e(AppPartDatabaseHelper.class.getName(), e.getMessage());
		}
		catch (Exception e) {
		    Log.e(AppPartDatabaseHelper.class.getName(), e.getMessage());
		}
    }
    
    /** method to add a record to database
     **
     ** Returns the record id of the new record
     **/
    public AppPart createAppPart(String appPartName, int version) {
		ContentValues values = new ContentValues();
		values.put(AppPartDatabaseHelper.COLUMN_APP_PART_NAME, appPartName);
		values.put(AppPartDatabaseHelper.COLUMN_VERSION, version);
		long insertID = db.insert(AppPartDatabaseHelper.TABLE_NAME, null, values);
		
		// query the database to get inserted record and return to calling method
		Cursor cursor = db.query(AppPartDatabaseHelper.TABLE_NAME, columns, AppPartDatabaseHelper.COLUMN_ID + " = " + insertID, null, null, null, null);
		cursor.moveToFirst();
		
		return cursorToAppPart(cursor);
	
    }
    /** TODO: Add update app part table if new version is available **/
    
    // method to return a list array of AppPart objects
    public List<AppPart> getAllAppParts() {
		List<AppPart> appParts = new ArrayList<AppPart>();
		Cursor cursor = db.query(AppPartDatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
		    AppPart appPart = cursorToAppPart(cursor);
		    appParts.add(appPart);
		    cursor.moveToNext();
		}
		//close cursor
		cursor.close();
		return appParts;
    }
    
    // method to convert a record to a AppPart object
    private AppPart cursorToAppPart(Cursor cursor)	{
		AppPart appPart = new AppPart(cursor.getLong(0), cursor.getString(1), cursor.getInt(2));
		return appPart;
    }
	
}
