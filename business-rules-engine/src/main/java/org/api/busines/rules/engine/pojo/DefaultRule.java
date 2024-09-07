package org.api.busines.rules.engine.pojo;

import org.api.busines.rules.engine.interfaces.Action;
import org.api.busines.rules.engine.interfaces.Condition;
import org.api.busines.rules.engine.interfaces.Rule;
import org.api.busines.rules.engine.pojo.Facts;

public class DefaultRule implements Rule {

    private Condition condition;
    private Action action;


    public DefaultRule(Condition condition, Action action) {
        this.condition = condition;
        this.action = action;
    }

    @Override
    public void perform(final Facts facts) {
        if(condition.evaluate(facts)) {
            action.perform(facts);
        }
    }
}
