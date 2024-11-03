import org.example.Main;
import org.example.o_mysql.service.OShelvesTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = Main.class)
public class testmain {

    @Resource
    private OShelvesTypeService oShelvesTypeService;

    @Test
    void Test01() {
        System.out.println(oShelvesTypeService.getById(1852694143276056577L));
    }

}
