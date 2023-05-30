package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.models.enums.VehicleType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.company.oop.dealership.utils.ValidationHelpers.validateDecimalRange;
import static com.company.oop.dealership.utils.ValidationHelpers.validateIntRange;
import static java.lang.String.format;

public abstract class VehicleBase implements Vehicle {
    private static final String NO_COMMENTS_HEADER = String.format("--NO COMMENTS--%n");
    private static final String COMMENTS_HEADER = String.format("--COMMENTS--%n");
    public static final int MAKE_NAME_LEN_MIN = 2;
    public static final int MAKE_NAME_LEN_MAX = 15;
    private static final String MAKE_NAME_LEN_ERR = format(
            "Make must be between %s and %s characters long!",
            MAKE_NAME_LEN_MIN,
            MAKE_NAME_LEN_MAX);
    public static final int MODEL_NAME_LEN_MIN = 1;
    public static final int MODEL_NAME_LEN_MAX = 15;
    private static final String MODEL_NAME_LEN_ERR = format(
            "Model must be between %s and %s characters long!",
            MODEL_NAME_LEN_MIN,
            MODEL_NAME_LEN_MAX);
    public static final double PRICE_VAL_MIN = 0;
    public static final double PRICE_VAL_MAX = 1000000;
    private static final String PRICE_VAL_ERR = format(
            "Price must be between %.1f and %.1f!",
            PRICE_VAL_MIN,
            PRICE_VAL_MAX);

    private String make;
    private String model;
    private double price;
    private int wheels;
    private VehicleType type;
    private final List<Comment> comments;

    protected VehicleBase(String make, String model, double price) {
        setMake(make);
        setModel(model);
        setPrice(price);
        comments = new ArrayList<>();
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getWheels() {
        return wheels;
    }

    @Override
    public VehicleType getType() {
        return type;
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public String toString() {
        return String.format("%s:%n" +
                        "Make: %s%n" +
                        "Model: %s%n" +
                        "Wheels: %s%n" +
                        "Price: $%s%n",
                getType(),
                getMake(),
                getModel(),
                getWheels(),
                removeTrailingZerosFromDouble(getPrice()));
    }
    public String commentsToString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (comments.isEmpty()) stringBuilder.append(NO_COMMENTS_HEADER);
        else {
            stringBuilder.append(COMMENTS_HEADER);
            for (Comment comment : comments) {
                stringBuilder.append(comment.toString());
            }
            stringBuilder.append(COMMENTS_HEADER);
        }
        return stringBuilder.toString().trim();
    }
    private static String removeTrailingZerosFromDouble(double number) {
        BigDecimal num = BigDecimal.valueOf(number).stripTrailingZeros();
        return num.toPlainString();
    }
    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    @Override
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    private void setMake(String make) {
        validateIntRange(make.length(), MAKE_NAME_LEN_MIN, MAKE_NAME_LEN_MAX, MAKE_NAME_LEN_ERR);
        this.make = make;
    }
    private void setModel(String model) {
        validateIntRange(model.length(), MODEL_NAME_LEN_MIN, MODEL_NAME_LEN_MAX, MODEL_NAME_LEN_ERR);
        this.model = model;
    }
    private void setPrice(double price) {
        validateDecimalRange(price, PRICE_VAL_MIN, PRICE_VAL_MAX, PRICE_VAL_ERR);
        this.price = price;
    }

    protected void setType(VehicleType type) {
        this.type = type;
    }

    protected void setWheels(int wheels) {
        this.wheels = wheels;
    }
}
