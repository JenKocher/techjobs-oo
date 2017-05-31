package org.launchcode.models;

/**
 * Created by LaunchCode
 */
public class JobField {

    private String value;
    private int id;
    private static int nextId = 1;

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String aValue) {
        this();
        value = aValue;
    }

    public boolean contains(String value) {
        return this.value.toLowerCase().contains(value.toLowerCase());
    }

    public void setValue(String aValue) {value = aValue;}
    public String getValue() {
        return value;
    }

    private void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    //Jen added the @Override and moved the method to be nearer the other special method
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return id == jobField.getId();
    }

    @Override
    public int hashCode() {
        return id;
    }

}
