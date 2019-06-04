package com.example.a20190602_kwawannan_nycschools.adapter;

import com.example.a20190602_kwawannan_nycschools.contracts.MainActivityContract;
import com.example.a20190602_kwawannan_nycschools.model.HighSchool;
import com.example.a20190602_kwawannan_nycschools.model.SatScore;
import com.example.a20190602_kwawannan_nycschools.view.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ResultsAdapterTest {
    private ResultsAdapter adapter;
    private ResultsAdapter.mVH holder;
    private MainActivityContract.View mockView;

    @Before
    public void setUp() throws Exception {
        adapter = new ResultsAdapter(asList(new HighSchool(), new HighSchool()));
        mockView = mock(MainActivity.class);
    }

    @After
    public void tearDown() throws Exception {
        adapter=null;
        mockView=null;
    }

    @Test
    public void onCreateViewHolder() {
    }

    @Test
    public void onBindViewHolder() {
    }

    @Test
    public void getItemCount() {

        HighSchool highSchool = new HighSchool();
        adapter.setC(asList(highSchool, highSchool, highSchool));
        assertEquals(adapter.getItemCount(), 3);


    }
    @Test
    public void getItemAtPosition() {
//        HighSchool firstHighSchool = new HighSchool();
//        HighSchool secondHighSchool = new HighSchool();
//        adapter.setC(asList(firstHighSchool, secondHighSchool));
//        assertThat(adapter.getItemAtPosition(0)).isEqualTo(firstCandy);
//        assertThat(adapter.getItemAtPosition(1)).isEqualTo(secondCandy);
    }
}