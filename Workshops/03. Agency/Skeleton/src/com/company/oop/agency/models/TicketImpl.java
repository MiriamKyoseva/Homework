package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {
    private Journey journey;
    private String destination;
    private double administrativeCosts = 1.00;
    private double price = 0;
    private int id = 0;

    @Override
    public int getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    protected void setJourney(Journey journey) {
        this.journey = journey;
    }

    @Override
    public double getAdministrativeCosts() {
        return administrativeCosts;
    }
    private void setAdministrativeCosts(double costs) {
        administrativeCosts = costs;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double calculatePrice() {
        return journey.calculateTravelCosts()*getAdministrativeCosts();
    }
    public TicketImpl(int id, Journey journey, double costs) {
        //it's not 0 because it wouldn't make sense the administrative costs to be less than 1
        // which will result in a total price lower than the travel costs.
        if (costs < 1)
            throw new InvalidUserInputException(String.format("Value of 'costs' must be a positive number. Actual value: %.2f.", costs));
        this.id = id;
        setJourney(journey);
        setDestination(journey.getDestination());
        setAdministrativeCosts(costs);
        price = calculatePrice();
    }
    @Override
    public String getAsString() {
        String string = String.format(
                "Ticket ----%n"
                + "Destination: %s%n"
                + "Price: %.2f%n",
                getDestination(),
                getPrice()
        );
        return string;
    }

}
