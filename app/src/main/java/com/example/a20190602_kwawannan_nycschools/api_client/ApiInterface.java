package com.example.a20190602_kwawannan_nycschools.api_client;

import com.example.a20190602_kwawannan_nycschools.model.HighSchool;
import com.example.a20190602_kwawannan_nycschools.model.SatScore;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("s3k6-pzi2.json")
    Call<List<HighSchool>> getHighSchools();

    @GET("f9bf-2cp4.json")
    Call<List<SatScore>> getSatScores();


}
