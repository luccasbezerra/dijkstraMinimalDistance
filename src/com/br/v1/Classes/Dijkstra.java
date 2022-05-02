package com.br.v1.Classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {

    List<City> shortestPath = new ArrayList<>();

    City aux = new City();

    City present = new City();

    City neighbor = new City();

    List<City> noVisited = new ArrayList<>();

    public List<City> minimalDistance(Map map, City origin, City destination) {

        shortestPath.add(origin);

        for (int i = 0; i < map.getCities().size(); i++) {

            if (map.getCities().get(i).getName().equals(origin.getName())) {
                map.getCities().get(i).setDistance(new BigDecimal(0));
            } else {
                map.getCities().get(i).setDistance(new BigDecimal(9999));
            }
            this.noVisited.add(map.getCities().get(i));
        }

        Collections.sort(noVisited);

        while (!this.noVisited.isEmpty()) {

            present = this.noVisited.get(0);
            for (int i = 0; i < present.getRoutes().size(); i++) {
                neighbor = present.getRoutes().get(i).getDestination();
                if (!neighbor.isVisited()) {

                    if (neighbor.getDistance().compareTo(present.getDistance().add(present.getRoutes().get(i).getValue())) == 1) {
                        neighbor.setDistance(present.getDistance().add(present.getRoutes().get(i).getValue()));
                        neighbor.setPredecessor(present);
                        if (neighbor == destination) {
                            shortestPath.clear();
                            aux = neighbor;
                            shortestPath.add(neighbor);
                            while (aux.getPredecessor() != null) {
                                shortestPath.add(aux.getPredecessor());
                                aux = aux.getPredecessor();
                            }
                            Collections.sort(shortestPath);
                        }
                    }
                }
            }
            present.setVisited(true);
            this.noVisited.remove(present);
            Collections.sort(noVisited);
        }

        return shortestPath;
    }
}