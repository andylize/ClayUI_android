package com.netinfocentral.ClayUI;

public class ElementOption {
	
	// define instance variables
    private long recordID;
    private int elementID;
    private String value;
    private String description;
    private int version;
    
    // main constructor
    public ElementOption(long recordID, int elementID, String value, String description, int version) {
		this.recordID = recordID;
		this.elementID = elementID;
		this.value = value;
		this.description = description;
		this.version = version;
    }
    
    /**
	 * @return the recordID
	 */
	public long getRecordID() {
		return recordID;
	}
	
	/**
	 * @return the elementID
	 */
	public int getElementID() {
		return elementID;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	@Override
    public String toString() {
		return "AppPart [recordID="+ this.recordID + ", elementID=" + this.elementID + ", value=" + this.value + ", description=" + this.description + ", version=" + this.version + "]";
    }
	
}
