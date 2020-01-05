package cn.kgc.controller;


import cn.kgc.domain.Students;
import cn.kgc.service.DemoServie;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    DemoServie demoServie;
    @RequestMapping("/queryStudent")
    public String queryStudent(Model model){
        List<Students> studentsList = demoServie.queryStudentAll();
        model.addAttribute("studentsList",studentsList);
        return "main";
    }
    @RequestMapping("/getStudent")
    @ResponseBody
    //@ResponseBody注解
    //1.表示将方法返回值输出到页面中
    //2.将返回的java对象转化json字符串进行返回  ===>依赖jackson
    public List<Students> getStudent(){
        List<Students> studentsList = demoServie.queryStudentAll();
        return studentsList;
    }
    @RequestMapping("getStuByid")
    @ResponseBody
    public List<Students> getStuByid(Long id){
        List<Students> studentsList = demoServie.findStuByid(id);
        return studentsList;
    }
@RequestMapping("showByPb")
@ResponseBody
    public Map<String, Object> pagingquery(Integer page, Integer rows){
        //调用业务层方法
        PageInfo<Students> studentsPageInfo = demoServie.pagingquery(page, rows);
        //返回datagrid需要的数据 total总记录数，rows当前页的
        Map<String,Object> map=new HashMap<>();
        map.put("total",studentsPageInfo.getTotal());
        map.put("rows",studentsPageInfo.getList());
        return map;
    }
}
