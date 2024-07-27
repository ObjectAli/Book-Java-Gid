package org.api.bank.filter;

import org.api.bank.pojo.BankTransaction;

/**
 * Когда класс BankStatementProcessor начал "пухнуть" от различных методов поиска по разным критериям
 * возникла необходимость создать универсальный функциональный интерфейс
 */
@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
