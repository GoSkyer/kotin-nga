package com.huangbo.baseprojecet.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by huangb on 2017/5/10.
 * 默认返回实体类
 */

public class BaseBean<T> implements Serializable {
    private T data;
    private String message;
    private int code;
    private List<T> list;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
