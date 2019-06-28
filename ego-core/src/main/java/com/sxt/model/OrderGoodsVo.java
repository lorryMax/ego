package com.sxt.model;


import java.io.Serializable;

/**
 * 每件商品的的消息
 * @author Luo
 */
public class OrderGoodsVo implements Serializable {

    /**
     * 商品id
     */

    private Integer id;

    /**
     * 商品价格
     */
    private Double shopPrice;
    /**
     * 商品数量
     */
    private Integer num;

    public OrderGoodsVo() {
    }

    public OrderGoodsVo(Integer id, Double shopPrice, Integer num) {
        this.id = id;
        this.shopPrice = shopPrice;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
