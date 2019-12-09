package org.wahlzeit.model;

import java.io.Serializable;

public class Location implements Serializable {

    protected String name;

    protected Coordinate coordinate;

    public Location(){

    }

    public Location(String name, Coordinate coordinate){
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Name should not be null or empty");
        if(coordinate == null)
            throw new IllegalArgumentException("Coordinate should not be null");
        this.name = name;
        this.coordinate = coordinate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Name should not be null or empty");
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        if(coordinate == null)
            throw new IllegalArgumentException("Coordinate should not be null");
        this.coordinate = coordinate;
    }
}
