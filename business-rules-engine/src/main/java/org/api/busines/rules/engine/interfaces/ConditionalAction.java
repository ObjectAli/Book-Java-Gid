package org.api.busines.rules.engine.interfaces;

import org.api.busines.rules.engine.pojo.Facts;

public interface ConditionalAction {
    void perform(Facts facts);
    boolean evaluate(Facts facts);

}
