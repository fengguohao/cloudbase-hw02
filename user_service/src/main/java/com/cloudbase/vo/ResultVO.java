package com.cloudbase.vo;

/**
 * @author fguohao
 * @date 2021/07/12
 */
public class ResultVO<T> {
    Integer code;
    String msg;
    T data;
    Integer port;

    public ResultVO(){};

    public ResultVO(Integer code, String msg, T data, Integer port) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.port = port;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
