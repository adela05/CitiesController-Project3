package com.compay.CitiesController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

public class Cities {
    @NotEmpty(message = "City name must be filled in.")
    private String name;
    @NotBlank(message = "fill in state")
    private String state;
    @PositiveOrZero(message = "population must be positive")
    private int population;
    private boolean isCapital;

    public Cities(String name, String state, int population, boolean isCapital) {
        this.name = name;
        this.state = state;
        this.population = population;
        this.isCapital = isCapital;
    }
    public Cities(){}

    // Setter and Getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }
}
