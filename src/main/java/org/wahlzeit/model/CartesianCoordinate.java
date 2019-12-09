package org.wahlzeit.model;

import java.io.Serializable;
import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate {

    private double x, y, z;

    public CartesianCoordinate(double x, double y, double z){
        if(!Double.isFinite(x))
            throw new IllegalArgumentException("X must be a finite value. The value " + x + " is not valid");
        if(!Double.isFinite(y))
            throw new IllegalArgumentException("Y must be a finite value. The value " + y + " is not valid");
        if(!Double.isFinite(z))
            throw new IllegalArgumentException("Z must be a finite value. The value " + z + " is not valid");

        this.x = x;
        this.y = y;
        this.z = z;

        assertClassInvariant();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        if(!Double.isFinite(x))
            throw new IllegalArgumentException("X must be a finite value. The value " + x + " is not valid");
        this.x = x;
        assertClassInvariant();
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if(!Double.isFinite(y))
            throw new IllegalArgumentException("Y must be a finite value. The value " + y + " is not valid");
        this.y = y;
        assertClassInvariant();
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        if(!Double.isFinite(z))
            throw new IllegalArgumentException("Z must be a finite value. The value " + z + " is not valid");
        this.z = z;
        assertClassInvariant();
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

    @Override
    protected void assertClassInvariant() {
        if(!Double.isFinite(this.x)||!Double.isFinite(this.y)||!Double.isFinite(this.z))
            throw new IllegalStateException("Class invariant violation");
    }
}
