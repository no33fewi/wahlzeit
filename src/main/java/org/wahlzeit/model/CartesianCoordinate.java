package org.wahlzeit.model;

import java.io.Serializable;
import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate {

    private double x, y, z;

    public CartesianCoordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;

        assertClassInvariant();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        assertClassInvariant();
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        assertClassInvariant();
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
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
        assert Double.isFinite(this.x);
        assert Double.isFinite(this.y);
        assert Double.isFinite(this.z);
    }
}
