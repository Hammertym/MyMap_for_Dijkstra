public class Main {

    public static void main (String[] args){

        //This is the process to create the Map. It can be done with any number of nodes, any length values, or anything
        // else. You can add Nodes, or connections between them. When you add a Node,
        Map myMap = new Map();
        myMap.addNode("data", 5, true);
        myMap.addNode("data2", 3, true);
        myMap.addNode("data3", 4, true);
        myMap.addNode("data4", 2, myMap.findByData("data3"), true);
        myMap.addConnection(7, myMap.findByData("data4"), myMap.findByData("data2"), true);
        myMap.addNode("data5", 3, myMap.findByData("data4"), true);
        myMap.addNode("data6", 2, myMap.findByData("data3"), true);
        myMap.addConnection(6, myMap.findByData("data5"), myMap.findByData("data6"), true);

        //This is a basic iteration loop. It allows the user to do what Dijkstra (hopefully) can simulate. After
        // creating the map, it allows the user to travel through it, while keeping track of the lengths.
        while(true) {
            myMap.displayConnections(myMap.currentNode);
            myMap.travel();
        }
    }
}
