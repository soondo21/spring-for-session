package com.example.SessionState;

import java.time.Duration;
import java.util.Optional;

import org.springframework.session.Session;
import org.springframework.session.data.gemfire.expiration.SessionExpirationPolicy;

class MySessionExpirationPolicy implements SessionExpirationPolicy {

    public Optional<Duration> determineExpirationTimeout(Session session) {
        // return a java.time.Duration specifying the length of time until the Session should expire
        Duration output = Duration.ofSeconds(300);
        return Optional.ofNullable(output);
    }
}