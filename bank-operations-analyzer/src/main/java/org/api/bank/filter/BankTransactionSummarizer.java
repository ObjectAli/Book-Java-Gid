package org.api.bank.filter;

import org.api.bank.pojo.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer {
    double summarize (double accumulator, BankTransaction bankTransaction);
}