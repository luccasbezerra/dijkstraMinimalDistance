package com.br.v1.Classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Route {
    private String name;
    private City origin;
    private City destination;
    private BigDecimal value;

    public Route(City origin, City destination){
        this.origin = origin;
        this.destination = destination;
        this.name = concatCitiesNames(origin, destination);
        this.value = calculateDistanceBetweenCities(origin, destination);
    }

    public String concatCitiesNames(City x, City y) {
        return x.getName() + y.getName();
    }

    public BigDecimal calculateDistanceBetweenCities(City x, City y) {
        Integer coordX = Math.abs((x.getCoordX() - y.getCoordX()));
        Integer coordY = Math.abs((x.getCoordY() - y.getCoordY()));

        return BigDecimal.valueOf(Math.sqrt((Math.pow(coordX, 2) + Math.pow(coordY, 2))));
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City in) { this.origin = in; }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City out) { this.destination = out; }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) { this.value = value; }
}
