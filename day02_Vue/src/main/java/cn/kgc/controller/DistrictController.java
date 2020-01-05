package cn.kgc.controller;

import cn.kgc.domain.District;
import cn.kgc.service.DemoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController //@RestController==@Controller+@ResponseBody
@RequestMapping("/admin/")//指定请求前缀
public class DistrictController {

    @Autowired
    DemoService demoService;
    @RequestMapping("getDistrict")
    public Map<String,Object>getDistrict(Integer page,Integer rows){
        //调用业务区域数据
        PageInfo<District> pb = demoService.getDistrictByPb(page, rows);
        //封装返回数据
        Map<String,Object> map=new HashMap<>();
        map.put("total",pb.getTotal());
        map.put("rows",pb.getList());
        return map;
    }
    //添加
    @RequestMapping("addDistrict")
    public Map<String,Object> addDistrict(District district){
        //调用业务
        Integer result = demoService.addDistrict(district);
        //封装返回数据
        Map<String,Object> map=new HashMap<>();
        map.put("result",result);
        return map;
    }
@RequestMapping("geiDistrict")
    public District geiDistrict(Integer id){
        try {
            District district = demoService.getDistrict(id);
            return district;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("updateDistrict")
    public String  updateDistrict(District district){
        try {
            Integer result = demoService.updateDistrict(district);
            return "{\"result\":"+result+"}";   //拼接的json
        }catch (Exception e){
            return "{\"result\":-1}";
        }
    }
    @RequestMapping("deleteDistrict")
    public Map<String,Object> deleteDistrict(Integer id){
        Map<String,Object> map=new HashMap<>();
        try {
           demoService.delStreetByDistrict(id);
            map.put("result",1);
            return map;
        }catch (Exception e){
            map.put("result",-1);
              return map;
        }
    }
    //批量删除区域
//前台传递数据的格式:ids=1,2,3,4     后台: String ids变量接收数据
//前台传递数据的格式:ids=1&ids=2&ids=3     后台: Integer []ids变量接收数据
    @RequestMapping("deletDistrictBatches")
    public String deletDistrictBatches(String ids){
        try {

        }catch (Exception e){
            e.printStackTrace();//使用日志工具记录
            return "{\"result\":-1}";
        }
        //将字符串转化为数据组
        String[] split = ids.split(",");
        Integer[] id=new Integer[split.length];
        for (int i =0;i<split.length;i++){
            id[i]=new Integer(split[i]);
        }
        //调用业务
        Integer integer = demoService.deletDistrictBatches(id);
        return "{\"result\":"+integer+"}"; //拼接的json
    }
}
