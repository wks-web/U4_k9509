package cn.kgc.pcontroller;

import cn.kgc.domain.Users;
import cn.kgc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller("UsersController2")
@RequestMapping("/page/")
public class UsersController {
    @Autowired
    UsersService usersService;
    @RequestMapping("checkUseName")
    @ResponseBody
    public String checkUseName(String name){
        boolean res = usersService.checkUseName(name);
        return "{\"result\":"+res+"}";
    }

    @RequestMapping("regUser")
    public String regUser(Users users){
        int user = usersService.addUser(users);
        if (user>0){
            return "redirect:login.html";
        }
        return "redirect:regs.html";
    }
    //注册
    @RequestMapping("logina")
    public String regUser(String userName, String passWord, HttpSession session){
        //调用业务
        Users users = usersService.login(userName, passWord);
        if (users==null){
            return "redirect:login.html";
        }else {
            //只要登入，肯定使用cookie或者session保存登入者的信息
            //使用session保存登入的者的信息
            session.setAttribute("loginInfo",users);
            //设置有效期
            session.setMaxInactiveInterval(10*60);
            return "redirect:showHouse";
        }
    }
}
