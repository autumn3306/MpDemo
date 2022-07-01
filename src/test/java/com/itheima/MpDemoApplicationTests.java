package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
        user.setName("小");

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
     * 分页查询
     */
    @Test
    public void TestSelectPage() {
        Page<User> page = new Page(1, 3);
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

    /**
     * 分页查询
     */
    @Test
    public void testSelectMapsPage() {
        //Page不需要泛型
        Page<Map<String, Object>> page = new Page<>(1, 5);
        Page<Map<String, Object>> pageParam = userMapper.selectMapsPage(page, null);
        List<Map<String, Object>> records = pageParam.getRecords();
        records.forEach(System.out::println);
        System.out.println(pageParam.getCurrent());
        System.out.println(pageParam.getPages());
        System.out.println(pageParam.getSize());
        System.out.println(pageParam.getTotal());
        System.out.println(pageParam.hasNext());
        System.out.println(pageParam.hasPrevious());
    }

    /**
     * 根据id查询
     */
    @Test
    public void TestDeleteById() {
        int i = userMapper.deleteById(1542776412710785025L);
        System.out.println(i);
    }

    /**
     * 根据id批量查询
     */
    @Test
    public void TestdeleteByIds() {
        int i = userMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(i);
    }

    /**
     * 简单条件删除
     */
    @Test
    public void TestDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "sandy");
        map.put("age", 21);
        int i = userMapper.deleteByMap(map);
        System.out.println(i);
    }

    /**
     * 逻辑删除
     * 0代表不删除,1代表删除
     * 删除只是将deleted字段变成1
     * 查询方法也只能查询出deleted字段为0的记录
     */
    @Test
    public void TestLogicDelete() {
        int i = userMapper.deleteById(1542855785321254913L);
        System.out.println(i);
    }

    //mp复杂查询操作
    @Test
    public void testSelect() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //ge、gt、le、lt
        //queryWrapper.ge("age",21);

        //eq、ne  等于和不等于
        //queryWrapper.eq("name","Tom");

        //between、notBetween
        //queryWrapper.between("age",24,28);

        //like、notLike、likeLeft、likeRight
        //queryWrapper.like("name","张");

        //orderBy、orderByDesc、orderByAsc
        queryWrapper.orderByDesc("id");

        List<User> users = userMapper.selectList(queryWrapper);

        System.out.println(users);
    }

}
