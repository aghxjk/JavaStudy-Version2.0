package com.zym.chapter04;

/**
 * Created by zhaoyimeng on 15/11/13.
 */

//定义编译时异常
public class IllegalNameExp extends Exception{

    private String exceptionMsg;
    private int errCode;

    public IllegalNameExp(String str){

        super(str);
    }

    public IllegalNameExp(String exceptionMsg, int errCode){
        this(exceptionMsg);
        this.setExceptionMsg(exceptionMsg);
        this.setErrCode(errCode);

    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = "[ " + exceptionMsg + " ]" + "名字少于6个字符.";
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
