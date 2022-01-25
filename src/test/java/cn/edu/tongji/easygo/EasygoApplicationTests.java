package cn.edu.tongji.easygo;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class EasygoApplicationTests {

    @Resource
    StringEncryptor stringEncryptor;

    @Test
    void contextLoads() {
        String res = stringEncryptor.encrypt("");
        System.out.println(res);
    }
}
