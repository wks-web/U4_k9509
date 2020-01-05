package cn.kgc.controller;
import cn.kgc.domain.Street;
import cn.kgc.service.StreetService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController //@RestController==@Controller+@ResponseBody
@RequestMapping("/admin/")//指定请求前缀
public class StreetController {

    @Autowired
    StreetService streetService;
    @RequestMapping("getStreet")
    public Map<String,Object>getStreet(Integer page,Integer rows){
        //调用业务区域数据
        PageInfo<Street> pb = streetService.getStreetByPb(page, rows);
        //封装返回数据
        Map<String,Object> map=new HashMap<>();
        map.put("total",pb.getTotal());
        map.put("rows",pb.getList());
        return map;
    }
    //添加
    @RequestMapping("addStreet")
    public Map<String,Object> addStreet(Street street){
        //调用业务
        Integer result = streetService.addStreet(street);
        //封装返回数据
        Map<String,Object> map=new HashMap<>();
        map.put("result",result);
        return map;
    }
@RequestMapping("geiStreet")
    public Street geiStreet(Integer id){
        try {
            Street street = streetService.getStreet(id);
            return street;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("updateStreet")
    public String  updateStreet(Street street){
        try {
            Integer result = streetService.updateStreet(street);
            return "{\"result\":"+result+"}";   //拼接的json
        }catch (Exception e){
            return "{\"result\":-1}";
        }
    }
    @RequestMapping("deleteStreet")
    public Map<String,Object> deleteStreet(Integer id){
        Map<String,Object> map=new HashMap<>();
        try {
           streetService.delStreetByStreet(id);
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
    @RequestMapping("deletStreetBatches")
    public String deletStreetBatches(String ids){
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
        Integer integer = streetService.deletStreetBatches(id);
        return "{\"result\":"+integer+"}"; //拼接的json
    }
}
