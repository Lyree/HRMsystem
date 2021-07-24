package cn.edu.guet;

import cn.edu.guet.bean.EmpPower;
import cn.edu.guet.mapper.AccountMapper;
import cn.edu.guet.mapper.ApplicantMapper;
import cn.edu.guet.mapper.PowerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HrMsystemApplicationTests {
    @Autowired
    private ApplicantMapper applicantMapper;
    @Test
    void contextLoads() {
    }
    @Test
    void testpower() throws Exception {
        String tag="1,7";
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                applicantMapper.deleteApplicant(strs[i]);
            } catch (Exception e) {
            }
        }
        System.out.println("批量删除成功");
    }
}
