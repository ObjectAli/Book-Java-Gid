package org.api.busines.rules.engine;

import org.api.busines.rules.engine.pojo.Facts;

public class Main {
    public static void main(String[] args) {
        var env = new Facts();

        env.addFact("name", "Bob");


        var businessRuleEngine = new BusinessRuleEngine(env);

        businessRuleEngine.run();
    }
}