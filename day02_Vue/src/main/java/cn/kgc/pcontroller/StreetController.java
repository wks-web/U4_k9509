package cn.kgc.pcontroller;

import cn.kgc.domain.Street;
import cn.kgc.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("StreetController2")
@RequestMapping("/page/")
public class StreetController {
    @Autowired
    StreetService streetService;
    @RequestMapping("getStreetByDistrict")
    @ResponseBody
    public List<Street> getStreetByDistrict(Integer did){
        return streetService.getStreetByDistrict(did);
    }
}
