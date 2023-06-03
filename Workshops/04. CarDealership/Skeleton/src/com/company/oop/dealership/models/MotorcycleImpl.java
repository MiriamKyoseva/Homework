package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Motorcycle;
import com.company.oop.dealership.models.enums.VehicleType;

import static com.company.oop.dealership.utils.ValidationHelpers.validateIntRange;
import static java.lang.String.format;

public class MotorcycleImpl extends VehicleBase implements Motorcycle {
    public static final int CATEGORY_LEN_MIN = 3;
    public static final int CATEGORY_LEN_MAX = 10;
    public static final int MOTORCYCLE_WHEEL_COUNT = 2;
    private static final String CATEGORY_LEN_ERR = format(
            "Category must be between %d and %d characters long!",
            CATEGORY_LEN_MIN,
            CATEGORY_LEN_MAX);

    private String category;

    public MotorcycleImpl(String make, String model, double price, String category) {
        super(make, model, price);
        setType(VehicleType.MOTORCYCLE);
        setWheels(MOTORCYCLE_WHEEL_COUNT);
        setCategory(category);
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("%s" +
                        "Category: %s%n" +
                        "%s%n",
                super.toString(),
                getCategory(),
                commentsToString());
    }

    private void setCategory(String category) {
        validateIntRange(category.length(), CATEGORY_LEN_MIN, CATEGORY_LEN_MAX, CATEGORY_LEN_ERR);
        this.category = category;
    }
}
