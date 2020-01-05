package cn.kgc.service;

import cn.kgc.domain.Students;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface DemoServie {
    List<Students> queryStudentAll();
    List<Students> findStuByid(Long id);
    public PageInfo<Students> pagingquery(Integer page, Integer rows);
}
