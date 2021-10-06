package com.kp.ono2one;

import java.util.List;

public interface One2OneMapper {
    List<Person> selectPersonById();

    void savePerson(Person person);
    void saveIdCard(Person person);
}
