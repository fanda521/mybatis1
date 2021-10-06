package com.kp.annotations;

import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {
    /*提供sql*/
     public  String sqlUserById(){
         return new SQL(){{
             SELECT("id,userAge,userName,userAddress,user_birth userBirth");
             FROM("user");
             WHERE("id=#{ids}");
         }}.toString();
     }
     //@Insert("insert into user(userName,userAge,userAddress) values(#{userName},#{userAge},#{userAddress})")
     public String saveSql(){
         return new SQL(){{
             INSERT_INTO("user");
             VALUES("userAge,userName", "#{userAge},#{userName}");
         }}.toString();
     }
}
