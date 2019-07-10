package com.panlijun;

public class Parent {
    private String id = "0001";

    protected String getId(){
        return id;
    }

    protected void setId(String id){
        this.id = id;
    }

    protected String getParentHashcode(){
        return String.valueOf(this.hashCode());
    }
}
