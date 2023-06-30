package com.aap.splitbill.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    private StrategyFactory strategyFactory;
    public String getUrlBank(StrategyNameEnum strategyNameEnum){

        Strategy strategy =
                strategyFactory.findStrategy(strategyNameEnum);

        return strategy.getUrl();
    }
}