package com.study.spring.learnprogramming.service;

public interface GameService {

    boolean isGameOver();
    String getMainMessage();
    String getResultMessage();
    void checkGuess(int guess);
    void reset();
}