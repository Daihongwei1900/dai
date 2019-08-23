package mode;

import com.mode.dao.IUserDao;
import com.mode.domain.QueryVo;
import com.mode.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class UserTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
         in = Resources.getResourceAsStream("modeConfig.xml");
        sqlSession = new SqlSessionFactoryBuilder().build(in).openSession();
         userDao = sqlSession.getMapper(IUserDao.class);


    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //提交事务
        // sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println("-----每个用户的信息------");
            System.out.println(user);
        }
    }
    @Test
    public void testFindByCondition(){
        QueryVo queryVo = new QueryVo();
        queryVo.setSex("男");
        queryVo.setUsername("王");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(41);
        list.add(42);
        list.add(43);
        queryVo.setIds(list);
        List<User> byConditon = userDao.findByCondition(queryVo);
        System.out.println(byConditon);
    }

    @Test
    public void testFindByArray(){
        QueryVo queryVo = new QueryVo();
        queryVo.setSex("男");
        queryVo.setUsername("王");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(41);
        list.add(42);
        list.add(43);
        queryVo.setIds(list);
        List<User> byConditon = userDao.findByArray(queryVo);
        System.out.println(byConditon);
    }


}
