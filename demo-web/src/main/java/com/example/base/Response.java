package com.example.base;

public class Response {
    private Object data;

    private Integer resultCode;

    private String resultDesc;

    public static Response builder() {
        return new Response();
    }

    public Response success() {
        this.setResultDesc("执行成功！");
        this.setResultCode(1);
        return this;
    }

    public Response error() {
        this.setResultDesc("执行出错！");
        this.setResultCode(0);
        return this;
    }

    public Response data(Object data) {
        this.setData(data);
        return this;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }
}
