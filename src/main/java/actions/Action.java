package actions;

import states.*;

public sealed interface Action permits ChopAction, EatAction, FeedCampfireAction, FishAction {
    String getName();
    int getCost();
    boolean checkIfAllowed(WorldState worldState, String agentName);
    WorldState execute(WorldState worldState, String agentName);
}