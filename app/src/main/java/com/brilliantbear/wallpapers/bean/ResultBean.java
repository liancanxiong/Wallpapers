package com.brilliantbear.wallpapers.bean;

import java.util.List;

/**
 * Created by Bear on 2016-6-12.
 */
public class ResultBean {

    /**
     * limit : 24
     * next : /v1/desktop_mobile/?offset=24&limit=24&format=json
     * offset : 0
     * previous : null
     * total_count : 1398
     */

    private MetaBean meta;
    /**
     * creator : {"email":"iam@mronnel.com","name":"Ronnel Martinez","url":"http://mronnel.com/"}
     * id : 6172
     * iphone_thumb : http://static.simpledesktops.com/uploads/desktops/2016/04/26/Dots_iphone_thumb.png
     * permalink : /browse/desktops/2016/apr/26/dots
     * title : Dots
     * url : http://static.simpledesktops.com/uploads/desktops/2016/04/26/Dots.png
     */

    private List<ObjectsBean> objects;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public List<ObjectsBean> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectsBean> objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "meta=" + meta +
                ", objects=" + objects +
                '}';
    }
}
