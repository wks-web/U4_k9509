package cn.kgc.mapper;

import cn.kgc.domain.District;
import cn.kgc.domain.DistrictExample;
import java.util.List;

public interface DistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
    /**
     * 实现区域批量删除
     * @param ids 批量删除的id
     * @return 影响行数
     */
    public int deletDistrictBatches(Integer[] ids);
}