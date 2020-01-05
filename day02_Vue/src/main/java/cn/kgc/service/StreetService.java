package cn.kgc.service;

import cn.kgc.domain.Street;
import cn.kgc.domain.UserCondition;
import cn.kgc.domain.Users;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StreetService {
    //分页查询
    public PageInfo<Street> getStreetByPb(Integer page, Integer rows);
  /**
   * @param Street 区域实体信息
   * @return  影响行数
   * */
  //添加区域信息
    public Integer addStreet(Street street);

    //查询单条数据--修改显示
    public Street getStreet(Integer id);
    /**
     * 修改区域
     * @param Street  区域实体
     * @return 影响行数
     */
    public Integer updateStreet(Street street);

    /**
     * 删除区域
     * @param id  区域编号
     * @return  影响行数
     */

//    public Integer deleteStreet(Integer id);

    //删除区域的街道
    void delStreetByStreet(Integer id);
    /**
     * 批量删除区域
     * @param ids 批量删除的id
     * @return 影响行数
     */
    Integer deletStreetBatches(Integer[] ids);
  /**
   * 查询对应区域下的街道
   * @return
   */
    List<Street>getStreetByDistrict(Integer did);

}
