package cn.kgc.mapper;

import cn.kgc.domain.House;
import cn.kgc.domain.HouseExample;
import cn.kgc.util.HouseCondition;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);
    List<House> getHouseByUser(Integer userid);
    //查询单条数据
    House getHouse(String id);
    //查询所有出租信息(进行审核)
    List<House> getBackAllHouse();
    //条件查询并分页
    List<House>getHouseByHConndition(HouseCondition houseCondition);
}