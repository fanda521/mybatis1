package com.kp;

import com.kp.dao.UserMapper;
import com.kp.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App2 {
    public static void main(String[] args) throws Exception {
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //创建sessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取session
        SqlSession sqlSession = sessionFactory.openSession();

        // 获取
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map map =  mapper.selectUserById2(1);
        for (Object key : map.keySet()){
            //System.out.println(key + " : " + map.get(key) );
        }

        //统计记录条数
        HashMap<String, Long> countMap = mapper.selectCount();
        //System.out.println("记录条数：" + countMap.get("totals"));

        //Map map1 = mapper.selectUserById3();

        //多参数非对象封装
        List<User> users = mapper.selectUser3("%a%", "id", "desc");
        for (User user : users) {
            //System.out.println(user);
        }

        //参数是map结构
        Map<String,Object> params = new HashMap<>();
        params.put("userName", "%a");
        params.put("columName", "id");
        params.put("orderType", "asc");
        for (User user : mapper.selectUser4(params)) {
           // System.out.println(user);
        }

        // 分页查询  第一页 0  第二页  （2-1）*4
        List<User> users1 = mapper.selectUser5("%%", 4, 4, "id", "asc");
        for (User user : users1) {
           // System.out.println(user);
        }
        User u = new User();
        u.setColumName("id");
        //u.setUserName("%a%");
        u.setAddress("%%");
        u.setUserAddress("深圳,罗湖");
        //u.setOrderType("desc");
        for (User user : mapper.selectUser6(u)) {
            System.out.println(user);
        }


        //修改
        User u2 = new User();
        u2.setUserName("abc");
        u2.setUserAge("20");
        mapper.updateUser2(u2);
        //集合查询
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        mapper.selectUser7(list);

        //事务提交和关闭资源
        sqlSession.commit();
        sqlSession.close();
    }
}
