package com.brilliantbear.wallpapers.model;

/**
 * Created by Bear on 2016-6-14.
 */
public interface ICacheModel<T> {

    void setCache(T cache);

    T getCache();
}
