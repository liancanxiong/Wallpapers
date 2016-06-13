package com.brilliantbear.wallpapers.view;

/**
 * Created by Bear on 2016-6-12.
 */
public interface IView<T> {
    void showProgress();

    void hideProgress();

    void showData(T data);

    void showSth(String sth);
}
