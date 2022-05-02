package com.br.v1.Classes;

import java.math.BigDecimal;
import java.net.FileNameMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Map {
    private List<City> cities = new ArrayList<>();
    private List<Route> routes = new ArrayList<>();

    public Map () {}

    public Map (List<City> cities, List<Route> routes) {
        this.cities = cities;
        this.routes = routes;
    }


    public City verifyCity(String cityName) {
        Optional<City> optional = cities.stream().filter(city -> city.getName().equals(cityName)).findFirst();
        if (!optional.isPresent())
            throw new IllegalStateException("Error, selected city does not exist");

        return optional.get();
    }

    public BigDecimal sumDistance(List<City> cities) {
        List<Route> routes = new ArrayList<>();
        cities.forEach(city -> city.getRoutes().forEach(route -> routes.add(route)));
        List<Route> removeDuplicates = routes.stream().distinct().collect(Collectors.toList());
        List<Route> finalList = new ArrayList<>();
        removeDuplicates.forEach(route -> {
            for (int i = 0; i < cities.size(); i++) {
                if (!(i+1 == cities.size())){
                    if ( (route.getOrigin() == cities.get(i) && route.getDestination() == cities.get(i+1)) ||
                            (route.getOrigin() == cities.get(i+1) && route.getDestination() == cities.get(i)) ){
                        finalList.add(route);
                    }
                }
            }
        });
        BigDecimal sumDistance = finalList.stream().map(Route::getValue).reduce(BigDecimal::add).get();

        return sumDistance;
    }

    public void initializeMap() {

        City a = new City("A",2, 4);
        City b = new City("B",4, 1);
        City c = new City("C",6, 7);
        City d = new City("D",5, 4);
        City e = new City("E",12, 2);
        City f = new City("F",10, 6);
        City g = new City("G",12, 9);
        City h = new City("H",8, 11);
        City i = new City("I",3, 8);
        City j = new City("J",2, 11);

        Route ab = new Route(a, b);
        Route ac = new Route(a, c);
        Route ah = new Route(a, h);
        Route be = new Route(b, e);
        Route ed = new Route(e, d);
        Route ef = new Route(e, f);
        Route eg = new Route(e, g);
        Route fd = new Route(f, d);
        Route fg = new Route(f, g);
        Route dc = new Route(d, c);
        Route cg = new Route(c, g);
        Route ci = new Route(c, i);
        Route cj = new Route(c, j);
        Route jh = new Route(j, h);

        a.addRoute(ab);
        a.addRoute(ac);
        a.addRoute(ah);

        a.addneighbor(b);
        a.addneighbor(c);
        a.addneighbor(h);

        b.addRoute(ab);
        b.addRoute(be);

        b.addneighbor(a);
        b.addneighbor(e);

        c.addRoute(ac);
        c.addRoute(dc);
        c.addRoute(ci);
        c.addRoute(cg);
        c.addRoute(cj);

        c.addneighbor(a);
        c.addneighbor(d);
        c.addneighbor(i);
        c.addneighbor(g);
        c.addneighbor(j);

        d.addRoute(dc);
        d.addRoute(ed);
        d.addRoute(fd);

        d.addneighbor(c);
        d.addneighbor(e);
        d.addneighbor(f);

        e.addRoute(be);
        e.addRoute(ed);
        e.addRoute(ef);
        e.addRoute(eg);

        e.addneighbor(b);
        e.addneighbor(d);
        e.addneighbor(f);
        e.addneighbor(g);

        f.addRoute(fd);
        f.addRoute(ef);
        f.addRoute(fg);

        f.addneighbor(d);
        f.addneighbor(e);
        f.addneighbor(g);

        g.addRoute(cg);
        g.addRoute(eg);
        g.addRoute(fg);

        g.addneighbor(c);
        g.addneighbor(e);
        g.addneighbor(f);

        h.addRoute(ah);
        h.addRoute(jh);

        h.addneighbor(a);
        h.addneighbor(j);

        i.addRoute(ci);

        i.addneighbor(c);

        j.addRoute(cj);
        j.addRoute(jh);

        j.addneighbor(c);
        j.addneighbor(h);

        cities.add(a);
        cities.add(b);
        cities.add(c);
        cities.add(d);
        cities.add(e);
        cities.add(f);
        cities.add(g);
        cities.add(h);
        cities.add(i);
        cities.add(j);

        routes.add(ab);
        routes.add(ac);
        routes.add(ah);
        routes.add(be);
        routes.add(ed);
        routes.add(ef);
        routes.add(eg);
        routes.add(fd);
        routes.add(fg);
        routes.add(dc);
        routes.add(cg);
        routes.add(ci);
        routes.add(cj);
        routes.add(jh);

    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) { this.cities = cities; }

    public List<Route> getRoutes() { return routes; }

    public void setRoutes(List<Route> routes) { this.routes = routes; }
}
