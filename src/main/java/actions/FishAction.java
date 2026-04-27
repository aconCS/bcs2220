package actions;

import states.*;

public final record FishAction (String actionName, int cost) implements Action {

    public FishAction {
        if (cost < 0) { throw new IllegalStateException("Action cost must be at least zero."); }
    }

    public boolean checkIfAllowed(WorldState worldState, String agentName) {
        AgentState agentState = worldState.getAgentState(agentName);
        return agentState != null && worldState.fish() > 0;
    }

    public WorldState execute(WorldState worldState, String agentName) {
        AgentState firstAgentState = worldState.getAgentState(agentName);
        AgentState secondAgentState = firstAgentState.changeFishCount(1);
        WorldState firstWorldState = worldState.changeAgentState(agentName, secondAgentState);
        WorldState secondWorldState = firstWorldState.changeFishCount(-1);
        return secondWorldState;
    }
}
