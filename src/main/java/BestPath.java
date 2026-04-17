import java.util.List;
import java.util.PriorityQueue;

import actions.Action;
import states.WorldState;

record Path(WorldState state, int srcToCurrentCost, List<Action> actionPath) {}

public final class BestPath{
  public static Path bestPathSearch(WorldState world, String agent, int srcToCurrentCost, int maxDailyCost, List<Action> actionPath) {
    if (maxDailyCost - srcToCurrentCost <= 0) { return null; }
    if (isFinalState(currentState)) { return new Path(currentState, srcToCurrentCost, actionPath); }

    Path bestPath = null;
    for (Action action : actions) {
      int srcToNextStateCost = srcToCurrentCost + action.cost;
      if (srcToNextStateCost > maxDailyCost) { continue; }
      WorldState nextState = getNextState(action);
      if (nextState == null) { continue; }

      List<Action> newActionPath = List.copyOf(actionPath);
      newActionPath.add(action);
      Path path = bestPathSearch(nextState, srcToNextStateCost, maxDailyCost, newActionPath);

      bestPath = comparePaths(bestPath, path);
    }

    return bestPath;
  }

  private static boolean isFinalState(WorldState worldState, String agentName) {
    return worldState.getAgentState(agentName).getCampfire() >= 100;
  }

  private static Path comparePaths(Path path1, Path path2) {
    if (path1.actionPath().length() < path2.actionPath().length())
    return new Path(null, 0, null);
  }

  private static WorldState getNextState(WorldState worldState, String agentName, Action action) {
    if (action.checkIfAllowed(worldState, agentName)) {
      return action.execute(worldState, agentName);
    }
    return null;
  }

  public static Path AStar(WorldState worldState, String agentName, int srcToCurrentCost, int maxDailyCost) {
    return;
  }

  public int heuristic(WorldState worldState, String agentName) {
        return;
    }
}
