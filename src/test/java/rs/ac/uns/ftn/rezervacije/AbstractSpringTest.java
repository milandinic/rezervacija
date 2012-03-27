package rs.ac.uns.ftn.rezervacije;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class must be extended to spring enable it.
 * 
 * @author mdinic
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/applicationContext.xml" })
// @TransactionConfiguration(transactionManager = "transactionManager",
// defaultRollback = true)
@Transactional
public abstract class AbstractSpringTest extends AbstractTransactionalJUnit4SpringContextTests {

}
