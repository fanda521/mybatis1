package com.kp.cache;

import com.kp.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

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

       /* // 获取mapper对象
        UserMapper3 mapper = sqlSession.getMapper(UserMapper3.class);

        //执行2次查询
        User user = mapper.selectUserById(1);
        System.out.println(user);
        System.out.println("----------------------");
        sqlSession.clearCache();
        User user2 = mapper.selectUserById(1);
        System.out.println(user2);

        //事务提交
        sqlSession.commit();*/

       /* //获取2个maper对象
        UserMapper3 mapper1 = sqlSession.getMapper(UserMapper3.class);
        UserMapper3 mapper2 = sqlSession.getMapper(UserMapper3.class);
        System.out.println(mapper1.equals(mapper2));
        //执行第一次查询
        User u1 = mapper1.selectUserById(1);
        System.out.println(u1);
        sqlSession.commit();
        //执行第2次查询
        User u2 = mapper2.selectUserById(1);
        System.out.println(u2);
        sqlSession.commit();

        //sqlSession 是同一个情况，并且sqlsession是没有关闭
        sqlSession.close();*/


       //sqlSession不同，一个sqlSession操作完毕后直接关闭，看是否还能读取缓存不
        SqlSession sqlSession1 = sessionFactory.openSession();

        UserMapper3 mapper1 = sqlSession1.getMapper(UserMapper3.class);
        //执行第一次查询
        User u1 = mapper1.selectUserById(1);
        System.out.println(u1);
        sqlSession1.commit();
        sqlSession1.close();


        SqlSession sqlSession2 = sessionFactory.openSession();
        UserMapper3 mapper2 = sqlSession.getMapper(UserMapper3.class);
        //sqlSession2.clearCache();
        User u2 = mapper2.selectUserById(1);
        System.out.println(u2);
        sqlSession2.commit();
        sqlSession2.close();

    }
}
