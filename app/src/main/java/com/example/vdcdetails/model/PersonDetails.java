package com.example.vdcdetails.model;

public class PersonDetails {

    private String name;
    private String fathername;
    private String mothername;
    private int imageId;

    public PersonDetails(String name, String fathername, String mothername, int imageId){
        this.name = name;
        this.fathername = fathername;
        this.mothername = mothername;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }



}
