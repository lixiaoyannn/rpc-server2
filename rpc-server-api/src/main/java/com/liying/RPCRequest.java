package com.liying;

import java.io.Serializable;

/**
 * 创建者:小䶮
 */
public class RPCRequest implements Serializable{
    private String classname;
    private String mothodName;
    private Object[] prams;

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getMothodName() {
        return mothodName;
    }

    public void setMothodName(String mothodName) {
        this.mothodName = mothodName;
    }

    public Object[] getPrams() {
        return prams;
    }

    public void setPrams(Object[] prams) {
        this.prams = prams;
    }
}
