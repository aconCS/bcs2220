import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import states.AgentState;
import states.WorldState;

public class WorldStateTest {

    @Test
    void initializeWorldTest0() {
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
    void initializeWorldTest1() {
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
    void changeTreeCountTest0() {
        WorldState worldState = new WorldState(100, 100, null, 100, 100);
        worldState.changeTreeCount(-200);
        assertEquals(-100, worldState.trees());
    }

    @Test
    void changeTreeCountTest1() {
        WorldState worldState = new WorldState(100, 100, null, 100, 100);
        worldState.changeTreeCount(200);
        assertEquals(300, worldState.trees());
    }

    @Test
    void changeFishCountTest0() {
        WorldState worldState = new WorldState(100, 100, null, 100, 100);
        worldState.changeFishCount(-200);
        assertEquals(-100, worldState.fish());
    }

    @Test
    void changeFishCountTest1() {
        WorldState worldState = new WorldState(100, 100, null, 100, 100);
        worldState.changeFishCount(200);
        assertEquals(300, worldState.fish());
    }

    @Test
    void changeDayTest0() {
        WorldState worldState = new WorldState(100, 100, null, 100, 100);
        worldState.changeDay();
        assertEquals(101, worldState.day());
    }

    @Test
    void changeAgentStateTest0() {
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
    void changeAgentStateTest1() {
        AgentState defaultAgentState = new AgentState(
            0, 
            0, 
            0, 
            0
        );
        AgentState agentState = new AgentState(
            0, 
            0, 
            100, 
            0
        );
        WorldState worldState = new WorldState(
            0, 
            0, 
            Map.of(
                "agent0", defaultAgentState
            ), 
            0, 
            0
        );
        assertEquals(agentState, worldState.changeAgentState("agent0", agentState).getAgentState("agent0"));
    }
}
