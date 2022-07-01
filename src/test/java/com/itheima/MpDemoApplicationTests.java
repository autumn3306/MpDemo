package com.itheima;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.entity.User;
import com.itheima.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 测试乐观锁
     */
    @Test
    public void TestOptimisticLocker() {
        //先查询再修改,可以发现数据库version字段已经更改
        User user = userMapper.selectById(1542797716088336386L);
        user.setName("小房");
        int update = userMapper.updateById(user);
        System.out.println(update);
    }

    /**
     * 通过多个id批量查询
     */
    @Test
    public void TestSelectByIdList() {
        //Batch 一批,批量
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        System.out.println(users);
    }

    /**
     * 通过map封装条件查询
     * 注意：map中的key对应数据库中的列名。如：数据库user_id，实体类是userId，这时map的key需要填写user_id
     */
    @Test
    public void TestSelectByMap() {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", "Jack");
        columnMap.put("age", 20);
        List<User> users = userMapper.selectByMap(columnMap);
        System.out.println(users);
    }
    /**
     *分页查询
     */
    @Test
    public void TestSelectPage() {
        Page<User> page = new Page(1,3);
        Page<User> userPage = userMapper.selectPage(page, null);
        //返回对象得到分页所有数据
        long pages = userPage.getPages(); //总页数
        long current = userPage.getCurrent(); //当前页
        List<User> records = userPage.getRecords(); //查询数据集合
        long total = userPage.getTotal(); //总记录数
        boolean hasNext = userPage.hasNext();  //下一页
        boolean hasPrevious = userPage.hasPrevious(); //上一页

        System.out.println(pages);
        System.out.println(current);
        System.out.println(records);
        System.out.println(total);
        System.out.println(hasNext);
        System.out.println(hasPrevious);
    }

}
