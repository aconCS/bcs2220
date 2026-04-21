package actions;

import java.util.List;

public final class ActionPool {
    public static final List<Action> getAllActions() {
        return List.of(
            new ChopAction("chop", 3),
            new EatAction("eat", 1),
            new FeedCampfireAction("feed campfire", 1),
            new FishAction("fish", 2)
        );
    }
}
