package cn.kgc.pcontroller;

import cn.kgc.domain.District;
import cn.kgc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("DistrictController2")
@RequestMapping("/page/")
public class DistrictController {
    @Autowired
    DemoService demoService;
    @RequestMapping("getAllDistrictData")
    @ResponseBody
    public List<District>getAllDistrictData() {
      return demoService.getAllDistrict();
    }
}
