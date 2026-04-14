class WorldState {
    //LinkedList type, num in array
    //Everything is nonvoid
    public static void main (String[] args) {
        String[][] worldState = initializeWorld(100, 100, 100, 0);
    }

    /**
     * Expected input: int trees, int fish, int fullness, int campfire
     * Expected output: String[][] (2D list of trees, fish, fullness, campfire value)
     */
    public static String[][] initializeWorld(int trees, int fish, int fullness, int campfire) {
        String[][] worldState = new String[4][2];
        
        worldState[0] = new String[]{"trees", Integer.toString(trees)};
        worldState[1] = new String[]{"fish", Integer.toString(fish)};
        worldState[2] = new String[]{"fullness", Integer.toString(fullness)};
        worldState[3] = new String[]{"campfire", Integer.toString(campfire)};

        return worldState;
    }
}
