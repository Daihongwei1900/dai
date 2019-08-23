import com.dai.mybatis.basic.dao.IUserDao;
import com.dai.mybatis.basic.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class BasicTestDemo {
    @Test
    public void test1() throws Exception {
        InputStream is  = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(is);
        SqlSession session = factory.openSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> all = userDao.findAll();
        for (User user:all){
            System.out.println(user);
        }
        session.close();
        is.close();
    }


}
