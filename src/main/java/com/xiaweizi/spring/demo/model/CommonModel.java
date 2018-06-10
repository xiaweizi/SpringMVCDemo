package com.xiaweizi.spring.demo.model;

import com.xiaweizi.spring.demo.util.ConstantUtil;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : com.xiaweizi.spring.demo.model.CommonModel
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/05/22
 *     desc   :
 * </pre>
 */

public class CommonModel {

    private int code;
    //msg
    private String msg;
    //可以单个对象或List
    private Object data;

    public Object getObject() {
        return data;
    }

    public void setObject(Object object) {
        this.data = object;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setSuccess() {
        setCode(ConstantUtil.CODE_SUCCESS);
        setMsg(ConstantUtil.MSG_SUCCESS);
    }

    public void setFail() {
        setCode(ConstantUtil.CODE_FAIL);
        setMsg(ConstantUtil.MSG_FAIL);
    }
}
