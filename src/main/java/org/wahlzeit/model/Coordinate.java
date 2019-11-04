package org.wahlzeit.model;

import java.io.Serializable;
import java.util.Objects;

public class Coordinate implements Serializable {

    private double x, y, z;

    public Coordinate(){

    }

    public Coordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getDistance(Coordinate other) {
        double x2 = (other.x - this.x) * (other.x - this.x);
        double y2 = (other.y - this.y) * (other.y - this.y);
        double z2 = (other.z - this.z) * (other.z - this.z);
        return Math.sqrt(x2 + y2 + z2);
    }

    public boolean isEqual(Coordinate other){
        return other.x == this.x && other.y == this.y && other.z == this.z;
    }

    public String asString() { return "(" + x + ", " + y + ", " + z + ")"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return isEqual(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return asString();
    }
}
