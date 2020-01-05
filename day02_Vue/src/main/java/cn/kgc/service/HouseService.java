package cn.kgc.service;

import cn.kgc.domain.House;
import cn.kgc.util.HouseCondition;
import cn.kgc.util.PageUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface HouseService {

    /**
     * 添加出租房
     * @param house 出租房实体
     * @return
     */
    public int addHouse(House house);
    /**
     * 查询用户发布的出租房信息
     * @param userid  用户编号
     * @return  出租房信息
     */
    public PageInfo<House> getHouseByUser(Integer userid, PageUtil pageUtil);
    /**
     * 查询某出租房的信息
     * @param id  编号
     * @return  出租房实体
     */
    public House getHouse(String id);
    /**
     * 修改出租房信息
     * @param house  出租房实体
     * @return 影响的行数
     */
    public int updateHouse(House house);

    /**逻辑删除(不是真删除)
     * 更新出租房删除的状态
     * @param houseId 出租房编号
     * @param delState   删除的状态
     * 状态为1 表示删除出租房     0表示恢复出租房，不删除
     * @return 影响
     */
    public int deleteHouse(String houseId,Integer delState);
    /**
     * 查询所有后台出租房信息
     * @param pageUtil 分页参数
     * @return 出租房信息
     */
    public PageInfo<House> getBackAllHouse(PageUtil pageUtil);
    /**
     * 更新出租房的审核状态
     * @param houseId  出租房编号
     * @param passState  状态
     * @return 影响行数
     */
    public int passHouse(String houseId,Integer passState);
   //条件查询带分页
    public PageInfo<House> getBroswerHouse(HouseCondition houseCondition);
}
