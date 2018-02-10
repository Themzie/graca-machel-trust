package com.gracamachel.trust.utils;

/**
 * Created by thembelani on 2/10/18.
 */

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
@Slf4j
public class RandomNumberGenerator {

    public static int generateIntWithSetLimit(int limit) {

        int randomNumber = new Random().nextInt(limit);
        log.debug(">>>>>>>>>>>>>>>>>>>>> Random Number Generate {}",randomNumber);
        return randomNumber;

    }
}