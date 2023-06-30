package com.aap.splitbill.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NubankTest {
    Nubank nubank = new Nubank();

    @Test
    void testGetUrl() {
        String result = nubank.getUrl();
        Assertions.assertEquals("https://nubank.com.br/pagar/customer/", result);
    }

    @Test
    void testGetStrategyName() {
        StrategyNameEnum result = nubank.getStrategyName();
        Assertions.assertEquals(StrategyNameEnum.NUBANK, result);
    }
}

