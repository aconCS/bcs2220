package states;

public final record AgentState(int wood, int fish, int fullness, int campfire) {
    public AgentState {
        if (wood < 0) { throw new IllegalStateException("Woodcount must be at least zero."); }
        if (fish < 0) { throw new IllegalStateException("Fishcount must be at least zero."); }
        if (fullness < 0) { throw new IllegalStateException("Fullness must be at least zero."); }
        if (fullness < 0) { throw new IllegalStateException("Campfire health must be at least zero."); }
    }
    public AgentState changeWoodCount(int newWoodCount) { return new AgentState(wood + newWoodCount, fish, fullness, campfire); }
    public AgentState changeFishCount(int newFishCount) { return new AgentState(wood, fish + newFishCount, fullness, campfire); }
    public AgentState changeFullness(int newFullness) { return new AgentState(wood, fish, fullness + newFullness, campfire); }
    public AgentState changeCampfire(int newCampfire) { return new AgentState(wood, fish, fullness, campfire + newCampfire); }
}
