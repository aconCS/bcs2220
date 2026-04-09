import java.util.HashMap;

class WorldState {
    private static final HashMap<String, Integer> worldState = new HashMap<String, Integer>();

    public static void main (String[] args) {
        initializeWorld(100, 100, 100, 0);
    }

    private static void initializeWorld(int trees, int fish, int hunger, int campfire) {
        worldState.put("trees", trees);
        worldState.put("fish", fish);
        worldState.put("hunger", hunger);
        worldState.put("campfire", campfire);
    }

}