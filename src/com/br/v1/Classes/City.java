package com.br.v1.Classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class City implements Comparable<City>{

    private String name;
    private Integer coordX;
    private Integer coordY;
    private City predecessor;
    private BigDecimal distance;
    private boolean visited;
    private List<Route> routes;
    private List<City> neighbors;

    public City(){}

    public City (String name, Integer coordX, Integer coordY){
        this.name = name;
        this.coordX = coordX;
        this.coordY = coordY;
        this.visited = false;
        this.routes = new ArrayList<>();
        this.neighbors = new ArrayList<>();
    }

    public void addRoute(Route route){

        this.routes.add(route);
    }

    public void addneighbor(City city){

        this.neighbors.add(city);
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public Integer getCoordX() {
        return coordX;
    }

    public void setCoordX(Integer coordX) {
        this.coordX = coordX;
    }

    public Integer getCoordY() { return coordY; }
    public void setCoordY(Integer coordY) {
        this.coordY = coordY;
    }

    public City getPredecessor() { return predecessor; }

    public void setPredecessor(City predecessor) { this.predecessor = predecessor; }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public List<City> getNeighbors() { return neighbors; }

    public void setNeighbors(List<City> neighbors) { this.neighbors = neighbors; }

    public boolean isVisited() { return visited; }

    public void setVisited(boolean visited) { this.visited = visited; }

    @Override
    public int compareTo(City city) {
        return this.getDistance().compareTo(city.distance);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof City){
            City ref = (City) obj;
            if(this.getName().equals(ref.getName()))
                return true;
        }
        return false;
    }
}
