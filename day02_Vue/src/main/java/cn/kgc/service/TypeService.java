package cn.kgc.service;

import cn.kgc.domain.Street;
import cn.kgc.domain.Type;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TypeService {
  /**
   * 查询所有类型
   * @return
   */
    public List<Type> getAllType();

}
