package com.craterzone.gateway;

import java.io.IOException;
import org.springframework.stereotype.Component;
import com.craterzone.client.RetrofitClient;
import com.craterzone.config.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitClientGateway {

	RetrofitClient retrofitClient;
	
	public Object getObject(String accessToken) throws IOException{
		Retrofit retrofit = RetrofitConfig.getRetrofitInstance();
		retrofitClient = retrofit.create(RetrofitClient.class);
		Call<Object> retrofitCall = retrofitClient.listrepos(accessToken);
		Response<Object> response = retrofitCall.execute();
		return response.body();
	}
}
