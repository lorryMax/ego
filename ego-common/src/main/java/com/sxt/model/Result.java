package com.sxt.model;

/**
 * Result
 */

public class Result {

    private Integer status;
    private String msg;
    private Object data;


    public static  Result error(Integer status ,String msg){
        Result result =new Result();
        result.setStatus(status);
        result.setMsg("msg");
        return result;
    }


    public static  Result error(){
        Result result =new Result();
        result.setStatus(400);
        result.setMsg("fail");
        return result;
    }



    public static Result ok(Integer status ,String msg) {
        Result result =new Result();
        result.setStatus(status);
        result.setMsg(msg);
        return result;
    }

    public static Result ok(Object data) {
        Result result = new Result();
        result.setStatus(200);
        result.setMsg("ok");
        result.setData(data);
        return result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
