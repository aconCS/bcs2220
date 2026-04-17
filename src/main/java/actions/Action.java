package actions;

import states.*;

public sealed interface Action permits ChopAction, EatAction, FeedCampfireAction, FishAction {
    String getName();
    int getCost();
<<<<<<< HEAD
    boolean checkIfAllowed(WorldState worldState, String agentName);
    WorldState execute(WorldState worldState, String agentName);
=======
    boolean isValidAction(WorldState worldState, String agentName);
    WorldState executeAction(WorldState worldState, String agentName);
>>>>>>> 9c87694 (Renamed AgentState variable naming  convention from first... to old... and second... to new...)
}