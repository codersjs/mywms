import org.example.Main;
import org.example.o_mysql.service.OShelvesTypeService;
import org.example.utilAndCommonDemo.unit.IDcreate;
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

    @Test
    void Test02() {
        int n = 10;
        for (int i = 0;i<n;i++) {
            System.out.println(IDcreate.getLongId(10) instanceof Long);
        }
        for (int i = 0;i<n;i++) {
            System.out.println(IDcreate.getStringId(10));
        }
    }

}
