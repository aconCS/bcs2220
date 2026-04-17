import java.util.HashMap;
import java.util.Map;

public final record WorldState(int trees, int fish, Map<String, AgentState> agents) {
    public AgentState getAgentState(String agentName) { return agents.get(agentName); }
    public WorldState changeTreeCount(int newTreeCount) { return new WorldState(newTreeCount, fish, agents); }
    public WorldState changeFishCount(int newFishCount) { return new WorldState(trees, newFishCount, agents); }
    public WorldState changeAgentState(String agentName, AgentState newAgentState) {
        Map<String, AgentState> newAgents = new HashMap<>(agents);
        newAgents.put(agentName, newAgentState);
        return new WorldState(trees, fish, newAgents);
    }
}
