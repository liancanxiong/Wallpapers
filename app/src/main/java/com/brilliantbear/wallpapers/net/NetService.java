package com.brilliantbear.wallpapers.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Bear on 2016-6-12.
 */
public interface NetService {
    @GET("desktop_mobile")
    Call<ResponseBody> getData(@Query("offset") int offset, @Query("limit") int limit);
}

