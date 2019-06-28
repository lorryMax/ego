package com.sxt.service;

import com.sxt.model.Page;

import java.io.Serializable;

public interface IService<T> {

    /**
     * 添加
     *
     * @param t
     * @return
     */
    Integer add(T t);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Integer del(Serializable id);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    T update(T t);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    T findById(Serializable id);


    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    Page<T> findByPage(Integer page, Integer size);


}
