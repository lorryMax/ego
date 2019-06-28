package com.sxt.model;


import java.io.Serializable;
import java.util.List;

/**
 * 分页
 */
public class Page<T> implements Serializable {
    /**
     * 页号
     */
    private Integer page;
    /**
     * 每页大小
     */
    private Integer size;
    /**
     * 总记录数
     */

    private Long total;
    /**
     * 结果集
     */
    private List<T> results;

    public Page() {
    }

    public Page(Integer page, Integer size, Long total, List<T> results) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
