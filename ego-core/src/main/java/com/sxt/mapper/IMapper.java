package com.sxt.mapper;

import java.io.Serializable;
import java.util.List;

public interface IMapper<T> {

    /**
     * 根据主键删除实体
     *
     * @param id 主键
     * @return 影响的行数
     */
    int deleteByPrimaryKey(Serializable id);

    /**
     * 插入一个实体
     *
     * @param t 实体
     * @return
     */
    int insert(T t);

    /**
     * 主键查询
     *
     * @param id 主键
     * @return 实体
     */
    T selectByPrimaryKey(Serializable id);

    /**
     * 根据id 来更新安全更新
     *
     * @param t t 里面必须有id
     * @return
     */
    int updateByPrimaryKeySelective(T t);

    /**
     * 根据id 来更新
     *
     * @param t t 里面必须有id
     * @return
     */
    int updateByPrimaryKey(T t);

    /**
     * 查询方法
     *
     * @param example 代表条件
     * @return 实体的集合
     */
    List<T> selectByExample(Object example);
}

