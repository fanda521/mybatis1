package com.kp.ono2one;

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

        One2OneMapper mapper = sqlSession.getMapper(One2OneMapper.class);
        List<Person> persons = mapper.selectPersonById();
        for(Person p : persons){
            System.out.println(p);
        }

       /* //保存对象  保存person对象  保存 idcard对象
        Person p = new Person("x3");
        IdCard card = new IdCard("999");
        p.setIdCard(card);*/

        //将对象保存到数据库中

        //事务提交
        sqlSession.commit();

        sqlSession.close();
    }
}
