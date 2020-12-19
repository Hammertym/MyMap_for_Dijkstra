import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean b = true;

        //This is the process to create the Map. It can be done with any number of nodes, any length values, or anything
        // else. You can add Nodes, or connections between them. When you add a Node, you need to set the connected
        // node, the data, and whether or not the length is random. If the inputted length value is zero, the node will
        // be given a random value. Otherwise, it will use the value given.

        // I know it specified as a boolean constructor, but this makes the declarations more compact, and accomplishes
        // the same thing.

        // Also, because these are hardcoded, I am going to assume that the user will only enter Nodes that exist.
        Map myMap = new Map();
        myMap.addNode("Bedroom", 0);
        myMap.addNode("BrotherRoom", 2);
        myMap.addNode("Stairs", 4);
        myMap.addNode("Kitchen", 7, myMap.findByData("Stairs"));
        myMap.addNode("DiningRoom", 3, myMap.findByData("Kitchen"));
        myMap.addNode("Mudroom", 2, myMap.findByData("Kitchen"));
        myMap.addNode("FrontDoor", 1, myMap.findByData("Mudroom"));
        myMap.addNode("BrotherWindow", 1, myMap.findByData("BrotherRoom"));
        myMap.addNode("MyWindow", 1);
        myMap.addNode("Roof", 4, myMap.findByData("MyWindow"));
        myMap.addNode("FrontYard", 10, myMap.findByData("Roof"));
        myMap.addConnection(6, myMap.findByData("FrontYard"), myMap.findByData("FrontDoor"));
        myMap.addConnection(3, myMap.findByData("Stairs"), myMap.findByData("DiningRoom"));
        myMap.addConnection(11, myMap.findByData("Stairs"), myMap.findByData("FrontDoor"));
        myMap.addConnection(6, myMap.findByData("DiningRoom"), myMap.findByData("Mudroom"));
        myMap.addConnection(2, myMap.findByData("BrotherWindow"), myMap.findByData("Roof"));

        Dijkstra myDijkstra = new Dijkstra(myMap);
        myDijkstra.findShortestPath("Bedroom", "FrontDoor");

    }
}
