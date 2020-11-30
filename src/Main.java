public class Main {

    public static void main (String[] args){

        //This is the process to create the Map. It can be done with any number of nodes, any length values, or anything
        // else. You can add Nodes, or connections between them. When you add a Node, you need to set the connected
        // node, the data, and whether or not the length is random. If the inputted length value is zero, the node will
        // be given a random value. Otherwise, it will use the value given.

        // I know it specified as a boolean constructor, but this makes the declarations more compact, and accomplishes
        // the same thing.
        Map myMap = new Map();
        myMap.addNode("data", 5);
        myMap.addNode("data2", 3);
        myMap.addNode("data3", 4);
        myMap.addNode("data4", 2, myMap.findByData("data3"));
        myMap.addConnection(7, myMap.findByData("data4"), myMap.findByData("data2"));
        myMap.addNode("data5", 3, myMap.findByData("data4"));
        myMap.addNode("data6", 2, myMap.findByData("data3"));
        myMap.addConnection(6, myMap.findByData("data5"), myMap.findByData("data6"));

        //This is a basic iteration loop. It allows the user to do what Dijkstra (hopefully) can simulate. After
        // creating the map, it allows the user to travel through it, while keeping track of the lengths.
        while(true) {
            myMap.displayConnections(myMap.currentNode);
            myMap.travel();
        }
    }
}
