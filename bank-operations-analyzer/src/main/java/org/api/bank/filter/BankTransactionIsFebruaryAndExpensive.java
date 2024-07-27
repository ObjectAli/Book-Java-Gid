package org.api.bank.filter;

import org.api.bank.pojo.BankTransaction;

import java.time.Month;

public class BankTransactionIsFebruaryAndExpensive implements BankTransactionFilter {

    @Override
    public boolean test(final BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1_000;
    }
}
