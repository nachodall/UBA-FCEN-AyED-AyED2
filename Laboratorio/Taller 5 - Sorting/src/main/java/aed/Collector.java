package aed;

public class Collector {
    private static Collector instance = null;
    private int acum = 0;

    private Collector() {
    }

    public void inc() {
        acum++;
    }

    public void reset(){
        acum = 0;
    }

    public int getValue() {
        return acum;
    }

    public static synchronized Collector getInstance() {
        if (instance == null) {
            instance = new Collector();
        }
        return instance;
    }
}
