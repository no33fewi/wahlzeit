package org.wahlzeit.model;

public interface Coordinate {

    public CartesianCoordinate asCartesianCoordinate();

    public double getCartesianDistance(Coordinate other);

    public SphericCoordinate asSphericCoordinate();

    double getCentralAngle(Coordinate other);

    boolean isEqual(Coordinate coordinate);
}
