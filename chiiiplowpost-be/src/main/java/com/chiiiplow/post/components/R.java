package com.chiiiplow.post.components;

import com.chiiiplow.post.entity.enums.Response;
import lombok.Data;

import java.io.Serializable;

@Data
public class R implements Serializable {

	private static final long serialVersionUID = 1L;

    private Response response;
    /**
     * 返回数据
     */
    private Object data;

    /**
     *	返回数据总数
     */
    private Long total;

    /**
     * 构造方法
     */
    public R(Response response, Object data, Long total) {
        this.response = response;
        this.data = data;
        this.total = total;
    }

    public R(Response response) {
        this.response = response;
    }

    /**
     * 成功
     * @param total
     * @param data
     * @return
     */
    public static R ok(Object data,Long total){

        return new R(Response.CODE_200,data,total);
    }






    /**
     * 成功
     * @return
     */
    public static R ok(){

        return new R(Response.CODE_200);
    }



    /**
     * 404失败
     * @return
     */
    public static R fail(Response response){

        return new R(response);
    }








}
