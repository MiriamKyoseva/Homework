package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;

import static com.company.oop.agency.utils.ValidationHelper.validateValueInRange;

public abstract class VehicleBase implements Vehicle {
    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    protected int passengerCapacity = 0;
    public VehicleType type;
    protected double pricePerKilometer = 0;
    protected int id = 0;

    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public VehicleType getType() {
        return type;
    }
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }
    public int getId() {
        return id;
    }
    protected void setPassengerCapacity(int passengerCapacity) {
        validateValueInRange(passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                String.format("A vehicle cannot have less than %d passengers or more than %d passengers.",
                    PASSENGER_MIN_VALUE,
                    PASSENGER_MAX_VALUE)
        );
        this.passengerCapacity = passengerCapacity;
    }
    protected void setType(VehicleType type) {
        this.type = type;
    }
    protected void setPricePerKilometer(double pricePerKilometer) {
        validateValueInRange(pricePerKilometer,
                PRICE_MIN_VALUE,
                PRICE_MAX_VALUE,
                String.format("A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!",
                        PRICE_MIN_VALUE,
                        PRICE_MAX_VALUE));
        this.pricePerKilometer = pricePerKilometer;
    }
    public void setId(int id) {
        this.id = id;
    }

}
