package actions;

public final record EatAction (String action, int cost, String effect, String[] preReq) implements Action {}
