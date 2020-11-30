import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    Node firstNode, currentNode;
    Scanner scan = new Scanner(System.in);
    ArrayList<Connection> connectList = new ArrayList<>();
    ArrayList<Node> nodeList = new ArrayList<>();
    int travelLength;


    public Map(){
        this.firstNode = null;
        travelLength = 0;
    }

    public void addNode(String data, int length){
        if (firstNode == null){
            this.firstNode = new Node(data);
            nodeList.add(firstNode);
            currentNode = firstNode;
        } else {
            Node tempNode = new Node(data);
            addConnection(length, firstNode, tempNode);
            nodeList.add(tempNode);
        }
    }

    public void addNode(String data, int length, Node connectNode){
            Node tempNode = new Node(data);
            addConnection(length, connectNode, tempNode);
            nodeList.add(tempNode);
    }

    //This is done so the connections go both ways. You can also use this method to manually add connections between two
    // existing Nodes, in addition to it being used in the addNode methods.
    public void addConnection(int length, Node headNode, Node footNode){
        Connection tempConn = new Connection(length, footNode);
        headNode.addConnections(tempConn);
        tempConn = new Connection(length, headNode);
        footNode.addConnections(tempConn);
    }

    public void displayConnections(Node n){
        connectList = n.getConnections();
        if (connectList.size() > 0) {
            System.out.println("\nCURRENT NODE: " + n.getData() + "\n" + n.getData() + " is connected with:");
            for (Connection c : connectList) {
                System.out.println(c.getConnect().getData() + " with length of: " + c.getlength());
            }
            System.out.println("total travel length: " + travelLength + "\n");
        } else {
            System.out.println("Node " + n.getData() + "has no connections");
        }
    }

    //The while loop is designed to essentially toss out the null return, as it will keep looping if the wrong node is
    // entered.
    public void travel(){
        connectList = currentNode.getConnections();
        boolean nodeCheck = false, secondCheck = false;
        String scanned = "";
        while (!nodeCheck) {
            System.out.println("Enter name of Node you are travelling to.");
            if (secondCheck)
                System.out.println("Node" + scanned + "was not found. Please try again");
            scanned = scan.nextLine();
            for (Connection c : connectList) {
                if (scanned.equals(c.getConnect().getData())) {
                    System.out.println(scanned + " found");
                    travelLength += c.getlength();
                    currentNode = findByData(scanned);
                    nodeCheck = true;
                }
            }
            secondCheck = true;
        }
    }

    //This method uses an array of nodes, and allows the user to search for specific nodes to create connections between
    // them. Whenever a Node is created, it is put into this array, so that it can be found later. I primarily used this
    // for adding connections, where the travel method is used for the actual iteration.
    public Node findByData(String data){
        boolean found = false;
        for (Node n : nodeList){
                if (n.getData().equals(data)) {
                    return n;
                }
        }
        System.out.println("Node " + data +  " not found.");
        return null;
    }

    public class Node {
        ArrayList<Connection> connections;
        String data;
        int travelUpdate;


        public Node(String data) {
            this.data = data;
            connections = new ArrayList<Connection>();
            travelUpdate = 0;
        }

        public String getData() {
            return this.data;
        }

        public ArrayList<Connection> getConnections() {
            return connections;
        }

        public void addConnections(Connection c) {
            connections.add(c); }
        }

        public class Connection {
            Node connectedNode;
            int length;

            //For the sake of small numbers, the random number will not exceed 10.
            public Connection(int length, Node n) {
                if (length == 0){
                    this.length = (int)(10*Math.random());
                } else {
                    this.length = length;
                }
                this.connectedNode = n;
            }

            public int getlength() {
                return this.length;
            }

            public Node getConnect() { return this.connectedNode; }
        }
    }