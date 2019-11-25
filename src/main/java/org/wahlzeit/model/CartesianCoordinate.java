package org.wahlzeit.model;

import java.io.Serializable;
import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate {

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
    public SphericCoordinate asSphericCoordinate() {
        double radius = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
        double phi = Math.atan2(this.y, this.x);
        double theta = radius == 0 ? 0 : Math.acos(this.z / radius);
        return new SphericCoordinate(phi, theta, radius);
    }
}
