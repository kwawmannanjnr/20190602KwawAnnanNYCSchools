package com.example.a20190602_kwawannan_nycschools.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.a20190602_kwawannan_nycschools.api_client.ApiClient;
import com.example.a20190602_kwawannan_nycschools.api_client.ApiInterface;
import com.example.a20190602_kwawannan_nycschools.api_client.ApiService;
import com.example.a20190602_kwawannan_nycschools.contracts.MainActivityContract;
import com.example.a20190602_kwawannan_nycschools.model.HighSchool;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kwaw Annan on 5/1/2019.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {
    private MainActivityContract.View view;


    ApiInterface service1;


    public void addView(MainActivityContract.View view) {
        this.view = view;
    }

    public void initView() {
        view.initMainActivity();
    }

    public void initService() {

        service1 = ApiClient.getClient().create(ApiInterface.class);
    }


    public void getNycSchools() {

        Call<List<HighSchool>> highSchooolJsonCall = service1.getHighSchools();


        highSchooolJsonCall.enqueue(new Callback<List<HighSchool>>() {
            @Override
            public void onResponse(Call<List<HighSchool>> call, Response<List<HighSchool>> response) {
                view.updateSchoolList(response.body());
            }

            @Override
            public void onFailure(Call<List<HighSchool>> call, Throwable t) {
                view.showToast("Request Failed. No Data loaded", Toast.LENGTH_SHORT);
                Log.e("MainActivityPresenter",t.getMessage());


            }
        });


    }
}
