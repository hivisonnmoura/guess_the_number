package com.study.spring.controller;


import com.study.spring.service.game.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import static com.study.spring.util.AttributesNames.*;
import static com.study.spring.util.GameMappings.REDIRECT_PLAY;
import static com.study.spring.util.ViewNames.*;

@Slf4j
@Controller
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(PLAY)
    public String play(Model model) {
        model.addAttribute(MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(RESULT_MESSAGE, gameService.getResultMessage());
        log.info("model = {}", model);

        if(gameService.isGameOver())
            return GAME_OVER;

        return PLAY;

    }

    @PostMapping(PLAY)
    public String processMessage(@RequestParam int guess) {
        log.info("guess = {}", guess);
        gameService.checkGuess(guess);
        return REDIRECT_PLAY;



    }
}
