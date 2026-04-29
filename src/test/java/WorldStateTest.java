import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import states.AgentState;
import states.WorldState;

public class WorldStateTest {

    @Test
    void initializeWorldTest() {
        Map<String, Object> expected = Map.of(
            "trees", 100,
            "fish", 100,
            "agents", null,
            "day", 100,
            "maxCost", 100
        );
        assertEquals(expected, new WorldState(100, 100, null, 100, 100));
    }

    @Test
    // TODO: change logic to reflect negative trees
    void initializeWorldTestNegativeTrees() {
        Map<String, Object> expected = Map.of(
            "trees", -100,
            "fish", 7,
            "agents", List.of(new AgentState(0, 0, 0, 0)),
            "day", 100,
            "maxCost", 100
        );
        assertEquals(
            expected,
            new WorldState(
                -100,
                7,
                Map.of(
                    "agent1",
                    new AgentState(0, 0, 0, 0)
                ),
                100,
                100
            ));
    }

    @Test
    void changeTreeCountTestNegative() {
        WorldState worldState = new WorldState(100, 100, null, 100, 100);
        worldState.changeTreeCount(-200);
        assertEquals(-100, worldState.trees());
    }

    @Test
    void changeTreeCountTestPositive() {
        WorldState worldState = new WorldState(100, 100, null, 100, 100);
        worldState.changeTreeCount(200);
        assertEquals(300, worldState.trees());
    }

    @Test
    void changeFishCountTestNegative() {
        WorldState worldState = new WorldState(100, 100, null, 100, 100);
        worldState.changeFishCount(-200);
        assertEquals(-100, worldState.fish());
    }

    @Test
    void changeFishCountTestPositive() {
        WorldState worldState = new WorldState(100, 100, null, 100, 100);
        worldState.changeFishCount(200);
        assertEquals(300, worldState.fish());
    }

    @Test
    void changeDayTest() {
        WorldState worldState = new WorldState(100, 100, null, 100, 100);
        worldState.changeDay();
        assertEquals(101, worldState.day());
    }

    @Test
    void changeAgentStateTestNewAgent() {
        AgentState agentState = new AgentState(
            0,
            0,
            0,
            0
        );
        WorldState worldState = new WorldState(
            0,
            0,
            null,
            0,
            0
        );
        assertEquals(agentState, worldState.changeAgentState("agent0", agentState).getAgentState("agent0"));
    }

    @Test
    void changeAgentStateTest() {
        AgentState oldAgentState = new AgentState(
            0,
            0,
            0,
            0
        );
        AgentState newAgentState = new AgentState(
            0,
            0,
            100,
            0
        );
        WorldState worldState = new WorldState(
            0,
            0,
            Map.of(
                "agent0", oldAgentState
            ),
            0,
            0
        );
        assertEquals(oldAgentState, worldState.changeAgentState("agent0", newAgentState).getAgentState("agent0"));
    }
}
