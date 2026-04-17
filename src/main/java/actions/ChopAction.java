package actions;

import states.*;

public final record ChopAction (String actionName, int cost) implements Action {

    public String getName() { return actionName; }
    public int getCost() { return cost; }

    public boolean checkIfAllowed(WorldState worldState, String agentName) {
        AgentState agentState = worldState.getAgentState(agentName);
        return agentState != null && worldState.getTrees() > 0;
    }

    public WorldState executeAction(WorldState worldState, String agentName) {
        AgentState firstAgentState = worldState.getAgentState(agentName);
        AgentState secondAgentState = firstAgentState.changeWoodCount(1);
        WorldState firstWorldState = worldState.changeAgentState(agentName, secondAgentState);
        WorldState secondWorldState = firstWorldState.changeTreeCount(-1);
        return secondWorldState;
    }
}
