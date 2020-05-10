package com.wyw.test.mybatisdemo.controller;

import com.wyw.test.mybatisdemo.dto.StudentDTO;
import com.wyw.test.mybatisdemo.entity.StudentEntity;
import com.wyw.test.mybatisdemo.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王延伟
 * @description TODO
 * @createTime 2020年5月10日$ 23点34分$
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //增
    @PostMapping("/savestudent")
    public String addStudent(@RequestBody StudentDTO studentDTO){
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(studentDTO, studentEntity);

        boolean save = studentService.save(studentEntity);

        return Boolean.toString(save);

    }

    //改
    @PostMapping("/updatestudent")
    public String updateStudent(@RequestBody StudentDTO studentDTO){
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(studentDTO, studentEntity);


        boolean update = studentService.updateById(studentEntity);

        return Boolean.toString(update);

    }

    //查

    @GetMapping("/selectstudentbyid")
    public String selectstudentbyid (@RequestParam String id){
        StudentEntity byId = studentService.getById(id);
        return byId.toString();
    }

    //删
    @GetMapping("/delectstudentbyid")
    public String delectStdentById(@RequestParam String id){
        boolean b = studentService.removeById(id);
        return Boolean.toString(b);

    }


}
