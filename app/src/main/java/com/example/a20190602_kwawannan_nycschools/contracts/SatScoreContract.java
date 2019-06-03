package com.example.a20190602_kwawannan_nycschools.contracts;

import com.example.a20190602_kwawannan_nycschools.model.SatScore;

public interface SatScoreContract {

    interface View {
        void initSatScoreActivityViews();
        void updateSuccess(SatScore score);

        void updateFailure(String message);

        void setSatScore(SatScore score);


    }

    interface Presenter {
        void addView(SatScoreContract.View view);

        void initView();

        void LoadDetails(String schoolID);


    }
}
