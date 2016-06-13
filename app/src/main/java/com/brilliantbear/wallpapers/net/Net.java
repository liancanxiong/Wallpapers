package com.brilliantbear.wallpapers.net;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by Bear on 2016-6-12.
 */
public class Net {

    public static final String BASE_URL = "http://api.simpledesktops.com/v1/";
    private static Net mNet;
    private Retrofit mRetrofit;
    private NetService mService;

    private Net() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();
        mService = mRetrofit.create(NetService.class);
    }

    public static Net getInstance() {
        if (mNet == null) {
            synchronized (Net.class) {
                if (mNet == null) {
                    mNet = new Net();
                }
            }
        }
        return mNet;
    }

    public void getData(int offset, Callback<ResponseBody> callback) {
        mService.getData(offset, 10).enqueue(callback);
    }

}
