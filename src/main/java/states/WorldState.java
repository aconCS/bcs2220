package states;
import java.util.HashMap;
import java.util.Map;

public final record WorldState(int trees, int fish, Map<String, AgentState> agents, int day, int maxDailyCost) {

    public AgentState getAgentState(String agentName) { return agents.get(agentName); }

    public WorldState changeDay() { return new WorldState(trees, fish, agents, day + 1, maxDailyCost); }
    public WorldState changeTreeCount(int newTreeCount) { return new WorldState(trees + newTreeCount, fish, agents, day, maxDailyCost); }
    public WorldState changeFishCount(int newFishCount) { return new WorldState(trees, fish + newFishCount, agents, day, maxDailyCost); }
    public WorldState changeAgentState(String agentName, AgentState newAgentState) {
        Map<String, AgentState> newAgents = new HashMap<>(agents);
        if (!newAgents.containsKey(agentName)) {
            throw new IllegalStateException("Cannot change non-existent Agent's state");
        }
        newAgents.put(agentName, newAgentState);
        return new WorldState(trees, fish, newAgents, day, maxDailyCost);
    }

    public Map<String, Object> getState() {
        return Map.of(
            "trees", trees,
            "fish", fish,
            "agents", agents,
            "day", day,
            "maxDailyCost", maxDailyCost
        );
    }
}
