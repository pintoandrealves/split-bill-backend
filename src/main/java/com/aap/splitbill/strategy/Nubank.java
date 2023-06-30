package com.aap.splitbill.strategy;

import org.springframework.stereotype.Component;

@Component
public class Nubank implements Strategy{
    @Override
    public String getUrl() {
        return "https://nubank.com.br/pagar/customer/";
    }
    @Override
    public StrategyNameEnum getStrategyName() {
        return StrategyNameEnum.NUBANK;
    }
}
