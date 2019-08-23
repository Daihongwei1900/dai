import com.dai.TransactionManager.domain.Account;
import com.dai.TransactionManager.factory.BeanFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean3.xml")
public class TxTest {
    @Autowired
    private BeanFactory beanFactory;
    @Test
    public void test1(){
        List<Account> allAccount = beanFactory.getAccountService().findAllAccount();
        System.out.println(allAccount);
        beanFactory.getAccountService().transfer("liqiang","张亚见", (float) 500);
    }
}
