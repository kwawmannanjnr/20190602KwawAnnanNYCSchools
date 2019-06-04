package com.example.a20190602_kwawannan_nycschools.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a20190602_kwawannan_nycschools.contracts.SatScoreContract;
import com.example.a20190602_kwawannan_nycschools.model.SatScore;
import com.example.a20190602_kwawannan_nycschools.presenter.SatScorePresenter;
import com.example.a20190602_kwawannan_nycschools.R;


public class SatScoreActivity extends AppCompatActivity implements SatScoreContract.View {
    private String LOG_TAG;

    private TextView highSchoolNameTextView;
    private TextView mathSatScoreTextView;
    private TextView readingSatScoreTextView;
    private TextView writingSatScoreTextView;

    private SatScorePresenter satScorePresenter;
    static String schoolId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LOG_TAG = this.getLocalClassName();
        setContentView(R.layout.activity_sat_score);
        satScorePresenter = new SatScorePresenter();
        satScorePresenter.addView(this);
        satScorePresenter.initView();


        satScorePresenter.initService();
        schoolId = getIntent().getStringExtra("schoolID");
        satScorePresenter.LoadDetails(schoolId);



    }




    public void initSatScoreActivityViews() {
        highSchoolNameTextView = findViewById(R.id.high_school_name);
        mathSatScoreTextView = findViewById(R.id.sat_Score);
        readingSatScoreTextView = findViewById(R.id.reading_sat_score);
        writingSatScoreTextView = findViewById(R.id.writing_sat_score);
    }

    @Override
    public void updateSuccess(SatScore score) {
        Toast.makeText(this, score.getSchoolName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setSatScore(SatScore satScore) {
        highSchoolNameTextView.setText("School Name: " + satScore.getSchoolName());
        mathSatScoreTextView.setText("SAT Math Score: " + satScore.getSatMathAvgScore());
        readingSatScoreTextView.setText("SAT Reading Score: " + satScore.getSatCriticalReadingAvgScore());
        writingSatScoreTextView.setText("SAT Writing Avg Score " + satScore.getSatWritingAvgScore());
    }
}
