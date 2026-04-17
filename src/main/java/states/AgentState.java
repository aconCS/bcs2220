package states;

public record AgentState(int wood, int fish, int fullness, int campfire) {
    public AgentState changeWoodCount(int newWoodCount) { return new AgentState(wood + newWoodCount, fish, fullness, campfire); }
    public AgentState changeFishCount(int newFishCount) { return new AgentState(wood, fish + newFishCount, fullness, campfire); }
    public AgentState changeFullness(int newFullness) { return new AgentState(wood, fish, fullness + newFullness, campfire); }
    public AgentState changeCampfire(int newCampfire) { return new AgentState(wood, fish, fullness, campfire + newCampfire); }
}
