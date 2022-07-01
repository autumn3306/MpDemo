package com.itheima;

import com.itheima.entity.User;
import com.itheima.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MpDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public  void TestFindAll(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public  void TestAdd(){
      User user = new User(null,"小李",25,"1234@163.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

}
