package com.netinfocentral.ClayUI;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AppBaseMain {
    
    // define instance variables
    private String applicationName = "";
    
    // define data sources
    private AppPartDataAdapter appPartDataAdapter;
    
    // default constructor
    public AppBaseMain(String applicationName) {
    	this.applicationName = applicationName;
    	
    	// if this is the first run, build tables
    	if (this.isFirstRun()) {
    		
    	}
    }
    
    // properties
    public String getApplicationName() {
    	return this.applicationName;
    }
    
    public String getDataTableName(String appPartName) {
    	return "TableName";
    }
    
    private boolean isFirstRun() { // checks if this is the first time that the application is run by looking for existence of database file
    	//TODO: check for ClayUI.db
    	return true;
    }    
}