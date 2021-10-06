package com.kp.many2many;

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

        //执行UserMapper.xml文件中sql语句，使用命名空间+sqlid的方式去获取
        // 已经修改类mapper文件，该语句不能执行
        //User user = sqlSession.selectOne("com.kp.entity.User.selectUserById", new Integer(1));

        Many2ManyMapper mapper = sqlSession.getMapper(Many2ManyMapper.class);

        //构建模拟数据
        Privelege priAdd = new Privelege();
        priAdd.setPname("add");

        Privelege priDel = new Privelege();
        priDel.setPname("delete");

        Groups group1 = new Groups();
        group1.setGname("boss");

        group1.getPris().add(priAdd);
        group1.getPris().add(priDel);

        mapper.saveGroups(group1);
        for(Privelege p : group1.getPris()){
            mapper.savePrivelege(p);
            mapper.savePriRelGroups(group1.getGid(),p.getPid());
        }

        //事务提交
        sqlSession.commit();

        sqlSession.close();
    }
}
