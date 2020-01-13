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
public class SphericCoordinate extends AbstractCoordinate {
    private static final HashMap<Integer,SphericCoordinate> instances = new HashMap<>();

    private final double phi, theta, radius;

    private SphericCoordinate(double phi, double theta, double radius) {
        if(!Double.isFinite(phi))
            throw new IllegalArgumentException("Phi must be a finite value. The value " + phi + " is not valid");
        if(!Double.isFinite(theta))
            throw new IllegalArgumentException("Theta must be a finite value. The value " + theta + " is not valid");
        if(!Double.isFinite(radius))
            throw new IllegalArgumentException("Radius must be a finite value. The value " + radius + " is not valid");

        this.phi = phi;
        this.theta = theta;
        this.radius = radius;

        assertClassInvariant();
    }

    public static SphericCoordinate getSphericCoordinate(double phi, double theta, double radius){
        SphericCoordinate tmp = new SphericCoordinate(phi,theta,radius);
        int hash = tmp.hashCode();
        SphericCoordinate result = instances.get(hash);
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

    public double getPhi() {
        return phi;
    }

    public SphericCoordinate withPhi(double phi) {
        if(!Double.isFinite(phi))
            throw new IllegalArgumentException("Phi must be a finite value. The value " + phi + " is not valid");
        return getSphericCoordinate(phi,this.getTheta(),this.getRadius());
    }

    public double getTheta() {
        return theta;
    }

    public SphericCoordinate withTheta(double theta) {
        if(!Double.isFinite(theta))
            throw new IllegalArgumentException("Theta must be a finite value. The value " + theta + " is not valid");
        return getSphericCoordinate(this.getPhi(),theta,this.getRadius());
    }

    public double getRadius() {
        return radius;
    }

    public SphericCoordinate withRadius(double radius) {
        if(!Double.isFinite(radius))
            throw new IllegalArgumentException("Radius must be a finite value. The value " + radius + " is not valid");
        return getSphericCoordinate(this.getPhi(),this.getTheta(),radius);
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = this.radius * Math.sin(this.theta) * Math.cos(this.phi);
        double y = this.radius * Math.sin(this.theta) * Math.sin(this.phi);
        double z = this.radius * Math.cos(this.theta);
        return CartesianCoordinate.getCartesianCoordinate(x,y,z);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    protected void assertClassInvariant() {
        if(!Double.isFinite(this.phi)||!Double.isFinite(this.theta)||!Double.isFinite(this.radius)||this.radius < 0)
            throw new IllegalStateException("Class invariant violation");
    }
}
