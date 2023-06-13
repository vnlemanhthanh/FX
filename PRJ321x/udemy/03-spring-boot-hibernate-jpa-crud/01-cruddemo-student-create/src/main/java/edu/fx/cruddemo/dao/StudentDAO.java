package edu.fx.cruddemo.dao;

import edu.fx.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);
}
