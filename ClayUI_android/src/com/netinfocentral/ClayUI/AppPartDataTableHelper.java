package com.netinfocentral.ClayUI;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppPartDataTableHelper extends SQLiteOpenHelper implements
		AppPartDataTableHelperInterface {
	
	// define class variables
	private static final int DATABASE_VERSION = 1;
  	private static final String DATABASE_NAME = "ClayUI.db";
  	private String tableName;
	
	// define default constructor
	AppPartDataTableHelper(Context context, String tableName) {
  	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  	    this.tableName = tableName;
  	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCreateStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
