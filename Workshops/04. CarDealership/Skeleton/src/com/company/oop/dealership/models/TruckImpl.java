package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Truck;
import com.company.oop.dealership.models.enums.VehicleType;

import static com.company.oop.dealership.utils.ValidationHelpers.validateIntRange;
import static java.lang.String.format;

public class TruckImpl extends VehicleBase implements Truck {
    public static final int WEIGHT_CAP_MIN = 1;
    public static final int WEIGHT_CAP_MAX = 100;
    public static final int TRUCK_WHEEL_COUNT = 8;
    private static final String WEIGHT_CAP_ERR = format(
            "Weight capacity must be between %d and %d!",
            WEIGHT_CAP_MIN,
            WEIGHT_CAP_MAX);

    private int weightCapacity;

    public TruckImpl(String make, String model, double price, int weightCapacity) {
        super(make, model, price);
        setType(VehicleType.TRUCK);
        setWheels(TRUCK_WHEEL_COUNT);
        setWeightCapacity(weightCapacity);
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s" +
                        "Weight Capacity: %s" +
                        "t%n" +
                        "%s",
                super.toString(),
                getWeightCapacity(),
                commentsToString());
    }

    private void setWeightCapacity(int weightCapacity) {
        validateIntRange(weightCapacity, WEIGHT_CAP_MIN, WEIGHT_CAP_MAX, WEIGHT_CAP_ERR);
        this.weightCapacity = weightCapacity;
    }

}
