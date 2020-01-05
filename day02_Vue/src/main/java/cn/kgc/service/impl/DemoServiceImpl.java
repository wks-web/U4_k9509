package cn.kgc.service.impl;

import cn.kgc.domain.District;
import cn.kgc.domain.DistrictExample;
import cn.kgc.mapper.DistrictMapper;
import cn.kgc.mapper.StreetMapper;
import cn.kgc.service.DemoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    DistrictMapper districtMapper;
    @Autowired
    StreetMapper streetMapper;
    @Transactional
    @Override
    public PageInfo<District> getDistrictByPb(Integer page, Integer rows) {
        //1.开启分页
        PageHelper.startPage(page,rows);
        DistrictExample districtExample=new DistrictExample();
        //2.查询
        List<District> districtList = districtMapper.selectByExample(districtExample);
        //封装分页参数并返回
        PageInfo<District> pageInfo=new PageInfo<>(districtList);
        return pageInfo;
    }

    @Override
    public Integer addDistrict(District district) {
        return districtMapper.insertSelective(district);
    }

    @Override
    public District getDistrict(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }

//    @Override
//    public Integer deleteDistrict(Integer id) {
//        return districtMapper.deleteByPrimaryKey(id);
//    }

    @Override
//    REQUIRED

    @Transactional //支持事务  都成功，都不成功
    //如果方法不报错则事务管理器会提交，报错时，事务管理器会回滚
    public void delStreetByDistrict(Integer id) {
        //第二步:删除区域
        districtMapper.deleteByPrimaryKey(id);
        int i=1/0;
        //第一步:删除街道   编写dao层提供删除区域下街道的方法
        streetMapper.delStreetByDistrict(id);
    }

    @Override
    public Integer deletDistrictBatches(Integer[] ids) {
        return districtMapper.deletDistrictBatches(ids);
    }

    @Override
    public List<District> getAllDistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }
}
