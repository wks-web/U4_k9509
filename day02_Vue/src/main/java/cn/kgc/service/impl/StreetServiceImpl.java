package cn.kgc.service.impl;

import cn.kgc.domain.*;
import cn.kgc.mapper.StreetMapper;
import cn.kgc.mapper.StreetMapper;
import cn.kgc.service.DemoService;
import cn.kgc.service.StreetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    StreetMapper streetMapper;
    @Transactional
    @Override
    public PageInfo<Street> getStreetByPb(Integer page, Integer rows) {
        //1.开启分页
        PageHelper.startPage(page,rows);
        StreetExample streetExample=new StreetExample();
        //2.查询
        List<Street> StreetList = streetMapper.selectByExample(streetExample);
        //封装分页参数并返回
        PageInfo<Street> pageInfo=new PageInfo<>(StreetList);
        return pageInfo;
    }

    @Override
    public Integer addStreet(Street street) {
        return streetMapper.insertSelective(street);
    }

    @Override
    public Street getStreet(Integer id) {
        return streetMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateStreet(Street street) {
        return streetMapper.updateByPrimaryKeySelective(street);
    }

//    @Override
//    public Integer deleteStreet(Integer id) {
//        return StreetMapper.deleteByPrimaryKey(id);
//    }

    @Override
//    REQUIRED

    @Transactional //支持事务  都成功，都不成功
    //如果方法不报错则事务管理器会提交，报错时，事务管理器会回滚
    public void delStreetByStreet(Integer id) {
        //第一步:删除街道
        streetMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deletStreetBatches(Integer[] ids) {
        return streetMapper.deletStreetBatches(ids);
    }


    @Override
    public List<Street> getStreetByDistrict(Integer did) {
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(did);
        return streetMapper.selectByExample(streetExample);
    }


}
