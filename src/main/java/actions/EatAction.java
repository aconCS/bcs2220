package actions;

public final record EatAction (String action, int cost, String effect, String[] preReq) implements Action {

    public String getName() { return actionName; }
    public int getCost() { return cost; }

    public boolean checkIfAllowed(WorldState worldState, String agentName) {
        AgentState agentState = worldState.getAgentState(agentName);
        return agentState != null && agentState.fish > 0;
    }

    public WorldState executeAction(WorldState worldState, String agentName) {
        AgentState firstAgentState = worldState.getAgentState(agentName);
        AgentState secondAgentState = firstAgentState.changeFullness(-1);
        return worldState.changeAgentState(agentName, secondAgentState);
    }
}
