package com.wjj.mvc.exception;

import com.wjj.mvc.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author wjj
 * @create 2021/12/24
 * @Description
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandeler {

    @ExceptionHandler(value = NullPointerException.class)
    public Result handerNullException(Exception e){
        return new Result("500", "空指针异常"+e.getMessage());
    }


    @ExceptionHandler(value = NumberFormatException.class)
    public Result handerNumberFormatException(Exception e){
        return new Result("500", "数字转换异常"+e.getMessage());
    }

}
