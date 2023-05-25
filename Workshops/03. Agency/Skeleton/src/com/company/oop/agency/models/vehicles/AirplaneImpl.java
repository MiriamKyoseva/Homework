package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;

import static com.company.oop.agency.utils.ValidationHelper.validateValueInRange;

public class AirplaneImpl extends VehicleImpl implements Airplane {

    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    private boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        setId(id);
        setType(VehicleType.AIR);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        setHasFreeFood(hasFreeFood);
    }

    public boolean hasFreeFood() {
        return hasFreeFood;
    }
    @Override
    public String getAsString() {
        String string = String.format("%nAirplane ----%n" +
                        "Passenger capacity: %s%n" +
                        "Price per kilometer: %.2f%n" +
                        "Vehicle type: %s%n" +
                        "Has free food: %s%n",
                getPassengerCapacity(),
                getPricePerKilometer(),
                getType(),
                hasFreeFood());
        return string;
    }
    @Override
    protected void setPassengerCapacity(int passengerCapacity) {
        validateValueInRange(passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                String.format("An airplane cannot have less than %d passengers or more than %d passengers.",
                        PASSENGER_MIN_VALUE,
                        PASSENGER_MAX_VALUE)
        );
        this.passengerCapacity = passengerCapacity;
    }
    private void setHasFreeFood(boolean hasFreeFood) {
        this.hasFreeFood = hasFreeFood;
    }

}