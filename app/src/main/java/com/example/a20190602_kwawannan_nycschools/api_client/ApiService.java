package com.example.a20190602_kwawannan_nycschools.api_client;

import android.util.Log;

import com.example.a20190602_kwawannan_nycschools.model.HighSchool;
import com.example.a20190602_kwawannan_nycschools.model.SatScore;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiService {

    private String LOG_TAG = this.getClass().getName();

    public List<HighSchool> getHighSchools() {
        return highSchools;
    }

    public void setHighSchools(List<HighSchool> highSchools) {
        this.highSchools = highSchools;
    }

    List<HighSchool> highSchools;
    List<SatScore> satScores;

    ApiInterface service1 = ApiClient.getClient().create(ApiInterface.class);

    public void callHighSchoolService() {


        Call<List<HighSchool>> jsonCall = service1.getHighSchools();


        Log.e(LOG_TAG, "Making first call");

        jsonCall.enqueue(new Callback<List<HighSchool>>() {
            @Override
            public void onResponse(Call<List<HighSchool>> call, Response<List<HighSchool>> response) {
                Log.i(LOG_TAG, response.body().toString());


            }

            @Override
            public void onFailure(Call<List<HighSchool>> call, Throwable t) {
                Log.e(LOG_TAG, t.toString());

            }
        });

        Log.e(LOG_TAG, "Done with first call");
    }

    public void callSatService() {
        final List<SatScore> satScores = null;


        Log.e(LOG_TAG, "Making Second call");

        Call<List<SatScore>> jsonCall2 = service1.getSatScores();
        jsonCall2.enqueue(new Callback<List<SatScore>>() {
            @Override
            public void onResponse(Call<List<SatScore>> call, Response<List<SatScore>> response) {
                Log.i(LOG_TAG, response.body().toString());
                for (SatScore score : response.body()) {
                    satScores.add(score);
                }

            }

            @Override
            public void onFailure(Call<List<SatScore>> call, Throwable t) {
                Log.e(LOG_TAG, t.toString());

            }
        });
        Log.e(LOG_TAG, "Done with Second call");
    }
}
