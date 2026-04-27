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
    void createChopActionTest0() {
        Exception exception = assertThrowsExactly(
            IllegalStateException.class, 
            () -> new ChopAction(null, -1)
        );String expectedMessage = "Action cost must be at least zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
