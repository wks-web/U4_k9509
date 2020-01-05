package cn.kgc.service.impl;

import cn.kgc.domain.Students;
import cn.kgc.domain.StudentsExample;
import cn.kgc.mapper.StudentsMapper;
import cn.kgc.service.DemoServie;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DemoServiceImpl implements DemoServie {
    @Autowired
    StudentsMapper studentsMapper;
    @Override
    public List<Students> queryStudentAll() {
        //使用dao层的selectByExample(StudentsExample example)
        /*查询所有，不带条件*/
        StudentsExample studentsExample=new StudentsExample();
        return  studentsMapper.selectByExample(studentsExample);
//        带条件查询
//        StudentsExample studentsExample1=new StudentsExample();
//        StudentsExample.Criteria criteria = studentsExample1.createCriteria();
//        criteria.andNameLike("%a%");
//        return   studentsMapper.selectByExample(studentsExample1);
    }

    @Override
    public List<Students> findStuByid(Long id) {
        StudentsExample studentsExample=new StudentsExample();
        StudentsExample.Criteria criteria = studentsExample.createCriteria();
        criteria.andIdEqualTo(id);
        return studentsMapper.selectByExample(studentsExample);
    }

    @Override
    public PageInfo<Students> pagingquery(Integer page, Integer rows) {
        //分页步骤：1.开启查询   2.查询所有   3.封装分页参数
        PageHelper.startPage(page,rows);
        StudentsExample studentsExample=new StudentsExample();
        List<Students> studentsList = studentsMapper.selectByExample(studentsExample);
       PageInfo<Students>pageInfo=new PageInfo<>(studentsList);
        return pageInfo;
    }
}
