package com.kp.many2one;

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

        Many2OneMapper mapper = sqlSession.getMapper(Many2OneMapper.class);
        List<Dept> depts = mapper.selectDepts();
        for(Dept d : depts){
            System.out.println(d);
        }


        //保存一个部门，同时保存部门中的员工
        Dept dept = new Dept();
        dept.setDname("销售");
        Emp e1 = new Emp();
        e1.setEname("s1");
        Emp e2 = new Emp();
        e2.setEname("s2");
        //部门能感知员工的存在 结合接口，非必要
        dept.getEmps().add(e1);
        dept.getEmps().add(e2);

        //员工要指定部门
        e1.setDept(dept);
        e2.setDept(dept);

        mapper.saveDept(dept);
        //mapper.saveEmp(e1);;
        //mapper.saveEmp(e2);;
        for(Emp e : dept.getEmps()){
            mapper.saveEmp(e);
        }

        //事务提交
        sqlSession.commit();

        sqlSession.close();
    }
}
