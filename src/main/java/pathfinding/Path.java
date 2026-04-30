package pathfinding;

import actions.Action;
import states.WorldState;

import java.util.List;

public record Path(WorldState finalWorldState, String agentName, List<Action> actionPath, int finalH) {}