package com.hackthon.hackthon;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionManager {
    private final Map<String, String> activeUsers = new ConcurrentHashMap<>(); // Map to store active sessions

    public void addSession(String sessionId, String username) {
        activeUsers.put(sessionId, username);
    }

    public void removeSession(String sessionId) {
        activeUsers.remove(sessionId);
    }

    public int getActiveUserCount() {
        return activeUsers.size();
    }
}
