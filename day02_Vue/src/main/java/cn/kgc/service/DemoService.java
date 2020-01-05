package cn.kgc.service;

import cn.kgc.domain.District;
import cn.kgc.domain.Street;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DemoService {
    //分页查询
    public PageInfo<District> getDistrictByPb(Integer page,Integer rows);
  /**
   * @param district 区域实体信息
   * @return  影响行数
   * */
  //添加区域信息
    public Integer addDistrict(District district);

    //查询单条数据--修改显示
    public District getDistrict(Integer id);
    /**
     * 修改区域
     * @param district  区域实体
     * @return 影响行数
     */
    public Integer updateDistrict(District district);

    /**
     * 删除区域
     * @param id  区域编号
     * @return  影响行数
     */

//    public Integer deleteDistrict(Integer id);

    //删除区域的街道
    void delStreetByDistrict(Integer id);
    /**
     * 批量删除区域
     * @param ids 批量删除的id
     * @return 影响行数
     */
    Integer deletDistrictBatches(Integer[] ids);

  /**
   * 查询所有区域
   * @return
   */
  List<District>getAllDistrict();
}
