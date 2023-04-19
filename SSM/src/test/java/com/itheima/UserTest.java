package com.itheima;

import com.itheima.dao.User;
import com.itheima.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;


@SpringBootTest
public class UserTest {
    @Autowired
    private UserMapper userMapper;

    // 使用注解@Select的方式进行插入
    @Test
    public void test1(){
        User user = new User(null, "张三", "zhangsan", 18);
        userMapper.insertUser1(user);
    }

    // 使用mapper.xml的映射文件进行插入
    @Test
    public void test2(){
        User user = new User(null, "李四", "lisi", 18);
        userMapper.insertUser2(user);
        System.out.println("id -> " + user.getId());
    }


    @Test
    void test3(){
        int res = userMapper.deleteById1(1);
        System.out.println("res -> " + res);
    }

    @Test
    void test4(){
        int res = userMapper.deleteById2(2);
        System.out.println("res -> " + res);
    }

    @Test
    void test5(){
        int res = userMapper.updateById1("赵八", 5);
        System.out.println("res -> " + res);
    }

    @Test
    void test6(){
        int res = userMapper.updateById1("赵八", 5);
        System.out.println("res -> " + res);
    }

    @Test
    void test7(){
        List<User> res = userMapper.getAllUsers1();
        for(User user : res){
            System.out.println("res -> " + user);
        }
    }

    @Test
    void test8(){
        List<User> res = userMapper.getAllUsers2();
        Iterator<User> iterator = res.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    void test9(){
        User res = userMapper.getUserById1(5);
        System.out.println("res -> " + res);
    }

    @Test
    void test10(){
        User res = userMapper.getUserById2(4);
        System.out.println("res -> " + res);
    }
}
