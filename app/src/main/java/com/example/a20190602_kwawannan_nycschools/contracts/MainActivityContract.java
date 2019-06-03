package com.example.a20190602_kwawannan_nycschools.contracts;

import com.example.a20190602_kwawannan_nycschools.model.HighSchool;

import java.util.List;

/**
 * Contract for MVP layer
 */

public interface MainActivityContract {

    interface View {
        void  initMainActivity();
        void updateSchoolList(List<HighSchool> schools);
    }

    interface Presenter {
        void addView(View view);

        void getNycSchools();


    }
}