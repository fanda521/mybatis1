package com.kp;

import com.github.pagehelper.PageHelper;
import com.kp.dao.UserMapper;
import com.kp.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {

        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //创建sessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取session
        SqlSession sqlSession = sessionFactory.openSession();

        //执行UserMapper.xml文件中sql语句，使用命名空间+sqlid的方式去获取
        // 已经修改类mapper文件，该语句不能执行
        //User user = sqlSession.selectOne("com.kp.entity.User.selectUserById", new Integer(1));

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);

        System.out.println(user.getUserName());

        //获取集合对象
        PageHelper.startPage(1,2);
        List<User> users = mapper.selectAllUsers();
        for (User u : users) {
            System.out.println(u);
        }
        //System.out.println("-========================");
        //模糊查询
        users = mapper.selectUsersByName("%k%");
        for (User u : users) {
            System.out.println(u);
        }

        //插入操作
        User u = new User();
        u.setUserName("abc");
        u.setUserAge("30");
        u.setAddress("安防学院");
        //mapper.addUser(u);
        System.out.println(u);

        //修改id为9的记录
        User u2 = new User();
        u2.setUserName("abc1");
        u2.setUserAge("301");
        u2.setAddress("安防学院1");
        u2.setId(5);
        mapper.updateUser(u2);
        //删除
        //mapper.deleteUser(u2);
        //事务提交
        sqlSession.commit();

        sqlSession.close();
    }
}
