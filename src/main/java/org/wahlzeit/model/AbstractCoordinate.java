package org.wahlzeit.model;

import java.util.Objects;

public abstract class AbstractCoordinate implements Coordinate {

    @Override
    public double getCartesianDistance(Coordinate other) {
        if (other == null)
            throw new NullPointerException();
        CartesianCoordinate me = this.asCartesianCoordinate();
        CartesianCoordinate o = other.asCartesianCoordinate();

        double x2 = (o.getX() - me.getX()) * (o.getX() - me.getX());
        double y2 = (o.getY() - me.getY()) * (o.getY() - me.getY());
        double z2 = (o.getZ() - me.getZ()) * (o.getZ() - me.getZ());
        return Math.sqrt(x2 + y2 + z2);
    }

    @Override
    public double getCentralAngle(Coordinate other) {
        if (other == null)
            throw new NullPointerException();
        SphericCoordinate me = this.asSphericCoordinate();
        SphericCoordinate o = other.asSphericCoordinate();

        return Math.acos(Math.sin(me.getTheta()) * Math.sin(o.getTheta()) +
                Math.cos(me.getTheta()) * Math.cos(o.getTheta()) * Math.cos(me.getPhi() - o.getPhi()));
    }

    @Override
    public boolean isEqual(Coordinate other) {
        if (other == null) return false;
        CartesianCoordinate me = this.asCartesianCoordinate();
        CartesianCoordinate o = other.asCartesianCoordinate();
        return o.getX() == me.getX() && o.getY() == me.getY() && o.getZ() == me.getZ();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return isEqual(that);
    }

    @Override
    public int hashCode() {
        CartesianCoordinate me = this.asCartesianCoordinate();
        return Objects.hash(me.getX(), me.getY(), me.getZ());
    }

    public String asString() {
        CartesianCoordinate me = this.asCartesianCoordinate();
        return "(" + me.getX() + ", " + me.getY() + ", " + me.getZ() + ")";
    }

    @Override
    public String toString() {
        return asString();
    }
}
