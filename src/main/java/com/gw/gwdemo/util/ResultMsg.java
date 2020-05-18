package com.gw.gwdemo.util;

import java.util.HashMap;
import java.util.Map;

public class ResultMsg {
    public static ResultMsg success(String msg) {
        ResultMsg result = new ResultMsg();
        result.setResultCode(0);
        result.setMessage(msg);
        return result;
    }

    public static ResultMsg fail(String msg) {
        ResultMsg result = new ResultMsg();
        result.setResultCode(1);
        result.setMessage(msg);
        return result;
    }

    public ResultMsg add(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }

    //100-success,200-fail
    private int resultCode;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    //提示信息
    private String message;

    //数据
    private Map<String, Object> data = new HashMap<String, Object>();
}
