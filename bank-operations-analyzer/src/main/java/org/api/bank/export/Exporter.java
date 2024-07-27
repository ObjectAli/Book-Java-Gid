package org.api.bank.export;

public interface Exporter {
    String export(SummaryStatistics summaryStatistics);
}
