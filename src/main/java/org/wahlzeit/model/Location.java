package org.wahlzeit.model;

import java.io.Serializable;

public class Location implements Serializable {

    protected String name;

    protected Coordinate coordinate;

    public Location(){

    }

    public Location(String name, Coordinate coordinate){
        this.name = name;
        this.coordinate = coordinate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
