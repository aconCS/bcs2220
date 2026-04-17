package actions;

public final record FishAction (String action, int cost, String effect, String[] preReq) implements Action {}
