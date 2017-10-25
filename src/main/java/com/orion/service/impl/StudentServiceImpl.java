package com.orion.service.impl;

import com.orion.dao.StudentDao;
import com.orion.domain.Student;
import com.orion.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LLC on 2017/10/22.
 */
@Service(value="studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public Student findOne(String id) {
        return studentDao.findOne(id);
    }

    @Override
    public List<Student> listAll() {
        return studentDao.findAll();
    }

    @Override
    public void delete(String id) {
        studentDao.delete(id);
    }

    @Override
    public void batchInsert(List<Student> students) {
        studentDao.save(students);
    }

    public void deleteSt(Student student){
        studentDao.delete(student);
    }

    @Override
    public Page<Student> findPage(Pageable pageable) {
        return studentDao.findAll(pageable);
    }

    @Override
    public List<Student> findStudentByAgeIn(List<Integer> ages) {
        return studentDao.findStudentByAgeIn(ages);
    }

    @Override
    public List<Student> findByAgeGreaterThanEqualOrderByBirthDesc(Integer age) {
        return studentDao.findByAgeGreaterThanEqualOrderByBirthDesc(age);
    }
}
