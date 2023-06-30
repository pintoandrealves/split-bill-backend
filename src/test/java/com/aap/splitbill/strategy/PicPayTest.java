package com.aap.splitbill.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PicPayTest {
    PicPay picPay = new PicPay();

    @Test
    void testGetUrl() {
        String result = picPay.getUrl();
        Assertions.assertEquals("https://picpay.com.br/pagar/customer/", result);
    }

    @Test
    void testGetStrategyName() {
        StrategyNameEnum result = picPay.getStrategyName();
        Assertions.assertEquals(StrategyNameEnum.PICPAY, result);
    }
}

