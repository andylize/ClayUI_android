package com.netinfocentral.ClayUI;

public class Element {
 // define instance variables
    private long recordID;
    private int appPartID;
    private String elementName;
    private int elementType;
    private String elementLabel;
    private int version;
           
    // main constructor
    public Element(long recordID, int appPartID, String elementName, int elementType, String elementLabel, int version) {
	this.recordID = recordID;
	this.appPartID = appPartID;
	this.elementName = elementName;
	this.elementType = elementType;
	this.elementLabel = elementLabel;
	this.version = version;
    }
    
    /**
     * @return the recordID
     */
    public long getRecordID() {
        return recordID;
    }
    
    /**
     * @return the appPartID
     */
    public int getAppPartID() {
        return appPartID;
    }
    
    /**
     * @return the elementName
     */
    public String getElementName() {
        return elementName;
    }

    /**
     * @return the elementType
     */
    public int getElementType() {
        return elementType;
    }

    /**
     * @return the elementLabel
     */
    public String getElementLabel() {
        return elementLabel;
    }

    /**
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    @Override
    public String toString() {
	return "AppPart [recordID="+ this.recordID + ", appPartID=" + this.appPartID + ", elementName=" + this.elementName +
		 ", elementType=" + this.elementType + ", elementLabel=" + this.elementLabel + ", version="+ this.version + "]";
    }
}
