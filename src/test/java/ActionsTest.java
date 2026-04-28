import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import actions.ChopAction;
import actions.FeedCampfireAction;

public class ActionsTest {

    @Test
    void createChopActionTest0() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class, 
            () -> new ChopAction(null, -1)
        );
        String expectedMessage = "Action cost must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
      
    @Test
    void createChop ActionTest1() {
      assertEquals(new ChopAction("ChopAction", 10), new ChopAction("ChopAction"), 10);
    }

    @Test
    void createEatActionTest0() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class, 
            () -> new EatAction(null, -1)
        );
        String expectedMessage = "Action cost must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void createEatActionTest1() {
      assertEquals(new EatAction("EatAction", 10)).;
    }

    @Test
    void createFeedCampfireActionTest0() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class, 
            () -> new FeedCampfireAction(null, -1)
        );
        String expectedMessage = "Action cost must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void createFeedCampfireActionTest1() {
      assertEquals(new FeedCampfireAction("FeedCampfireAction", 10));
    }

    @Test
    void createFishActionTest0() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class, 
            () -> new FishAction(null, -1)
        );String expectedMessage = "Action cost must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void createFishActionTest1() {
      assertEquals(new FishAction("FishAction", 10), new FishAction("FishAction", 10));
    }
}
