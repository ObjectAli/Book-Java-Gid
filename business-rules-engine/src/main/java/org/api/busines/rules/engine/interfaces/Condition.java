package org.api.busines.rules.engine.interfaces;

import org.api.busines.rules.engine.pojo.Facts;

@FunctionalInterface
public interface Condition {

    boolean evaluate(Facts facts);
}
