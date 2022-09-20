package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    private int id;
    private static int nextId = 1;
    private String value;

    public JobField() {
        id = nextId;
        nextId++;
    }

    // TODO: Add a custom toString() method that returns the data stored in 'value'.
    // Custom toString, equals, and hashCode methods:
    @Override
    public String toString() {
        return value;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    // TODO: Add custom equals and hashCode methods. Consider two PositionType objects "equal" when
    //  their id fields match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField that = (JobField) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

//getters and setters
// TODO: Use the "Generate" tool to add a getter and setter for the 'value' field but
//  ONLY a getter for the 'id' field.
    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
