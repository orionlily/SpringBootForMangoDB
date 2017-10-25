package com.orion.service;

import com.orion.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by LLC on 2017/10/22.
 */
public interface StudentService {

    public void save(Student student);

    public Student findOne(String id);

    public List<Student> listAll();

    public void delete(String id);

    public void batchInsert(List<Student> students);

    public void deleteSt(Student student);//还是根据id删除的

    public Page<Student> findPage(Pageable pageable);


    public List<Student> findStudentByAgeIn(List<Integer> ages);

    public List<Student> findByAgeGreaterThanEqualOrderByBirthDesc(Integer age);
}
