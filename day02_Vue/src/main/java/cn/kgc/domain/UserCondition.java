package cn.kgc.domain;

import cn.kgc.util.PageUtil;

//搜索用户的条件实体类
public class UserCondition extends PageUtil {
    //封装查询条件
    private String name;
    private String tel;
    private String whetherAdmin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWhetherAdmin() {
        return whetherAdmin;
    }

    public void setWhetherAdmin(String whetherAdmin) {
        this.whetherAdmin = whetherAdmin;
    }
}
