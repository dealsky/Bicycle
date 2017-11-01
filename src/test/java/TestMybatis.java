import com.alibaba.fastjson.JSON;
import com.bicycle.dao.entity.ModuleUser;
import com.bicycle.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMybatis {
    private static Logger logger  = Logger.getLogger(String.valueOf(TestMybatis.class));

    @Resource
    private UserService userService = null;

    @Test
    public void test1() {
        ModuleUser moduleUser = userService.getModuleUserById(1);
        System.out.println(moduleUser.getUsername());
        logger.info("值：" + moduleUser.getUsername());
        logger.info(JSON.toJSONString(moduleUser));
    }

    @Test
    public void testDate() throws ParseException {
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStringToParse = new Date().toString();
        System.out.println(dateStringToParse);
        Date date = bartDateFormat.parse(dateStringToParse);
        System.out.println(date);
    }
}