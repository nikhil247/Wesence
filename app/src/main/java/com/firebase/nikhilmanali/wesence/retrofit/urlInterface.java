package com.firebase.nikhilmanali.wesence.retrofit;

import com.firebase.nikhilmanali.wesence.jsonSchema.jsonData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface urlInterface {



    @GET("feed/wall-of-fame")
    Call<jsonData> getJson(@Query("page") String page);






}
