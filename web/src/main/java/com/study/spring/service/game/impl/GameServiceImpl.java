package com.study.spring.service.game.impl;

import com.study.spring.service.game.Game;
import com.study.spring.service.game.GameService;
import com.study.spring.service.message_generator.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    private final Game game;
    private final MessageGenerator messageGenerator;

    public GameServiceImpl(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    @PostConstruct
    public void init(){
        log.info("number = {}", game.getNumber());
        log.info("mainMessage = {}", messageGenerator.getMainMessage());
    }

    @Override
    public boolean isGameOver() {
        return game.isGameWon() || game.isGameLost();
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
