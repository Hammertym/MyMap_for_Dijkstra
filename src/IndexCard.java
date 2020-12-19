public  class IndexCard {
    String cardName;
    Integer distanceValue;
    String previousPath;

    public IndexCard(String cardName) {
        this.cardName = cardName;
        distanceValue = 0;
        previousPath = null;
    }

    public IndexCard(String cardName, Integer defaultValue) {
        this.cardName = cardName;
        distanceValue = defaultValue;
        previousPath = null;
    }

    public IndexCard(String cardName, Integer defaultValue, String previousPath) {
        this.cardName = cardName;
        distanceValue = defaultValue;
        this.previousPath = previousPath;
    }

    public String getCardName (){ return cardName;}

    public void setDistanceValue(int val) { distanceValue = val;}

    public Integer getDistanceValue() {
        return distanceValue;
    }

    public void setPath(String s){ this.previousPath = s; }

    public String returnPath(){ return previousPath; }

    public void addToDistance(Integer value) { distanceValue += value; }
    }
