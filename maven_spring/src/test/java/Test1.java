import com.dai.spring.StudentServiceImpl;
import com.dai.spring.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Bean.xml")
public class Test1 {
    @Autowired
    private StudentServiceImpl studentService;

    @Test
    public void test() throws SQLException {
        List<Teacher> aLl = studentService.findALl();
        System.out.println(aLl);
    }
}
