package org.wahlzeit.model;

//public enum MotorcycleType {
//    Chopper,
//    NakedBike,
//    SuperSportsBike,
//    DirtBike,
//    Enduro,
//    SuperMoto
//}


import org.wahlzeit.services.DataObject;

import java.util.*;

public class MotorcycleType extends DataObject {

    protected MotorcycleType superType = null;
    protected Set<MotorcycleType> subTypes = new HashSet<>();

    protected String name;

    public MotorcycleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public MotorcycleType getSuperType() {
        return superType;
    }

    protected void setSuperType(MotorcycleType superType) {
        this.superType = superType;
    }

    public Iterator<MotorcycleType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    public void addSubType(MotorcycleType subType) {
        if(subType == null)
            throw new IllegalArgumentException("tried to set null sub-type");
        if(isSubtypeOf(subType))
            throw new IllegalArgumentException("The type is already a supertype. This would result in a circular type hierachy");
        subType.setSuperType(this);
        subTypes.add(subType);
    }

    public boolean isSubtype(){
        return superType != null;
    }

    public boolean isSubtypeOf(MotorcycleType type){
        if(type == null)
            throw new IllegalArgumentException("asked about null object");
        if(superType == null)
            return false;
        if(superType.equals(type))
            return true;
        return superType.isSubtypeOf(type);
    }

    public Motorcycle createInstance() {
        return new Motorcycle(this);
    }

    public Motorcycle createInstance(String brand, String model, double weight, double displacement, double power, Date registrationDate, int kilometer) {
        return new Motorcycle(this, brand, model, weight, displacement, power, registrationDate, kilometer);
    }

    public boolean hasInstance(Motorcycle motorcycle) {
        if(motorcycle == null)
            throw new IllegalArgumentException("asked about null object");
        if (motorcycle.getType() == this) {
            return true;
        }
        for (MotorcycleType type : subTypes) {
            if (type.hasInstance(motorcycle)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MotorcycleType type = (MotorcycleType) o;
        return Objects.equals(name, type.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
