import pathfinding.Path;
import states.*;
import pathfinding.BestPath;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    int trees = 100;
    int fish = 100;
    int maxDailyCost = 10;
    WorldState mainWorld = new WorldState(trees, fish, initializeAgentList(5), 0, maxDailyCost);

    while(checkIfGameOn(mainWorld)) {
      System.out.println("DAY " + mainWorld.day() + "\n");
      WorldState newWorldState = mainWorld;
      for(String agent : newWorldState.agents().keySet()) {
        Path newAgentPath = BestPath.bestPath(newWorldState, agent, newWorldState.maxDailyCost(), List.of());
        System.out.println(agent + "'s actions: " + newAgentPath.actionPath());
        newWorldState = newAgentPath.worldState();
      }
      mainWorld = newWorldState;
      System.out.println("\nEND OF DAY " + mainWorld.day() + "\n\n\n");
      mainWorld = mainWorld.changeDay();
    }
  }

  private static Map<String, AgentState> initializeAgentList(int n) {
    Map<String, AgentState> agentList = new HashMap();
    for (int i = 0; i < n; i++) {
      String name = "agent" + i;
      AgentState agent = new AgentState(0, 0, 100, 0);
      agentList.put(name, agent);
    }
    return agentList;
  }

  private static boolean checkIfGameOn(WorldState worldState) {
    return worldState.day() >=5 ? false: true;
  }
}
