package com.company.oop.agency.models.vehicles;


import com.company.oop.agency.models.vehicles.contracts.Bus;

import static com.company.oop.agency.utils.ValidationHelper.validateValueInRange;

public class BusImpl extends VehicleBase implements Bus {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        setId(id);
        setType(VehicleType.LAND);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
    }
    @Override
    public String getAsString() {
        String string = String.format("%nBus ----%n" +
                        "Passenger capacity: %s%n" +
                        "Price per kilometer: %.2f%n" +
                        "Vehicle type: %s%n",
                getPassengerCapacity(),
                getPricePerKilometer(),
                getType());
        return string;
    }
    @Override
    public void setPassengerCapacity(int passengerCapacity) {
        validateValueInRange(passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                String.format("A bus cannot have less than %d passengers or more than %d passengers.",
                        PASSENGER_MIN_VALUE,
                        PASSENGER_MAX_VALUE)
        );
        this.passengerCapacity = passengerCapacity;
    }

}