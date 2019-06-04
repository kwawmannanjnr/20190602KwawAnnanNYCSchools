package com.example.a20190602_kwawannan_nycschools.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.a20190602_kwawannan_nycschools.adapter.ResultsAdapter;
import com.example.a20190602_kwawannan_nycschools.contracts.MainActivityContract;
import com.example.a20190602_kwawannan_nycschools.model.HighSchool;
import com.example.a20190602_kwawannan_nycschools.model.SatScore;
import com.example.a20190602_kwawannan_nycschools.presenter.MainActivityPresenter;
import com.example.a20190602_kwawannan_nycschools.R;


import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    String LOG_TAG;

    MainActivityPresenter presenter;

    RecyclerView recyclerView;

    ProgressBar progressBar;

    ResultsAdapter resultsAdapter;
    //    private List<HighSchool> highSchoolList;
    private List<SatScore> satScoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Store name of the activity
        LOG_TAG = this.getLocalClassName();

        presenter = new MainActivityPresenter();
        presenter.addView(this);
        presenter.initView();
        presenter.initService();
        presenter.getNycSchools();

    }

    @Override
    public void initMainActivity() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        final GridLayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        progressBar = (ProgressBar) findViewById(R.id.showSpinner);
    }

    @Override
    public void updateSchoolList(List<HighSchool> schools) {
        resultsAdapter = new ResultsAdapter(schools);
        recyclerView.setAdapter(resultsAdapter);
        recyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showToast(String text, int duration) {
        Toast.makeText(this,text,duration).show();

    }
}
