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

    }
}
