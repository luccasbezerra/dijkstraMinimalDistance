package com.br;

import com.br.v1.Classes.City;
import com.br.v1.Classes.Dijkstra;
import com.br.v1.Classes.Map;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        map.initializeMap();

        System.out.println("Select your city of origin:");
        System.out.println(map.getCities().stream().map(city -> city.getName()).collect(Collectors.toList()));
        Scanner sc1 = new Scanner(System.in);
        String city1 = sc1.nextLine();
        City origin = map.verifyCity(city1);

        System.out.println("Select destination city:");
        Scanner sc2 = new Scanner(System.in);
        String city2 = sc2.nextLine();
        City destination = map.verifyCity(city2);

        Dijkstra dijkstra = new Dijkstra();
        List<City> minimal = dijkstra.minimalDistance(map,origin,destination);
        System.out.println("Best Route:");
        System.out.println(minimal.stream().map(city -> city.getName()).collect(Collectors.toList()));
        System.out.println("Distance:");
        System.out.println(map.sumDistance(minimal));

    }
}
