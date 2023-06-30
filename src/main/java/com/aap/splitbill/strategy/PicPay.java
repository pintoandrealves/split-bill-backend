package com.aap.splitbill.strategy;

import org.springframework.stereotype.Component;

@Component
public class PicPay implements Strategy{
    @Override
    public String getUrl() {
        return "https://picpay.com.br/pagar/customer/";
    }
    @Override
    public StrategyNameEnum getStrategyName() {
        return StrategyNameEnum.PICPAY;
    }
}