package com.study.spring.service.number_generator.impl;

import com.study.spring.annotations.MaxNumber;
import com.study.spring.annotations.MinNumber;
import com.study.spring.service.number_generator.NumberGenerator;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator {

    @Getter(AccessLevel.NONE)
    private final Random random = new Random();

    private final int maxNumber;

    private final int minNumber;

    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    @Override
    public int next() {
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }


}
