package pathfinding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import actions.Action;
import states.WorldState;

record Node(WorldState worldState, String agentName, int g, int h, List<Action> actionPath) {
  int getF() { return g + h; }
  Path getPath() { return new Path(worldState, agentName, actionPath); }
}
record Pair(WorldState worldState, String agentName) {}

public final class BestPath{
  private static boolean isFinalState(WorldState worldState, String agentName) {
    return worldState.getAgentState(agentName).campfire() >= 100;
  }

  public static Path bestPath(WorldState worldState, String agentName, int maxDailyCost, List<Action> allActions) {
    Node start = new Node(worldState, agentName, 0, heuristic(worldState, agentName), List.of());
    PriorityQueue<Node> openList = new PriorityQueue<Node>( Comparator
      .comparingInt(Node::getF)
      .thenComparingInt(Node::h)
    );
    openList.add(start);
    List<Node> closedList = List.of();
    return AStar(openList, closedList, maxDailyCost, allActions);
  }

  private static Path AStar(
    PriorityQueue<Node> openList, List<Node> closedList, int maxDailyCost, List<Action> allActions
  ) {
    if (openList.isEmpty()) { return null; }

    Node current = openList.peek();
    if (current.g() > maxDailyCost) { return null; }

    if (isFinalState(current.worldState(), current.agentName())) { return current.getPath(); }
    
    Pair pair = new Pair(current.worldState(), current.agentName());
    if (closedList.contains(pair)) { return null; }

    List<Node> newClosedList = new ArrayList<>(closedList);
    newClosedList.add(current);
    PriorityQueue<Node> newOpenList = new PriorityQueue<>(openList);
    newOpenList.poll();

    Path bestPath = current.getPath();
    for (Action action : allActions) {
      if (!action.checkIfAllowed(current.worldState(), current.agentName())) { continue; }
      int newG = action.cost() + current.g();
      if (newG > maxDailyCost) { continue; }

      WorldState newState = action.execute(current.worldState(), current.agentName());
      List<Action> newActionPath = Stream.concat(current.actionPath().stream(), List.of(action).stream()).collect(Collectors.toList());
      int newH = 100 - newState.getAgentState(current.agentName()).campfire();
      Node newNode = new Node(newState, current.agentName(), newG, newH, newActionPath);

      newOpenList.add(newNode);
      Path newPath = AStar(newOpenList, newClosedList, maxDailyCost, allActions);
      bestPath = comparePath(bestPath, newPath);
    }
    
    return bestPath;
  }

  private static Path comparePath(Path one, Path two) {
    return one.actionPath().size() <= two.actionPath().size() ? one : two;
  }

  private static int heuristic(WorldState worldState, String agentName) {
        return 100 - worldState.getAgentState(agentName).campfire();
    }
}
