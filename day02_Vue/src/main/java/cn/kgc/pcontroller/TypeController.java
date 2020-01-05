package cn.kgc.pcontroller;

import cn.kgc.domain.Type;
import cn.kgc.domain.Users;
import cn.kgc.service.TypeService;
import cn.kgc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/page/")
public class TypeController {
    @Autowired
    TypeService typeService;
    @RequestMapping("getTypeData")
    @ResponseBody
    public List<Type> getTypeData(){
        return typeService.getAllType();
    }
}
