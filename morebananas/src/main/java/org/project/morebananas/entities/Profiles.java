package org.project.morebananas.entities;

public enum Profiles {
	USER("USER"),
	DBA("DBA"),
	ADMIN("ADMIN");
	
	String Type;

    private Profiles(String Type) {
        this.Type = Type;
    }

    public String getType() {
        return Type;
    }

}