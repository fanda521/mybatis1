package com.kp.dao;

import com.kp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    //方法名和sql中的id对应 UserMapper.xml <select id="selectUserById" parameterType="int" resultType="com.kp.entity.User">
    //UserMapper.xml 中的命名空间使用该接口的名称
    User selectUserById(Integer id);

    List<User> selectAllUsers();

    //查询所有的用户，根据用户名来过滤
    List<User> selectUsersByName(String username);

    //插入操作
    void addUser(User user);

    //修改
    void updateUser(User user);

    //删除
   void deleteUser(User user);

    //返回值是map
    Map selectUserById2(int id);

    //统计记录条数
    HashMap<String,Long> selectCount();

    //假如返回的是多条
   /* Map selectUserById3();
*/

   // 定义方法可以根据用户的名字做模糊查询，并且可以指定 列名进行排序

    /**
     *
     * @param userName  查询的条件
     * @param columName  排序的列名
     * @param orderType  排序的规则  desc  asc
     * @return  user对象集合
     */
    List<User> selectUser3(@Param("name") String userName,
                           @Param("columName") String columName,
                           @Param("orderType") String orderType);

    /*
    map.put(userName,'')
     map.put(columName,'')
     map.put(orderType,'')
     #{userName} order by ${columName} ${orderType}
     传递参数的key一定是sql中使用的字符串
    * */
    List<User> selectUser4(Map<String, Object> params);

    /**
     *
     * @param userName  查询的条件
     * @param columName  排序的列名
     * @param orderType  排序的规则  desc  asc
     * @param pageNo 第几页
     * @param pageSize 查询多少条记录
     * @return  user对象集合
     */
    List<User> selectUser5(@Param("userName") String userName,
                          @Param("pageNo") int pageNo,
                           @Param("pageSize")  int pageSize,
                           @Param("columName") String columName,
                           @Param("orderType") String orderType);

    // 作业  提供一个方法直接返回分页数据
    // 类 pageRequest 属性 pageNo pageSize
    // 返回值类  pageResult  属性 pageNo（第几页）  pageSize（每页查询多少条）  totals（总的记录数）  totalPages（总页数） list数据
    // 方法的定义：   pageResult getDatas (pageRequest pageRequest)

    //动态sql
    List<User> selectUser6(User user);

    // 修改
    void updateUser2(User user);

    List<User> selectUser7(List list);
}
