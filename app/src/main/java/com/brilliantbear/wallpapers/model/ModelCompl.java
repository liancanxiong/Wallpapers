package com.brilliantbear.wallpapers.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.brilliantbear.wallpapers.bean.ResultBean;
import com.brilliantbear.wallpapers.net.Net;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bear on 2016-6-12.
 */
public class ModelCompl implements IModel {

    private Net mNet;
    private OnGetDataListener<ResultBean> listener;

    public ModelCompl(OnGetDataListener<ResultBean> listener) {
        mNet = Net.getInstance();
        this.listener = listener;
    }

    @Override
    public void getData(int offset) {
        mNet.getData(offset, new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (!response.isSuccessful()) {
                    listener.onFailure("error");
                    return;
                }
                String result = null;
                try {
                    result = response.body().string();
                } catch (IOException e) {
                    listener.onFailure("error");
                    e.printStackTrace();
                    return;
                }
                Gson gson = new Gson();
                ResultBean resultBean = gson.fromJson(result, ResultBean.class);
                listener.onSuccess(resultBean);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.onFailure(t.toString());
            }
        });
    }

}
