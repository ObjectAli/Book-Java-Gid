import org.api.busines.rules.engine.Inspector;
import org.api.busines.rules.engine.interfaces.ConditionalAction;
import org.api.busines.rules.engine.pojo.Facts;
import org.api.busines.rules.engine.pojo.Report;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InspectorTest {

    @Test
    public void inspectOneConditionEvaluatesTrue() {

        final Facts facts = new Facts();
        facts.addFact("jobTitle", "CEO");
        final ConditionalAction conditionalAction = new JobTitleCondition();
        final Inspector inspector = new Inspector(conditionalAction);

        final List<Report> diagnosisList = inspector.inspect(facts);

        assertEquals(1, diagnosisList.size());
    }

    private static class JobTitleCondition implements ConditionalAction {

        @Override
        public void perform(Facts facts) {
        }

        @Override
        public boolean evaluate(Facts facts) {
            return "CEO".equals(facts.getFact("jobTitle"));
        }
    }
}
