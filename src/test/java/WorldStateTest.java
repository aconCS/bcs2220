import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import states.WorldState;

public class WorldStateTest {

    @Test
    void initializeWorldTest1() {
        String[][] expected = {
            { "trees", "10" },
            { "fish", "30" },
            { "fullness", "0" },
            { "campfire", "24" },
        };
        assertArrayEquals(expected, WorldState.initializeWorld(10, 30, 0, 24));
    }

    @Test
    void initializeWorldTest2() {
        String[][] expected = {
            { "trees", "100" },
            { "fish", "300" },
            { "fullness", "7" },
            { "campfire", "0" },
        };
        assertArrayEquals(expected, WorldState.initializeWorld(100, 300, 7, 0));
    }
}
