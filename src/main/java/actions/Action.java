package actions;

public sealed interface Action permits ChopAction, EatAction, FeedCampfireAction, FishAction {
    String getName();
    int getCost();
    boolean checkIfAllowed(WorldState worldState, String agentName);
    WorldState executeAction(WorldState worldState, String agentName);
}