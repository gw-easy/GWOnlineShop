package com.gw.gwdemo.util;

import java.util.HashMap;
import java.util.Map;

public class ResultMsg {
    public static ResultMsg success(String msg) {
        ResultMsg result = new ResultMsg();
        result.setResultCode(100);
        result.setMessage(msg);
        return result;
    }

    public static ResultMsg fail(String msg) {
        ResultMsg result = new ResultMsg();
        result.setResultCode(200);
        result.setMessage(msg);
        return result;
    }

    public ResultMsg add(String key, Object value) {
        this.getInfo().put(key, value);
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

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }

    //提示信息
    private String message;

    //数据
    private Map<String, Object> info = new HashMap<String, Object>();
}
