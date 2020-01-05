package cn.kgc.mapper;

import cn.kgc.domain.Street;
import cn.kgc.domain.StreetExample;
import java.util.List;

public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);
    //删除区域的街道
    int delStreetByDistrict(Integer id);
    //批量删除街道
    int deletStreetBatches(Integer[] ids);
}