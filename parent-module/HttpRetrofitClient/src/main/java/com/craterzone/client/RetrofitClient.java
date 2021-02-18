package com.craterzone.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface RetrofitClient {

	@GET("api/v1/users/")
	Call<Object> listrepos(@Header("Authorization") String accessToken);
}
