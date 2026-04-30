import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import actions.*;

public class ActionsTest {

    @Test
    void createChopActionTestNegativeCost() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class,
            () -> new ChopAction(null, -1)
        );
        String expectedMessage = "Action cost must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void createChopActionTest() {
      assertEquals(new ChopAction("ChopAction", 10), new ChopAction("ChopAction", 10));
    }

    @Test
    void createEatActionTestNegativeCost() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class,
            () -> new EatAction(null, -1)
        );
        String expectedMessage = "Action cost must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void createEatActionTest() {
      assertEquals(new EatAction("EatAction", 10), new EatAction("EatAction", 10));
    }

    @Test
    void createFeedCampfireActionTestNegativeCost() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class,
            () -> new FeedCampfireAction(null, -1)
        );
        String expectedMessage = "Action cost must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void createFeedCampfireActionTest() {
      assertEquals(new FeedCampfireAction("FeedCampfireAction", 10), new FeedCampfireAction("FeedCampfireAction", 10));
    }

    @Test
    void createFishActionTestNegativeCost() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class,
            () -> new FishAction(null, -1)
        );String expectedMessage = "Action cost must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void createFishActionTest() {
      assertEquals(new FishAction("FishAction", 10), new FishAction("FishAction", 10));
    }
}
