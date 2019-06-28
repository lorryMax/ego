package com.sxt.service.impl;

import com.github.pagehelper.PageHelper;
import com.sxt.mapper.IMapper;
import com.sxt.model.Page;
import com.sxt.service.IService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class AServiceImpl<T> implements IService<T> {


    protected IMapper<T> dao;

    @Override
    public Integer add(T t) {
        return dao.insert(t);
    }

    @Override
    public Integer del(Serializable id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public T update(T t) {
        dao.updateByPrimaryKeySelective(t);
        return t;
    }

    @Override
    public T findById(Serializable id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public Page<T> findByPage(Integer page, Integer size) {
        com.github.pagehelper.Page<Object> startPage = PageHelper.startPage(page, size);
        List<T> list = dao.selectByExample(null);
        long total = startPage.getTotal();
        return new Page<T>(page, size, total, list);
    }
}
