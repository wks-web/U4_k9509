package cn.kgc.pcontroller;
import cn.kgc.domain.House;
import cn.kgc.domain.Users;
import cn.kgc.service.HouseService;
import cn.kgc.util.FileUploadUtil;
import cn.kgc.util.HouseCondition;
import cn.kgc.util.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/page/")
public class HouseController {
    @Autowired
    HouseService houseService;
    @RequestMapping("addHouse")
    //一个表单对象对应一个参数或者实体
//一个文件域对象与一个CommonsMultipartFile对象对应
    public String addHouse(House house, HttpSession session, @RequestParam(value = "pf",required = false) CommonsMultipartFile pf){
        try {
        //1.实现文件上传
        //获取文件名
        String filename = pf.getOriginalFilename();
        //获取文件的扩展名
        String substring = filename.substring(filename.lastIndexOf("."));
        //生成新的文件名
        String unique = System.currentTimeMillis()+"";
        //新文件名+文件扩展名
        String saveFileName = unique + substring;
        //文件保存路径
        String savaPath = "d:\\images\\" + saveFileName;
        File savafile=new File(savaPath);
            //上传
            pf.transferTo(savafile);
            //2.将数据添加到数据库
            //设置编号
            house.setId(unique);
            //设置所属用户
            Users user = (Users) session.getAttribute("loginInfo");
            house.setUserId(user.getId());
            //设置图片路径
            house.setPath(saveFileName);
            houseService.addHouse(house);
            return "redirect:showHouse";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:fabu.html";
    }

    @RequestMapping("showHouse")
    public String showHouse(PageUtil pageUtil, HttpSession session, Model model){
        //设置页大小   选择设置默认值
        pageUtil.setRows(4);
        //调用业务获取数据
        //获取用户登入的id
        Users users = (Users) session.getAttribute("loginInfo");
        PageInfo<House> pageInfo = houseService.getHouseByUser(users.getId(), pageUtil);
        model.addAttribute("pageInfo",pageInfo);
        return "guanli";
    }
    @RequestMapping("editHouse")
    //显示修改出租房信息
    public String editHouse(String id,Model model){
        House house = houseService.getHouse(id);
        model.addAttribute("house",house);
        return "upfabu";
    }
    @RequestMapping("upHouse")
    //一个表单对象对应一个参数或者实体
//一个文件域对象与一个CommonsMultipartFile对象对应
    public String upHouse(House house,@RequestParam(value = "pf",required = false) CommonsMultipartFile pf,String oldPicPath){
       try {
           //1.判断图片有没有选择   :如果选中图片上传， 否则不上传
           if (!pf.getOriginalFilename().equals("")){
               String saveFileName = FileUploadUtil.upload(pf);
               //设置修改实体图片的路径
               house.setPath(saveFileName);
               //删除旧图
               FileUploadUtil.deleteFile(oldPicPath);
           }
           //2.修改数据库信息
           houseService.updateHouse(house);
           return "redirect:showHouse";
       }catch (Exception e){
           e.printStackTrace();
       }
      return "error";
    }

    @RequestMapping("deleteHouse")//id为出租房编号
    public String deleteHouse(String id){
        try {
            //调用业务删除数据
            int i = houseService.deleteHouse(id,1);
            return "redirect:showHouse";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }
    @RequestMapping("getBroswerHouse")
    public String getBroswerHouse(HouseCondition houseCondition,Model model){
        houseCondition.setRows(4);//设置页面大小
        PageInfo<House> pageInfo = houseService.getBroswerHouse(houseCondition);
        //填充数据
        model.addAttribute("pageInfo",pageInfo);
        //回显数据
        model.addAttribute("houseCondition",houseCondition);
        return "list";
    }
}
