import com.dai.mybatis.result.dao.IUserDao;
import com.dai.mybatis.result.domain.QueryVo;
import com.dai.mybatis.result.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class ResultTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        in= Resources.getResourceAsStream("SqlMapresult.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        sqlSession =build.openSession();
         userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void after() throws IOException {
       sqlSession.commit();
       sqlSession.close();
       in.close();
    }    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }

    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUserName("modify User property");
        user.setUserAddress("北京市顺义区");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
        System.out.println("保存操作之前："+user);
        //5.执行保存方法
        userDao.saveUser(user);

        System.out.println("保存操作之后："+user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setUserId(50);
        user.setUserName("mybastis update user");
        user.setUserAddress("北京市顺义区");
        user.setUserSex("女");
        user.setUserBirthday(new Date());

        //5.执行保存方法
        userDao.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete(){
        //5.执行删除方法
        userDao.deleteUser(48);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testFindOne(){
        //5.执行查询一个方法
        User  user = userDao.findById(1);
        System.out.println(user);
    }

    /**
     * 测试模糊查询操作
     */
    @Test
    public void testFindByName(){
        //5.执行查询一个方法
        List<User> users = userDao.findByName("%王%");
//        List<User> users = userDao.findByName("王");
        for(User user : users){
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录条数
     */
    @Test
    public void testFindTotal(){
        //5.执行查询一个方法
        int count = userDao.findTotal();
        System.out.println(count);
    }


    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public void testFindByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUserName("%王%");
        vo.setUser(user);
        //5.执行查询一个方法
        List<User> users = userDao.findUserByVo(vo);
        for(User u : users){
            System.out.println(u);
        }
    }
}
