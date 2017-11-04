import com.alibaba.fastjson.JSON;
import com.bicycle.dao.entity.ModuleBicycle;
import com.bicycle.dao.entity.ModuleUser;
import com.bicycle.service.BicycleService;
import com.bicycle.service.UserService;
import com.bicycle.service.impl.BicycleServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
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

    @Test
    public void testBicycleCount() {
        BicycleService bicycleService = new BicycleServiceImpl();

        /*Map<String, Integer> map = bicycleService.getBicycleCount();

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Type" + entry.getKey() + ", " + "Count" + entry.getValue());
        }*/
        List<ModuleBicycle> list = bicycleService.getAllBicycle();
        System.out.println(list);
    }
}