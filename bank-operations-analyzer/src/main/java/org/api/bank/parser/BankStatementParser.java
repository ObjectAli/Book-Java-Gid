package org.api.bank.parser;


import org.api.bank.pojo.BankTransaction;

import java.util.List;

public interface BankStatementParser {

    BankTransaction parseFrom(String line);

    List<BankTransaction> parseLineFrom(List<String> lines);
}