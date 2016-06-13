package com.brilliantbear.wallpapers.bean;

/**
 * Created by Bear on 2016-6-12.
 */
public class ObjectsBean {
    /**
     * email : iam@mronnel.com
     * name : Ronnel Martinez
     * url : http://mronnel.com/
     */

    private CreatorBean creator;
    private String id;
    private String iphone_thumb;
    private String permalink;
    private String title;
    private String url;

    public CreatorBean getCreator() {
        return creator;
    }

    public void setCreator(CreatorBean creator) {
        this.creator = creator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIphone_thumb() {
        return iphone_thumb;
    }

    public void setIphone_thumb(String iphone_thumb) {
        this.iphone_thumb = iphone_thumb;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ObjectsBean{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
