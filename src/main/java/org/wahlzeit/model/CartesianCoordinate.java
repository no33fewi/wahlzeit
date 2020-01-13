package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

import java.util.HashMap;

@PatternInstance(
        patternName = "Template Method",
        participants = {"SubClass"}
)
@PatternInstance(
        patternName = "Flyweight",
        participants = {"Flyweight"}
)
public class CartesianCoordinate extends AbstractCoordinate {
    private static final HashMap<Integer,CartesianCoordinate> instances = new HashMap<>();

    private final double x, y, z;

    private CartesianCoordinate(double x, double y, double z) {
        if (!Double.isFinite(x))
            throw new IllegalArgumentException("X must be a finite value. The value " + x + " is not valid");
        if (!Double.isFinite(y))
            throw new IllegalArgumentException("Y must be a finite value. The value " + y + " is not valid");
        if (!Double.isFinite(z))
            throw new IllegalArgumentException("Z must be a finite value. The value " + z + " is not valid");

        this.x = x;
        this.y = y;
        this.z = z;

        assertClassInvariant();
    }

    public static CartesianCoordinate getCartesianCoordinate(double x, double y, double z) {
        CartesianCoordinate tmp = new CartesianCoordinate(x, y, z);
        int hash = tmp.hashCode();
        CartesianCoordinate result = instances.get(hash);
        if(result == null){
            synchronized (instances){
                result = instances.get(hash);
                if(result==null){
                    result = tmp;
                    instances.put(hash,result);
                }
            }
        }
        return result;
    }

    public double getX() {
        return x;
    }

    public CartesianCoordinate withX(double x) {
        if (!Double.isFinite(x))
            throw new IllegalArgumentException("X must be a finite value. The value " + x + " is not valid");
        return getCartesianCoordinate(x, this.getY(), this.getZ());
    }

    public double getY() {
        return y;
    }

    public CartesianCoordinate setY(double y) {
        if (!Double.isFinite(y))
            throw new IllegalArgumentException("Y must be a finite value. The value " + y + " is not valid");
        return getCartesianCoordinate(this.getX(), y, this.getZ());
    }

    public double getZ() {
        return z;
    }

    public CartesianCoordinate setZ(double z) {
        if (!Double.isFinite(z))
            throw new IllegalArgumentException("Z must be a finite value. The value " + z + " is not valid");
        return getCartesianCoordinate(this.getX(), this.getY(), z);
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
        return SphericCoordinate.getSphericCoordinate(phi, theta, radius);
    }

    @Override
    protected void assertClassInvariant() {
        if (!Double.isFinite(this.x) || !Double.isFinite(this.y) || !Double.isFinite(this.z))
            throw new IllegalStateException("Class invariant violation");
    }
}
