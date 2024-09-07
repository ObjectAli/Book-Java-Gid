package org.api.busines.rules.engine.interfaces;

import org.api.busines.rules.engine.pojo.Facts;

@FunctionalInterface
public interface Action {
    void perform(Facts facts);
}
