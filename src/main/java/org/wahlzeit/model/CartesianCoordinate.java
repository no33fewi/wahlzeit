package org.wahlzeit.model;

import java.io.Serializable;
import java.util.Objects;

public class CartesianCoordinate implements Coordinate {

    private double x, y, z;

    public CartesianCoordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public double getCartesianDistance(Coordinate other) {
        return getDistance(other.asCartesianCoordinate());
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        double radius = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
        double phi = Math.atan2(this.y, this.x);
        double theta = radius == 0 ? 0 : Math.acos(this.z / radius);
        return new SphericCoordinate(phi, theta, radius);
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        return this.asSphericCoordinate().getCentralAngle(coordinate);
    }

    @Override
    public boolean isEqual(Coordinate other) {
        if (other == null) return false;
        CartesianCoordinate otherCartesian = other.asCartesianCoordinate();
        return otherCartesian.x == this.x && otherCartesian.y == this.y && otherCartesian.z == this.z;
    }

    public double getDistance(CartesianCoordinate other) {
        if(other==null)
            throw new NullPointerException();
        double x2 = (other.x - this.x) * (other.x - this.x);
        double y2 = (other.y - this.y) * (other.y - this.y);
        double z2 = (other.z - this.z) * (other.z - this.z);
        return Math.sqrt(x2 + y2 + z2);
    }

    public String asString() { return "(" + x + ", " + y + ", " + z + ")"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
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
