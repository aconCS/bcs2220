import pathfinding.Path;
import states.*;
import pathfinding.BestPath;

import java.util.HashMap;
import java.util.Map;

import actions.ActionPool;

class Main {
  public static void main(String[] args) {
    int trees = 100;
    int fish = 100;
    int maxDailyCost = 7;
    int maxAgentCount = 1;
    WorldState mainWorld = new WorldState(trees, fish, initializeAgentList(maxAgentCount), 0, maxDailyCost);
    int maxDayCount = 5;

    while(checkIfGameOn(mainWorld, maxDayCount)) {
      System.out.println("DAY " + mainWorld.day() + "\n");
      WorldState newWorldState = mainWorld;
      for(String agent : newWorldState.agents().keySet()) {
        Path newAgentPath = BestPath.bestPath(newWorldState, agent, ActionPool.getAllActions());
        System.out.println(agent + "'s actions: " + newAgentPath.actionPath());
        newWorldState = newAgentPath.finalWorldState();
      }
      mainWorld = newWorldState;
      System.out.println("\nEND OF DAY " + mainWorld.day() + "\n\n\n");
      mainWorld = mainWorld.changeDay();
      mainWorld = mainWorld.updateAllAgentFullness(-1);
    }
  }

  private static Map<String, AgentState> initializeAgentList(int n) {
    Map<String, AgentState> agentList = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String name = "agent" + i;
      AgentState agent = new AgentState(0, 0, 100, 0);
      agentList.put(name, agent);
    }
    return agentList;
  }

  private static boolean checkIfGameOn(WorldState worldState, int maxDayCount) {
    return worldState.day() >= maxDayCount ? false: true;
  }
}
