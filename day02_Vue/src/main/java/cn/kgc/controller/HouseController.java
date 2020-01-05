package cn.kgc.controller;

import cn.kgc.domain.House;
import cn.kgc.service.HouseService;
import cn.kgc.util.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("HouseController2")
@RequestMapping("/admin/")
public class HouseController {
    @Autowired
    HouseService houseService;
    @RequestMapping("getHouse")
    public Map<String,Object> getHouse(PageUtil pageUtil){
        //调用业务获取数据
        PageInfo<House> pageInfo = houseService.getBackAllHouse(pageUtil);
        //封装返回数据
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    @RequestMapping("updatePassState")
    public Map<String,Object>updatePassState(String id,Integer state){
        //调用业务获取数据
        int temp = houseService.passHouse(id, state);
        //封装放回数据
        Map<String,Object>map=new HashMap<>();
        map.put("result",temp);
        return map;
    }
}
