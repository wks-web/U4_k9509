package cn.kgc.service;

import cn.kgc.domain.UserCondition;
import cn.kgc.domain.Users;
import com.github.pagehelper.PageInfo;

public interface UsersService {
    /**
     * 查询区域带分页
     * @param condition
     *   包含查询的条件
     *   page属性接收页码，rows接收页大小
     * @return
     */
    public PageInfo<Users> getUserByPage(UserCondition condition);

    /**
     * 检查用户名是否存在
     * @param name  用户名
     * @return  布尔类型  可用返回true,不可用返回false
     */
    public boolean checkUseName(String name);

    /**
     * 注册用户
     * @param users  用户实体
     * @return  影响行数
     */
    public int addUser(Users users);

    /**
     * 用户的登入
     * @param usernmae  用户名
     * @param password  密码
     * @return 返回用户的信息
     */
    public Users login(String userName,String passWord);
}
