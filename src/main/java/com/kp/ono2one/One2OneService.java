package com.kp.ono2one;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.net.CacheRequest;

public class One2OneService {
    public void save(Person person){
        SqlSession sqlSession = createSqlSession();
        try {
            One2OneMapper mapper = sqlSession.getMapper(One2OneMapper.class);

            mapper.savePerson(person);
            mapper.saveIdCard(person);

            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    private  SqlSession createSqlSession(){
        try {
            //读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //创建sessionFactory对象
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取session
            SqlSession sqlSession = sessionFactory.openSession();
            return sqlSession;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
