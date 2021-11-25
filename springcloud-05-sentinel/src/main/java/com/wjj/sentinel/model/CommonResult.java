package com.wjj.sentinel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author wjj
 * @create 2021/11/23
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> implements Serializable {
    private String errorCode;
    private String message;
    private Object data;
    private List<T> list;

   public CommonResult(String errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
    }

    public CommonResult(String errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public CommonResult(String errorCode, String message, List<T> list) {
        this.errorCode = errorCode;
        this.message = message;
        this.list = list;
    }

}
