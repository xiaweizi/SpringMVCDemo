package com.xiaweizi.spring.demo.model;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : com.xiaweizi.spring.demo.model.DeveloperModel
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/05/22
 *     desc   :
 * </pre>
 */

public class DeveloperModel {
    private int id;
    private String name;
    private String site;
    private String avatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
