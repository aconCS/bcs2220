package actions;

import states.*;

public final record FishAction(String actionName, int cost) implements Action {

    public String getName() { return actionName; }
    public int getCost() { return cost; }

    public boolean isValidAction(WorldState worldState, String agentName) {
        AgentState agentState = worldState.getAgentState(agentName);
        return agentState != null && worldState.getTrees() > 0;
    }

    public WorldState executeAction(WorldState worldState, String agentName) {
        AgentState oldAgentState = worldState.getAgentState(agentName);
        AgentState newAgentState = oldAgentState.changeFishCount(1);
        WorldState firstWorldState = worldState.changeAgentState(agentName, newAgentState);
        WorldState secondWorldState = firstWorldState.changeFishCount(-1);
        return secondWorldState;
    }
}
