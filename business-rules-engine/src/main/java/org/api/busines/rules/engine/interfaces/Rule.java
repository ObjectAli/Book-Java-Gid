package org.api.busines.rules.engine.interfaces;

import org.api.busines.rules.engine.interfaces.Action;
import org.api.busines.rules.engine.interfaces.Condition;
import org.api.busines.rules.engine.pojo.Facts;

@FunctionalInterface
public interface Rule {
    void perform(Facts facts);
}