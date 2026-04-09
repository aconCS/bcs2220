import java.util.HashMap;
import java.util.LinkedList;

class WorldState {
    private static final LinkedList<String>[] worldState = new List[];

    public static void main (String[] args) {
        initializeWorld(100, 100, 100, 0);
    }

    private static void initializeWorld(int trees, int fish, int fullness, int campfire) {
        worldState.add("trees", trees);
        worldState.add("fish", fish);
        worldState.add("fullness", fullness);
        worldState.add("campfire", campfire);
    }

}