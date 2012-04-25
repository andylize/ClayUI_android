package com.netinfocentral.ClayUI;

public class AppPart {
    
    // define instance variables
    private long recordID;
    private String appPartName;
    private int version;
    
    //default constructor
    public AppPart() {
	this(1, "", 1);
    }
    
    // main constructor
    public AppPart(long recordID, String appPartName, int version) {
	this.recordID = recordID;
	this.appPartName = appPartName;
	this.version = version;
    }

    /**
     * @return the recordID
     */
    public long getRecordID() {
        return recordID;
    }

    /**
     * @return the appPartName
     */
    public String getAppPartName() {
        return appPartName;
    }

    /**
     * @return the version
     */
    public int getVersion() {
        return version;
    }
    
    @Override
    public String toString() {
	return "AppPart [recordID="+ this.recordID + ", appPartName=" + this.appPartName + ", version="+ this.version + "]";
    }
	
}
