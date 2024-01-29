package com.assessment.anandhu;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class RateLimiter {

    private final Map<String, LinkedList<Long>> requestedTimes;
    private final Long timeWindow;

    private final Long rateLimit;

    public RateLimiter(Long timeWindow, Long rateLimit) {
        this.requestedTimes = new LinkedHashMap<>();
        this.timeWindow = timeWindow;
        this.rateLimit = rateLimit;
    }

    public synchronized boolean isAllowed(String ipAddress) {
        Long currentMillSec = System.currentTimeMillis();
        LinkedList<Long> times = requestedTimes.getOrDefault(ipAddress, new LinkedList<>());

        while (!times.isEmpty() && currentMillSec - times.peek() > timeWindow) {
            times.poll();
        }
        boolean isAllow = times.size() < rateLimit;

        if (isAllow) {
            times.offer(currentMillSec);
        }

        return isAllow;
    }

}
