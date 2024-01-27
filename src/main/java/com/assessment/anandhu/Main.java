package com.assessment.anandhu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        RateLimiter rateLimiter = new RateLimiter(10000L,5L);

    }
}