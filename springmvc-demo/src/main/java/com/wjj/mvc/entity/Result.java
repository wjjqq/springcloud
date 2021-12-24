package com.wjj.mvc.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author wjj
 * @create 2021/12/24
 * @Description
 */
@Data
public class Result<T> {
    private String code;
    private String msg;
    private Object data;
    private List<T> list;

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(String code, String msg, List<T> list) {
        this.code = code;
        this.msg = msg;
        this.list = list;
    }
}
