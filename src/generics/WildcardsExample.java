package generics;

import java.util.ArrayList;
import java.util.List;

/*
*   A wildcard is essentially an unknown type, which can be very useful in some situations.
*
* */
public class WildcardsExample {
    public static void main(String[] args) {
        List<Building> buildings = List.of(new Building(), new Building());
        printBuildings(buildings);

        List<Office> offices = List.of(new Office(), new Office());
        printBuildings(offices);

        List<House> houses = List.of(new House(), new House());
        printBuildings(houses);

        addHouseToList(houses);
        addHouseToList(buildings);
//        addHouseToList(offices);
    }

    /*
    *   The problem is this method only take List of buildings, not list of Office and list of House
    * */
//    static void printBuildings(List<Building> buildings) {

    // Solve problem using generics wildcard, now we can pass list of any objects that extends the Building class
    static void printBuildings(List<? extends Building> buildings) { // in variables
        int number = 0;
        for (Building building : buildings) {
            System.out.println(building.toString() + " " + ++number);
        }
        System.out.println();
    }

    static void addHouseToList(List<? super House> buildings) { // out variable
        buildings.add(new House());
    }

    /*  NOTE: it is generally a bad iea to use wildcards in return types  */
}


class Building {
     @Override
    public String toString() {  return "building"; }
}

class Office extends Building {
    @Override
    public String toString() { return "office"; }
}

class House extends Building {
    @Override
    public String toString() { return "house"; }
}

