import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import states.AgentState;

public class AgentStateTest {
    
    @Test
    void changeWoodCountTest0() {
        assertEquals(
            10, 
            new AgentState(
                0, 
                0, 
                0, 
                0
            ).changeWoodCount(10));
    }

    @Test
    void changeWoodCountTest1() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class, 
            () -> new AgentState(
                0, 
                0, 
                0, 
                0
            ).changeWoodCount(-10)
        );String expectedMessage = "Woodcount must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void changeFishCountTest0() {
        assertEquals(
            10, 
            new AgentState(
                0, 
                0, 
                0, 
                0
            ).changeFishCount(10));
    }

    @Test
    void changeFishCountTest1() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class, 
            () -> new AgentState(
                0, 
                0, 
                0, 
                0
            ).changeFishCount(-10)
        );String expectedMessage = "Fishcount must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void changeFullnessTest0() {
        assertEquals(
            10, 
            new AgentState(
                0, 
                0, 
                0, 
                0
            ).changeFullness(10));
    }

    @Test
    void changeFullnessest1() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class, 
            () -> new AgentState(
                0, 
                0, 
                0, 
                0
            ).changeFullness(-10)
        );String expectedMessage = "Fullness must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void changeCampfireTest0() {
        assertEquals(
            10, 
            new AgentState(
                0, 
                0, 
                0, 
                0
            ).changeCampfire(10));
    }

    @Test
    void changeCampfireTest1() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class, 
            () -> new AgentState(
                0, 
                0, 
                0, 
                0
            ).changeCampfire(-10)
        );String expectedMessage = "Campfire must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
