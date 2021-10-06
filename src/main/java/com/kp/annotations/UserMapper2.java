package com.kp.annotations;

import com.kp.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper2 {
    //保存一个用户
    @Insert("insert into user(userName,userAge,userAddress) values(#{userName},#{userAge},#{userAddress})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void saveUser(User user);

    //删除操作
    @Delete("delete from user where id=#{id}")
    public void delete(User user);

    //修改的操作
    @Update("update user set userName=#{userName},userAge=#{userAge},userAddress=#{userAddress} where id=#{id}")
    public void update(User user);

    //没有条件的查询操作
    @Select("select * from user")
    public List<User> getUsers();

    @Select("select * from user limit ${first},${max}")
    public List<User> getUsers2(@Param("first") int firstResult,
                                @Param("max") int maxResult);


    @Select("select * from user where username like #{u.userName} limit ${firstResult},${maxResult}")
    @Results(id = "id",value={
            @Result(column = "user_birth",property = "userBirth")
    })
    public List<User> getUsers3(
            @Param("u") User user,
            @Param("firstResult") int firstResult,
            @Param("maxResult") int maxResult);
    //没有指定列和属性的对应关系 如果列和属性是的名称是一样自动赋值

    @Select("select * from user where username like #{u.userName} limit ${firstResult},${maxResult}")
    @ResultMap(value="users") //<resultMap id="users" type="com.kp.entity.User"> 映射文件夹中的
    public List<User> getUsers4(
            @Param("u") User user,
            @Param("firstResult") int firstResult,
            @Param("maxResult") int maxResult);

    //根据id查询一个user对象
    @SelectProvider(value=UserSqlProvider.class,method = "sqlUserById")
    @ResultType(User.class)
    public User getUserById2(@Param("ids") int id);


    @SelectProvider(value = UserSqlProvider.class,method = "saveSql")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void saveUser2(User user);
}
