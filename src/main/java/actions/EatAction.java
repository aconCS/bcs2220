package actions;

import states.*;

public final record EatAction (String actionName, int cost) implements Action {

    public EatAction {
        if (cost < 0) { throw new IllegalStateException("Action cost must be at least zero."); }
    }
        
    public boolean checkIfAllowed(WorldState worldState, String agentName) {
        AgentState agentState = worldState.getAgentState(agentName);
        return agentState != null && agentState.fish() > 0;
    }

    public WorldState execute(WorldState worldState, String agentName) {
        AgentState firstAgentState = worldState.getAgentState(agentName);
        AgentState secondAgentState = firstAgentState.changeFullness(5);
        return worldState.changeAgentState(agentName, secondAgentState);
    }
}
