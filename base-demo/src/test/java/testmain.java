import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.Main;
import org.example.o_mysql.domain.OFreight;
import org.example.o_mysql.service.OFreightService;
import org.example.o_mysql.service.OShelvesTypeService;
import org.example.utilAndCommonDemo.unit.IDcreate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = Main.class)
public class testmain {

    @Resource
    private OShelvesTypeService oShelvesTypeService;

    @Resource
    private OFreightService oFreightService;

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

    @Test
    void Test03() {
        for (int i = 0;i<10;i++) {
            System.out.println(IDcreate.getLongIdMIN6());
        }
    }

    @Test
    void Test04() {
        List<String> s = new ArrayList<>();
        s.add("1");
        s.add("2");
        s.add("3");
        s.add("4");
        s.add("5");
        List<String> rmall = new ArrayList<>();
        for (String t : s) {
            if (Integer.parseInt(t) % 2 == 0) {
                System.out.println(t);
            }else {
                rmall.add(t);
            }
        }
        s.removeAll(rmall);
        System.out.println(s);

    }

    @Test
    void Test05() {
        LambdaQueryWrapper  wrapper = new LambdaQueryWrapper<OFreight>()
                .gtSql(OFreight::getStocksMaxNum,"stocks_num+increase_num");
        // 分页
        Page<OFreight> page = new Page(0,20);

        // 获取分页
        List<OFreight> freightList = oFreightService.page(page,wrapper).getRecords();
        System.out.println(freightList);
    }



}
