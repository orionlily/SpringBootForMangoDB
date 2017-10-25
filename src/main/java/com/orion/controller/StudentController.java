package com.orion.controller;

import com.orion.domain.Student;
import com.orion.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by LLC on 2017/10/22.
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/save")
    public void save(){
        Student student = new Student();
        student.setBirth(new Date());
        student.setAge(33);
        student.setName("李男");
        studentService.save(student);
    }

    @RequestMapping(value = "/{viewName}")
    public ModelAndView view(@PathVariable String viewName){
        ModelAndView mav = new ModelAndView(viewName);
        return  mav;
    }

    @RequestMapping(value = "/findAll")
    public List<Student> findAll(){
       return  studentService.listAll();
    }

    @RequestMapping(value = "/findOne/{id}")
    public Student findOne(@PathVariable String id){
        return  studentService.findOne(id);
    }

    @RequestMapping(value = "batchSave")
    public void batchSave(){
        List<Student> students = new ArrayList<Student>();
        for (int i =0 ;i<5;i++){
            Student student = new Student();
            student.setName("八神"+i);
            student.setAge(13+i);
            student.setBirth(new Date());
            students.add(student);
        }
        studentService.batchInsert(students);
    }

    @RequestMapping(value = "deleteSt")
    public  void  deleteSt(){
        Student student = new Student();
        student.setId("59ef4d9ea9f06a0b2cd84a51");
        student.setName("八神0");
        student.setAge(13);
        student.setBirth(new Date());
        studentService.deleteSt(student);
    }


    @RequestMapping(value = "findPage")
    @ResponseBody
    public Page<Student> findPage(){
        List<Sort.Order> orders=new ArrayList<Sort.Order>();
        orders.add( new Sort.Order(Sort.Direction.DESC, "age"));
        orders.add( new Sort.Order(Sort.Direction.DESC, "birth"));
        Sort sort = new Sort(orders);
        Pageable pageable = new PageRequest(0,2,sort);
        return studentService.findPage(pageable);
    }


    @RequestMapping(value = "findByAgeIn")
    @ResponseBody
    public List<Student> findByAgeIn(){
        return  studentService.findStudentByAgeIn(Arrays.asList(23,33));
    }

    @RequestMapping(value = "findByAgeSort")
    @ResponseBody
    public List<Student> findByAgeGreaterThanEqualOrderByBirth(){
        return studentService.findByAgeGreaterThanEqualOrderByBirthDesc(23);
    }
}
