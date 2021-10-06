package com.kp.ono2one;

/**
 * Hello world!
 *
 */
public class App2
{
    public static void main( String[] args ) throws Exception {


        //保存对象  保存person对象  保存 idcard对象
        Person p = new Person("x5");
        IdCard card = new IdCard("999");
        p.setIdCard(card);

        //将对象保存到数据库中
        One2OneService service = new One2OneService();
        service.save(p);

    }
}
