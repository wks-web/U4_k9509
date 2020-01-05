package cn.kgc.controller;

import cn.kgc.domain.UserCondition;
import cn.kgc.domain.Users;
import cn.kgc.service.UsersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller("userController")
@RequestMapping("/admin/")
public class UserController {
@Autowired
    UsersService usersService;
    @RequestMapping("getUserData")
    @ResponseBody
    public Map<String,Object>getUserData(UserCondition condition){
        PageInfo<Users> userByPage = usersService.getUserByPage(condition);
        //封装返回数据
        Map<String,Object>map=new HashMap<>();
        map.put("total",userByPage.getTotal());
        map.put("rows",userByPage.getList());
        return map;
    }

}
