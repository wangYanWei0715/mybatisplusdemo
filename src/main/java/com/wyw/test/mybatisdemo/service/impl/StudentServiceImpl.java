package com.wyw.test.mybatisdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyw.test.mybatisdemo.entity.StudentEntity;
import com.wyw.test.mybatisdemo.mapper.StudentMapper;
import com.wyw.test.mybatisdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 王延伟
 * @description TODO
 * @createTime 2020年5月10日$ 23点36分$
 */
@Service("studentService")
@Transactional
public class StudentServiceImpl extends ServiceImpl<StudentMapper, StudentEntity> implements StudentService {


}
