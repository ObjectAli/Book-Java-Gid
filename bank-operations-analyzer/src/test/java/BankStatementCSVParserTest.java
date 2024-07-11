import org.api.bank.parser.BankStatementCSVParser;
import org.api.bank.parser.BankStatementParser;
import org.api.bank.pojo.BankTransaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class BankStatementCSVParserTest {

    private final BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        final String line = "30-01-2017,-50,Tesco";

        final BankTransaction result = statementParser.parseFrom(line);
        final double tolerance = 0.0d;

        Assert.assertEquals(result.getDate(), LocalDate.of(2017, 1, 30));
        Assert.assertEquals(result.getAmount(), -50d, tolerance);
        Assert.assertEquals(result.getDescription(), "Tesco");

    }
}
