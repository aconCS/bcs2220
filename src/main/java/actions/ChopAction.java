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
        WorldState firstState = worldState.changeTreeCount(-1);
        return firstState.changeAgentState(agentName);
    }
}
