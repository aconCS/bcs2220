package actions;

import states.*;

public final record ChopAction(String actionName, int cost) implements Action {
    public String getName() {
        return actionName;
    }

    public int getCost() {
        return cost;
    }

    public boolean checkIfAllowed(WorldState worldState, String agentName) {
        AgentState agentState = worldState.getAgentState(agentName);
        return agentState != null && worldState.getTrees() > 0;
    }

    public WorldState execute(WorldState worldState, String agentName) {
        AgentState oldAgentState = worldState.getAgentState(agentName);
        AgentState newAgentState = oldAgentState.changeWoodCount(1);
        WorldState oldWorldState = worldState.changeAgentState(
            agentName,
            newAgentState
        );
        WorldState newWorldState = oldWorldState.changeTreeCount(-1);
        return newWorldState;
    }
}
