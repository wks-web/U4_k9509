package cn.kgc.service.impl;

import cn.kgc.domain.UserCondition;
import cn.kgc.domain.Users;
import cn.kgc.domain.UsersExample;
import cn.kgc.mapper.UsersMapper;
import cn.kgc.service.UsersService;
import cn.kgc.util.MD5Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Service("UsersServiceImpl")
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersMapper usersMapper;
    @Override
    //动态分页模糊查询
    public PageInfo<Users> getUserByPage(UserCondition condition) {
        //1.开启分页
        PageHelper.startPage(condition.getPage(),condition.getRows());
        //查询所有用户
        UsersExample usersExample=new UsersExample();
        //封装条件
        UsersExample.Criteria criteria = usersExample.createCriteria();
        //动态sql：一个属性一个判断
        if (condition.getName()!=null){
            criteria.andNameLike("%"+condition.getName()+"%");
        }
        if (condition.getTel()!=null){
            criteria.andTelephoneLike("%"+condition.getTel()+"%");
        }
        List<Users> usersList = usersMapper.selectByExample(usersExample);
        PageInfo<Users> pageInfo=new PageInfo<>(usersList);
        return pageInfo;
    }

    @Override
    public boolean checkUseName(String name) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        //添加条件
        criteria.andIsadminEqualTo(new Integer(0));//保证房东用户
        criteria.andNameEqualTo(name);
        List<Users> list = usersMapper.selectByExample(usersExample);
         //如果当集合为null说明没有查询到记录,用户名可用
        if (list!=null&&list.size()!=0){
            return false;
        }
        return true;
    }

    @Override
    public int addUser(Users users) {
        //出于系统用户安全考虑_对密码进行加密码
        //使用MD5工具类对密码加密
        String md5Encrypt = MD5Utils.md5Encrypt(users.getPassword());
        users.setPassword(md5Encrypt);
        //设置用户
        users.setIsadmin(0);
        return usersMapper.insertSelective(users);
    }

    @Override
    public Users login(String userName, String passWord) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        //添加条件
        criteria.andIsadminEqualTo(new Integer(0));
        criteria.andNameEqualTo(userName);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(passWord));
        List<Users> list = usersMapper.selectByExample(usersExample);
        //如果当集合为null说明没有查询到记录,用户名可用
        if (list!=null&&list.size()>0){
            return list.get(0);//返回登入的人
        }return null;

    }

}
