package com.chiiiplow.post.entity.enums;

/**
 *
 * 返回枚举
 * @author CHIIIPLOW
 * @date 2023/09/10
 */
public enum Response {



    CODE_200(200,"成功"),

    CODE_400(400,"请求参数错误"),

    CODE_401(401,"未授权"),


    CODE_403(403,"禁止访问"),

    CODE_404(404,"请求资源不存在"),



    CODE_500(500,"服务器内部错误");
    /**
     *	状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String message;

    Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }




}
