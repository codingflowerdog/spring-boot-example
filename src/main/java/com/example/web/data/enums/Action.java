package com.example.web.data.enums;

/**
 * 액션
 */
public enum Action {
    RETRIEVE("retrieve"),
    CREATE("create"),
    REQUEST("request"),
    CHANGE("change"),
    MODIFY("modify"),
    DELETE("delete"),
    LOGIN("login"),
    LOGOUT("logout");

    private final String action;

    /**
     * 액션 획득
     * @return 액션
     */
    public String getAction() {
        return this.action;
    }
    
    /**
     * 액션
     * @param action 액션
     */
    Action(final String action) {
        this.action = action;
    }
}
