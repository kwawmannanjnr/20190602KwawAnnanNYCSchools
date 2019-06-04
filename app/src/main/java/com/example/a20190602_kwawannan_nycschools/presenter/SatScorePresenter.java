package com.example.a20190602_kwawannan_nycschools.presenter;

import android.util.Log;

import com.example.a20190602_kwawannan_nycschools.api_client.ApiClient;
import com.example.a20190602_kwawannan_nycschools.api_client.ApiInterface;
import com.example.a20190602_kwawannan_nycschools.contracts.SatScoreContract;
import com.example.a20190602_kwawannan_nycschools.model.SatScore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SatScorePresenter implements SatScoreContract.Presenter { 
    SatScoreContract.View view;

    ApiInterface service1 ;

    public Map<String, SatScore> getMap() {
        return map;
    }

    public void setMap(Map<String, SatScore> map) {
        this.map = map;
    }

    Map<String, SatScore> map = new HashMap<>();
    List<SatScore> satScores;
    SatScore mySchool;


    @Override
    public void addView(SatScoreContract.View view) {
        this.view = view;
    }


    public void initView() {
       view.initSatScoreActivityViews();
    }

    public void initService() {
        service1 = ApiClient.getClient().create(ApiInterface.class);
    }


    @Override
    public void LoadDetails(final String schoolId) {

        Call<List<SatScore>> satScoreJsonCall = service1.getSatScores();
        satScoreJsonCall.enqueue(new Callback<List<SatScore>>() {
            @Override
            public void onResponse(Call<List<SatScore>> call, Response<List<SatScore>> response) {
                map = storeAndGetSatScore(response.body());
                satScores = response.body();
                int count = 0;
                for (SatScore satScore : satScores) {
                    if (satScore.getDbn().equalsIgnoreCase(schoolId)) {
                        mySchool = satScore;
                        view.setSatScore(satScore);
                        view.updateSuccess(mySchool);

                        count++;
                    }

                }

                view.updateFailure(count < 1 ? "No Detail found For This School" : "");


            }

            @Override
            public void onFailure(Call<List<SatScore>> call, Throwable t) {
                Log.e("SatScoreLoad", "Failed");
            }
        });
    }

    public SatScore getSatScore(String SchoolId) {
        for (SatScore satScore : this.satScores) {
            if (satScore.getDbn().equals(SchoolId))
                return satScore;

        }

        Log.e("SatScoreLoad", "Failed");

        return null;

    }

    public Map<String, SatScore> storeAndGetSatScore(List<SatScore> response) {


        for (int i = 0; i < response.size(); i++) {
            map.put(response.get(i).getDbn(), response.get(i));

        }
        return map;
    }
}
