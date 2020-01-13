package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

import java.util.Objects;

@PatternInstance(
        patternName = "Template Method",
        participants = {"AbstractClass"}
)
public abstract class AbstractCoordinate implements Coordinate {

    @Override
    public double getCartesianDistance(Coordinate other) {
        assertIsNonNullArgument(other);

        CartesianCoordinate me = this.asCartesianCoordinate();
        CartesianCoordinate o = other.asCartesianCoordinate();

        double x2 = (o.getX() - me.getX()) * (o.getX() - me.getX());
        double y2 = (o.getY() - me.getY()) * (o.getY() - me.getY());
        double z2 = (o.getZ() - me.getZ()) * (o.getZ() - me.getZ());
        double dist = Math.sqrt(x2 + y2 + z2);

        assert Double.isFinite(dist);
        return dist;
    }

    @Override
    public double getCentralAngle(Coordinate other) {
        assertIsNonNullArgument(other);

        SphericCoordinate me = this.asSphericCoordinate();
        SphericCoordinate o = other.asSphericCoordinate();

        double angle = Math.acos(Math.sin(me.getTheta()) * Math.sin(o.getTheta()) +
                Math.cos(me.getTheta()) * Math.cos(o.getTheta()) * Math.cos(me.getPhi() - o.getPhi()));

        assert Double.isFinite(angle);
        return angle;
    }

    @Override
    public boolean isEqual(Coordinate other) {
        assertIsNonNullArgument(other);

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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this;
    }

    public String asString() {
        CartesianCoordinate me = this.asCartesianCoordinate();
        return "(" + me.getX() + ", " + me.getY() + ", " + me.getZ() + ")";
    }

    @Override
    public String toString() {
        return asString();
    }

    protected void assertIsNonNullArgument(Object arg) throws IllegalArgumentException {
        if (arg == null)
            throw new IllegalArgumentException("Argument should not be null.");
    }

    protected abstract void assertClassInvariant();
}
