package com.assessment.anandhu;

public class RateLimiterMain {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(10000L,5L);

        for (int i = 0; i < 10; i++) {
            boolean allowed = rateLimiter.isAllowed("192.168.1.1");
            System.out.println("Request " + i + " allowed: " + allowed);
            Thread.sleep(1000);
        }

    }
}