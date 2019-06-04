package com.example.a20190602_kwawannan_nycschools.presenter;

import android.support.annotation.NonNull;

import com.example.a20190602_kwawannan_nycschools.api_client.ApiClient;
import com.example.a20190602_kwawannan_nycschools.api_client.ApiInterface;
import com.example.a20190602_kwawannan_nycschools.contracts.SatScoreContract;
import com.example.a20190602_kwawannan_nycschools.model.SatScore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class SatScorePresenterTest {
    @Mock
    private SatScoreContract.View view;
    @Mock
    ApiInterface service1;
    @Captor
    private ArgumentCaptor<Call<List<SatScore>>> callbackArgumentCaptor;

    SatScorePresenter satScorePresenter;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        MockitoAnnotations.initMocks(ApiInterface.class);
        satScorePresenter = new SatScorePresenter();
        satScorePresenter.addView(view);
    }

    @After
    public void tearDown() throws Exception {
        view = null;
        service1 = null;
        satScorePresenter = null;
    }

    @Test
    public void addView() {


        view.initSatScoreActivityViews();
        verify(view).initSatScoreActivityViews();
    }

    @Test
    public void initView() {
        satScorePresenter.addView(view);
        assertNotNull(satScorePresenter.view);
    }

    @Test
    public void initService() {
        assertNotNull(service1);

    }

    @Test
    public void loadDetails() {
        satScorePresenter = new SatScorePresenter();
        satScorePresenter.LoadDetails("7134");
        assertNotEquals(satScorePresenter.satScores.size(),satScorePresenter.getMap().size());
    }


}