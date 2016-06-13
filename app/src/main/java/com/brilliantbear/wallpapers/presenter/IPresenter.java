package com.brilliantbear.wallpapers.presenter;

/**
 * Created by Bear on 2016-6-12.
 */
public interface IPresenter<T> {
    void getData(int offset);

    void setWallpaper(String url);

    T getCache();
}
