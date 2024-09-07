package org.api.busines.rules.engine;

import org.api.busines.rules.engine.pojo.Facts;
import org.api.busines.rules.engine.interfaces.Rule;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {

    private final List<Rule> rules;
    private final Facts facts;

    public BusinessRuleEngine(final Facts facts){
        this.facts = facts;
        this.rules = new ArrayList<>();
    }

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public void run() {
        this.rules.forEach(rule -> rule.perform(facts));
    }

    public int count() {
        return this.rules.size();
    }
}
