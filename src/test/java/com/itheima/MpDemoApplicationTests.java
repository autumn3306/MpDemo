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

    /**
     * 查询所有
     */
    @Test
    public void TestFindAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    /**
     * 添加一条记录
     */
    @Test
    public void TestAdd() {
        User user = new User();
        user.setAge(25);
        user.setEmail("1234@163.com");
        user.setName("小明");

        int insert = userMapper.insert(user);
        System.out.println(insert);  //受影响行数
    }

    /**
     * 更新一条记录
     */
    @Test
    public void TestUpdate() {
        User user = new User();
        user.setId(1542785490560405505L);
        user.setAge(25);
        user.setEmail("1234@163.com");
        user.setName("小明");
        int update = userMapper.updateById(user);
        System.out.println(update);
    }

}
