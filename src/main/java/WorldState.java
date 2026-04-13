import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class WorldState {
    private static final String[][] worldState;
    //LinkedList type, num in array
    //Everything is nonvoid
    public static void main (String[] args) {
        worldState = initializeWorld(100, 100, 100, 0);
    }

    // Method must output the variable
    /**
     * Expected input: int trees, int fish, int fullness, int campfire
     * Expected output: String[][] (2D list of trees, fish, fullness, campfire value)
     */
    private static void initializeWorld(int trees, int fish, int fullness, int campfire) {
        String[][] worldState = new String[4][2];
        
        worldState[0] = new String[]{"trees", Integer.toString(trees)};
        worldState[1] = new String[]{"fish", Integer.toString(fish)};
        worldState[2] = new String[]{"fullness", Integer.toString(fullness)};
        worldState[3] = new String[]{"campfire", Integer.toString(campfire)};

        return worldState;
    }
}
