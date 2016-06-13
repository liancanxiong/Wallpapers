package com.brilliantbear.wallpapers.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.brilliantbear.wallpapers.DownloadService;
import com.brilliantbear.wallpapers.bean.ResultBean;
import com.brilliantbear.wallpapers.model.IModel;
import com.brilliantbear.wallpapers.model.ModelCompl;
import com.brilliantbear.wallpapers.model.OnGetDataListener;
import com.brilliantbear.wallpapers.view.IView;

/**
 * Created by Bear on 2016-6-12.
 */
public class PresenterCompl implements IPresenter, OnGetDataListener<ResultBean> {

    private IView<ResultBean> view;
    private IModel model;
    private Context context;

    public PresenterCompl(Context context, IView<ResultBean> view) {
        this.view = view;
        this.context = context;
        model = new ModelCompl(this);
    }

    @Override
    public void getData(int offset) {
        model.getData(offset);
    }

    @Override
    public void setWallpaper(String url) {
        Intent intent = new Intent(context, DownloadService.class);
        intent.putExtra("url", url);
        context.startService(intent);
    }

    @Override
    public void onSuccess(ResultBean data) {
        Log.d("TAG", data.toString());
        view.showData(data);
        view.hideProgress();
    }

    @Override
    public void onFailure(String sth) {
        Log.e("TAG", sth);
        view.hideProgress();
    }
}
