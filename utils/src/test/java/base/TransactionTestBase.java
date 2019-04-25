package base;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import sevenkey.open.utils.ApplicationLoader;

/**
 * @author weijianyu
 */
@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationLoader.class)
public class TransactionTestBase {
}
