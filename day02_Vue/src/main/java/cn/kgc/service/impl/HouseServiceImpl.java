package cn.kgc.service.impl;

import cn.kgc.domain.House;
import cn.kgc.mapper.HouseMapper;
import cn.kgc.service.HouseService;
import cn.kgc.util.HouseCondition;
import cn.kgc.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseMapper houseMapper;
    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseByUser(Integer uid, PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        List<House> list = houseMapper.getHouseByUser(uid);
        return new PageInfo<House>(list);
    }

    //查询单条
    @Override
    public House getHouse(String id) {
        return houseMapper.getHouse(id);
    }

//    修改
    @Override
    public int updateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }
//    逻辑删除
    @Override
    public int deleteHouse(String houseId, Integer delState) {
        House house=new House();
        house.setId(houseId);
        house.setIsdel(delState);
        return houseMapper.updateByPrimaryKeySelective(house);
    }
      //查询所有后台出租房信息(并分页)
    @Override
    public PageInfo<House> getBackAllHouse(PageUtil pageUtil) {
        //开启分页
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        List<House> houseList = houseMapper.getBackAllHouse();
        return new PageInfo<House>(houseList);
    }

    //更新出租房的审核状态
    @Override
    public int passHouse(String houseId, Integer passState) {
        House house=new House();
        house.setId(houseId);  //条件
        house.setIspass(passState);//更新审核状态
        return houseMapper.updateByPrimaryKeySelective(house);
    }
//   分页条件查询
    @Override
    public PageInfo<House> getBroswerHouse(HouseCondition houseCondition) {
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getRows());
        List<House> house = houseMapper.getHouseByHConndition(houseCondition);
        return new PageInfo<>(house);
    }
}
