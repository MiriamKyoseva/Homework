package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.models.vehicles.contracts.Train;

public class TrainImpl extends VehicleImpl implements Train {

    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    private int carts = 0;

    @Override
    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE)
            throw new IllegalArgumentException(
                    String.format("A train cannot have less than %d passengers or more than %d passengers.",
                    PASSENGER_MIN_VALUE,
                    PASSENGER_MAX_VALUE)
            );
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public int getCarts() {
        return carts;
    }

    public void setCarts(int carts) {
        if (carts <= CARTS_MIN_VALUE || carts >= CARTS_MAX_VALUE)
            throw new IllegalArgumentException(
                String.format("A train cannot have less than %d cart or more than %d carts.",
                        CARTS_MIN_VALUE,
                        CARTS_MAX_VALUE));
        this.carts = carts;
    }

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        setId(id);
        setType(VehicleType.LAND);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        setCarts(carts);
    }

    @Override
    public String getAsString() {
        String string = String.format("%nTrain ----%n" +
                        "Passenger capacity: %s%n" +
                        "Price per kilometer: %.2f%n" +
                        "Vehicle type: %s%n" +
                        "Carts amount: %s%n",
                        getPassengerCapacity(),
                        getPricePerKilometer(),
                        getType(),
                        getCarts());
        return string;
    }

}