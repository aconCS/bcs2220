import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import states.AgentState;

public class AgentStateTest {

    @Test
    void changeWoodCountTestPositive() {
        assertEquals(
            10,
            new AgentState(
                0,
                0,
                0,
                0
            ).changeWoodCount(10).wood());
    }

    @Test
    void changeWoodCountTestNegative() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class,
            () -> new AgentState(
                0,
                0,
                0,
                0
            ).changeWoodCount(-10).wood()
        );
        String expectedMessage = "Woodcount must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void changeFishCountTestPositive() {
        assertEquals(
            10,
            new AgentState(
                0,
                0,
                0,
                0
            ).changeFishCount(10).fish());
    }

    @Test
    void changeFishCountTestNegative() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class,
            () -> new AgentState(
                0,
                0,
                0,
                0
            ).changeFishCount(-10).fish()
        );
        String expectedMessage = "Fishcount must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void changeFullnessTestPositive() {
        assertEquals(
            10,
            new AgentState(
                0,
                0,
                0,
                0
            ).changeFullness(10).fullness());
    }

    @Test
    void changeFullnessestNegative() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class,
            () -> new AgentState(
                0,
                0,
                0,
                0
            ).changeFullness(-10).fullness()
        );
        String expectedMessage = "Fullness must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void changeCampfireTestPositive() {
        assertEquals(
            10,
            new AgentState(
                0,
                0,
                0,
                0
            ).changeCampfire(10).campfire());
    }

    @Test
    void changeCampfireTestNegative() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class,
            () -> new AgentState(
                0,
                0,
                0,
                0
            ).changeCampfire(-10).campfire()
        );
        String expectedMessage = "Campfire must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
