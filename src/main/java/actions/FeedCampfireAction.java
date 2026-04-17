package actions;

public final record FeedCampfireAction (String action, int cost, String effect, String[] preReq) implements Action {}
