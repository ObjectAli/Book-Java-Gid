package org.api.busines.rules.engine;

public class SwitchExpressions {

    public static void main(String[] args) {
        var dealStage = Stage.LEAD;
        var amount = 10;

        var forecastedAmount = amount *
        switch (dealStage) {
            case LEAD -> 0.2;
            case EVALUATING -> 0.5;
            case INTERESTED -> 0.8;
            case CLOSED -> 1.0;
        };

        System.out.println(forecastedAmount);
    }
}
