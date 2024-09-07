package org.api.busines.rules.engine.pojo;

import org.api.busines.rules.engine.interfaces.Action;
import org.api.busines.rules.engine.interfaces.Condition;
import org.api.busines.rules.engine.interfaces.Rule;

public class RuleBuilder {
    private Condition condition;

    private RuleBuilder(Condition condition) {
        this.condition = condition;
    }

    public static RuleBuilder when(Condition condition) {
        return new RuleBuilder(condition);
    }

    public Rule then(Action action) {
        return new DefaultRule(condition, action);
    }
}
