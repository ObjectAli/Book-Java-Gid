package org.api.bank;


import org.api.bank.filter.BankTransactionFilter;
import org.api.bank.filter.BankTransactionSummarizer;
import org.api.bank.pojo.BankTransaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    /**
     * Вычисление текущего баланса
     */
    public double calculateTotalAmount() {
        return summarizeTransactions((acc, bankTransaction) -> acc + bankTransaction.getAmount());
    }

    /**
     * Вычисление баланса по месяцам
     */
    public double calculateTotalInMonth(final Month month) {
//        Данный код из главы 3
        return summarizeTransactions((acc, bankTransaction) ->
                bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount() : acc);

//        Вместо этого из главы 2 (в остальных методах аналогично)
//        double total = 0d;
//
//        for (final BankTransaction bankTransaction : bankTransactions) {
//            if (bankTransaction.getDate().getMonth() == month) {
//                total += bankTransaction.getAmount();
//            }
//        }
//        return total;
    }

    /**
     * Вычисление баланса по категориям
     */
    public double calculateTotalForCategory(final String category) {
        return summarizeTransactions((acc, bankTransaction) ->
                bankTransaction.getDescription().equals(category) ? acc + bankTransaction.getAmount() : acc);
    }

    /**
     * Поиск транзакций на сумму больше заданной
     */
    @Deprecated
    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
//        Данный код из главы 3
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);

//        Вместо этого из главы 2 (в остальных методах аналогично)
//        final List<BankTransaction> result = new ArrayList<>();
//        for (final BankTransaction bankTransaction : bankTransactions) {
//            if (bankTransaction.getAmount() >= amount) {
//                result.add(bankTransaction);
//            }
//        }
//        return result;
    }

    /**
     * Универсальный метод поиска транзакций, который пришёл на замену методу findTransactionsGreaterThanEqual(int amount)
     */
    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    /**
     * Универсальный метод суммирования значений транзакций
     */
    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }
}
