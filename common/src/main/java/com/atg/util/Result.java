package com.atg.util;


import com.atg.enumerate.ReturnCode;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Result<T> {

    private Integer code;
    private String msg;
    private long timestamp;
    private T data;

    public Result() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> Result<T> success(T data){
        Result res = new Result<>().setCode(ReturnCode.RC200.getCode())
                .setMsg(ReturnCode.RC200.getMessage())
                .setData(data);
        return res;
    }

    public static <T> Result<T> fail(Integer code, String msg){
        Result res = new Result<>().setCode(code)
                .setMsg(msg)
                .setData(null);
        return res;
    }


}
