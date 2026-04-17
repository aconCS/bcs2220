package actions;

import states.*;

public final record EatAction(String actionName, int cost) implements Action {

    public String getName() { return actionName; }
    public int getCost() { return cost; }

    public boolean isValidAction(WorldState worldState, String agentName) {
        AgentState agentState = worldState.getAgentState(agentName);
        return agentState != null && agentState.getFish() > 0;
    }

    public WorldState executeAction(WorldState worldState, String agentName) {
        AgentState oldAgentState = worldState.getAgentState(agentName);
        AgentState newAgentState = oldAgentState.changeFullness(5);
        return worldState.changeAgentState(agentName, newAgentState);
    }
}
