package com.sxt.model;

import java.io.Serializable;
import java.util.List;


/**
 * 商品适配Vo类
 *
 * @author Luo
 */
public class OrderVo implements Serializable {


    /**
     * 用户id
     */
    private Integer uid;


    /**
     * 商品
     */
    private List<OrderGoodsVo> goodsVoList;


    /**
     * 总金额
     */

    private Double totalMoeny;

    public OrderVo() {
    }

    public OrderVo(Integer uid, List<OrderGoodsVo> goodsVoList, Double totalMoeny) {
        this.uid = uid;
        this.goodsVoList = goodsVoList;
        this.totalMoeny = totalMoeny;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public List<OrderGoodsVo> getGoodsVoList() {
        return goodsVoList;
    }

    public void setGoodsVoList(List<OrderGoodsVo> goodsVoList) {
        this.goodsVoList = goodsVoList;
    }

    public Double getTotalMoeny() {
        return totalMoeny;
    }

    public void setTotalMoeny(Double totalMoeny) {
        this.totalMoeny = totalMoeny;
    }
}
