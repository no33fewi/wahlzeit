package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MotorcycleManager {
    private static MotorcycleManager instance;
    private HashMap<String, MotorcycleType> motorcycleTypes = new HashMap<>();
    private List<Motorcycle> motorcycleInstances = new ArrayList<>();


    public static MotorcycleManager getInstance() {
        if (instance == null) {
            instance = new MotorcycleManager();
        }
        return instance;
    }


    public MotorcycleType getMotorcycleType(String type) {
        if (type == null)
            throw new IllegalArgumentException("The types name must not be null");
        if (motorcycleTypes.containsKey(type))
            return motorcycleTypes.get(type);
        MotorcycleType motorcycleType = new MotorcycleType(type);
        motorcycleTypes.put(type, motorcycleType);
        return motorcycleType;
    }

    public Motorcycle createMotorcycle(String type) {
        MotorcycleType motorcycleType = getMotorcycleType(type);
        Motorcycle motorcycle = motorcycleType.createInstance();
        motorcycleInstances.add(motorcycle);
        return motorcycle;
    }

    public Motorcycle createMotorcycle(String type, String brand, String model, double weight, double displacement, double power, Date registrationDate, int kilometer) {
        MotorcycleType motorcycleType = getMotorcycleType(type);
        Motorcycle motorcycle = motorcycleType.createInstance(brand, model, weight, displacement, power, registrationDate, kilometer);
        motorcycleInstances.add(motorcycle);
        return motorcycle;
    }

}
