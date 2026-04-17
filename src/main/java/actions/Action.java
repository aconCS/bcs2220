package actions;

import states.*;

public sealed interface Action permits ChopAction, EatAction, FeedCampfireAction, FishAction {
    String getName();
    int getCost();
    boolean isValidAction(WorldState worldState, String agentName);
    WorldState executeAction(WorldState worldState, String agentName);
}