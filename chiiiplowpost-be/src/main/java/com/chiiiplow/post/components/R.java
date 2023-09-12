package com.chiiiplow.post.components;

import com.chiiiplow.post.entity.enums.Response;
import lombok.Data;

import java.io.Serializable;

@Data
public class R implements Serializable {

	private static final long serialVersionUID = 1L;

    /***
     * 状态码
     */
    private int code;
    /**
     * 返回数据
     */
    private Object data;

    /**
     * 返回信息
     */
    private String msg;


    /**
     *	返回数据总数
     */
    private Long total;

    /**
     * 构造方法
     */
    public R(Response response, Object data, Long total) {
        this.code = response.getCode();
        this.msg = response.getMessage();
        this.data = data;
        this.total = total;
    }

    public R(Response response) {
        this.code = response.getCode();
        this.msg = response.getMessage();
    }

    public R(Response response, Object data) {
        this.code = response.getCode();
        this.msg = response.getMessage();
        this.data = data;
    }

    /**
     * 成功
     * @param total
     * @param data
     * @return
     */
    public static R ok(Response response,Object data,Long total){

        return new R(response,data,total);
    }






    /**
     * 成功
     * @return
     */
    public static R ok(Response response){

        return new R(response);
    }

    public static R ok(Response response,Object data){
        return new R(response,data);
    }



    /**
     * 404失败
     * @return
     */
    public static R fail(Response response){

        return new R(response);
    }








}
