package actions;

import states.*;

public final record FeedCampfireAction (String actionName, int cost) implements Action {

    public String getName() { return actionName; }
    public int getCost() { return cost; }

    public boolean checkIfAllowed(WorldState worldState, String agentName) {
        AgentState agentState = worldState.getAgentState(agentName);
        return agentState != null && agentState.fish() > 0;
    }

    public WorldState execute(WorldState worldState, String agentName) {
        AgentState firstAgentState = worldState.getAgentState(agentName);
        AgentState secondAgentState = firstAgentState.changeCampfire(5);
        return worldState.changeAgentState(agentName, secondAgentState);
    }
}
