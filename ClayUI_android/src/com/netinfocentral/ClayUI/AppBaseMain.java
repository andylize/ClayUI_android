package com.netinfocentral.ClayUI;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AppBaseMain implements AppBaseMainInterface {
    
    // define instance variables
    private String applicationName = "";
    
    // default constructor
    public AppBaseMain(String applicationName) {
	this.applicationName = applicationName;
    }
    
    // properties
    public String getApplicationName() {
	return this.applicationName;
    }
    
}
;