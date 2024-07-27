package org.api.bank;


import org.api.bank.filter.BankTransactionIsFebruaryAndExpensive;
import org.api.bank.parser.BankStatementParser;
import org.api.bank.pojo.BankTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    public static final String pathResources = "bank-operations-analyzer/src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(pathResources + fileName);
        final List<String> lines = Files.readAllLines(path);

        System.out.println("Print all: ");
        final List<BankTransaction> bankTransactionsAll = bankStatementParser.parseLineFrom(lines);

        for (BankTransaction bankTransaction : bankTransactionsAll) {
            System.out.println(bankTransaction.toString());
        }

        System.out.println();
        System.out.println("Print analyze: ");
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactionsAll);
        collectSummary(bankStatementProcessor);

        System.out.println();
        System.out.println("Print by filter: ");
        final List<BankTransaction> bankTransactionsByFilter = bankStatementProcessor.findTransactions(new BankTransactionIsFebruaryAndExpensive());
        for (BankTransaction bankTransaction : bankTransactionsByFilter) {
            System.out.println(bankTransaction.toString());
        }
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}