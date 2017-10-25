package com.orion.dao;

import com.orion.domain.Student;
import org.springframework.stereotype.Repository;
import com.orion.orm.BaseRepository;

import java.util.List;

/**
 * Created by LLC on 2017/10/22.
 */
@Repository
public interface StudentDao extends BaseRepository<Student,String> {

    public List<Student> findStudentByAgeIn(List<Integer> ages);

    public List<Student> findByAgeGreaterThanEqualOrderByBirthDesc(Integer age);

}
