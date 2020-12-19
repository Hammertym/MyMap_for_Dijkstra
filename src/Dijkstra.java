import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra {
    Map usedMap;
    Boolean random;
    String starterNode;


    public Dijkstra (Map map, boolean random){
        this.usedMap = map;
        this.random = random;
        this.starterNode = map.firstNode.getData();
    }

    public Dijkstra (Map map){
        this.usedMap = map;
        this.starterNode = map.firstNode.getData();
    }

    public void findShortestPath(String origin, String target){
        ArrayList<IndexCard> cardList = usedMap.createIndexCardList();
        MyPriorityQueue queue = new MyPriorityQueue();
        Queue settled = new LinkedList();
        IndexCard currCard = new IndexCard(origin, 0, null), connCard, tempCard = new IndexCard("", 0, "");
        ArrayList<Map.Connection> currentConn;
        queue.add(currCard);
        while (!currCard.getCardName().equals(target)){
            currentConn = usedMap.findByData(currCard.getCardName()).getConnections();
            for (Map.Connection C : currentConn){
                String tempName = C.getConnect().getData();
                tempCard = new IndexCard(tempName, currCard.getDistanceValue() + C.getlength(), currCard.getCardName());
                if (queue.checkQueue(tempCard, currCard) == 1){
                    System.out.println("added Card: " + tempCard.getCardName());
                    queue.add(tempCard);}
                else System.out.println("Repeat Card, added Card: " + tempCard.getCardName());
                queue.show();
                System.out.println("CurrCard2: " + currCard.getCardName());
            }
            System.out.println(queue.peer().getCardName() + " is removed");
            queue.remove();
            currCard = queue.peer();
            System.out.println();
        }
        queue.finishTheJob(target);
    }
}

    /*int i = 0;
    MyPriorityQueue queue = new MyPriorityQueue();
        queue.add(origin, 0, origin);
                String currNode = usedMap.findByData(origin).getData();
                ArrayList<Map.Connection> currentConn = usedMap.findByData(origin).getConnections();
        while (!currNode.equals(target)){
        while (currentConn.size() > 0) {
        System.out.println("Examining Node: " + queue.peer());
        usedMap.displayConnections(usedMap.findByData(currNode));
        queue.add(currentConn.get(0).getConnect().getData(), currentConn.get(0).getlength(), currNode);
        System.out.println("Node '" + currentConn.get(0).getConnect().getData() + "' was added");
        queue.show();
        System.out.println();
        currentConn.remove(0);
        }
        queue.remove();
        currNode = queue.peer();
        currentConn = compareConnections(queue, usedMap.findByData(currNode).getConnections());

        }*/
