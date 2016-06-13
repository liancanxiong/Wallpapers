package com.brilliantbear.wallpapers.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.brilliantbear.wallpapers.bean.ResultBean;
import com.google.gson.Gson;

/**
 * Created by Bear on 2016-6-14.
 */
public class LocalCacheModel implements ICacheModel<ResultBean> {

    private Context context;
    private final SharedPreferences sp;

    public LocalCacheModel(Context context) {
        this.context = context;
        sp = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public void setCache(ResultBean cache) {
        if (cache == null) {
            return;
        }
        Gson gson = new Gson();
        String s = gson.toJson(cache);
        sp.edit().putString("cache", s).apply();
    }

    @Override
    public ResultBean getCache() {
        String cache = sp.getString("cache", null);
        if (TextUtils.isEmpty(cache))
            return null;
        Gson gson = new Gson();
        return gson.fromJson(cache, ResultBean.class);
    }
}
