import org.api.busines.rules.engine.BusinessRuleEngine;
import org.api.busines.rules.engine.pojo.Facts;
import org.api.busines.rules.engine.interfaces.Rule;
import org.api.busines.rules.engine.pojo.RuleBuilder;
import org.junit.Test;


import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

public class BusinessRuleEngineTest {

    @Test
    public void shouldHaveNoRulesInitially() {
        final Facts mockFacts = mock(Facts.class);

        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

        assertEquals(0, businessRuleEngine.count());
    }

    @Test
    public void shouldAddOneAction() {
        final Facts mockFacts = mock(Facts.class);

        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

        Rule ruleSendEmailToSalesWhenCEO = RuleBuilder
                .when(facts -> "CEO".equals(facts.getFact("jobTitle")))
                        .then(facts -> {
                            var name = facts.getFact("name");
                            System.out.println("Send email: <sales@company.com> to relevant customer " + name);
                        });
        businessRuleEngine.addRule(ruleSendEmailToSalesWhenCEO);

        assertEquals(1, businessRuleEngine.count());
    }

    @Test
    public void shouldExecuteOneEngine() {
        final BusinessRuleEngine businessRuleEngine = mock(BusinessRuleEngine.class);
        businessRuleEngine.run();

        verify(businessRuleEngine).run();
    }
}