package org.api.bank;


import org.api.bank.parser.BankStatementCSVParser;

import java.io.IOException;

public class MainApplication {

    public static final String fileName = "transactions.csv";

    public static void main(String[] args) throws IOException {
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

        bankStatementAnalyzer.analyze(fileName, bankStatementCSVParser);
    }
}