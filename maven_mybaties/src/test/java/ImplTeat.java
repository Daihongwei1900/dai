import com.dai.mybatis.impl.dao.IUserDao;
import com.dai.mybatis.impl.dao.UserDaoImpl;
import com.dai.mybatis.impl.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class ImplTeat {
    @Test
    public void test() throws Exception {
        InputStream is =  Resources.getResourceAsStream("SqlConfig_impl.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        IUserDao userDao =   new UserDaoImpl(build);
        List<User> all = userDao.findAll();
        System.out.println(all);

    }
}
