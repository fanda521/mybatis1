package com.kp.annotations;

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
    public static void main(String[] args) throws Exception {

        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //创建sessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取session
        SqlSession sqlSession = sessionFactory.openSession();

        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
       /* User user = new User();
        user.setUserName("abc12333");
        user.setUserAge("232");
        user.setUserAddress("观澜33");
        mapper.saveUser(user);*/

       /* for(User u : mapper.getUsers()){
            System.out.println(u);
        }
*/
       /* for(User u : mapper.getUsers2(0,3)){
            System.out.println(u);
        }*/
        /*User u = new User();
        u.setUserName("%k%");
        for(User u1 : mapper.getUsers3(u,0,3)){
            System.out.println(u1);
        }*/

        /*User u = new User();
        u.setUserName("%%");
        for(User u1 : mapper.getUsers4(u,0,10)){
            System.out.println(u1);
        }*/

       /* User u3 = mapper.getUserById2(1);
        System.out.println(u3);*/

        User user = new User();
        user.setUserName("abc12333");
        user.setUserAge("232");
        user.setUserAddress("观澜33");
        mapper.saveUser2(user);


        //事务提交
        sqlSession.commit();

        sqlSession.close();
    }
}
