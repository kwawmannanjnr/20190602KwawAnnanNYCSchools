package com.example.a20190602_kwawannan_nycschools.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.a20190602_kwawannan_nycschools.contracts.MainActivityContract;
import com.example.a20190602_kwawannan_nycschools.model.HighSchool;
import com.example.a20190602_kwawannan_nycschools.model.SatScore;
import com.example.a20190602_kwawannan_nycschools.view.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        adapter = null;
        mockView = null;
    }

    @Test
    public void onCreateViewHolder() {

//        TestableCandiesListAdapter testableAdapter = new TestableCandiesListAdapter(Arrays.asList(new HighSchool()));
//        testableAdapter.setMockView(mockView);
//        ResultsAdapter.mVH candyViewHolder = testableAdapter.onCreateViewHolder(new FrameLayout(RuntimeEnvironment.application), 0);
//        assertThat(candyViewHolder.itemView).isSameAs(mockView);
//    }
//    static class TestableCandiesListAdapter extends ResultsAdapter {
//        public MainActivityContract.View mockView;
//
//        public TestableCandiesListAdapter(List<HighSchool> c) {
//            super(c);
//        }
//
//        public void setMockView(MainActivityContract.View mockView) {
//            this.mockView = mockView;
//        }
//
//        public MainActivityContract.View getLayout(ViewGroup parent) {
//            return mockView;
//        }
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
        HighSchool firstHighSchool = new HighSchool();
        HighSchool secondHighSchool = new HighSchool();
        adapter.setC(asList(firstHighSchool, secondHighSchool));
        assertEquals(adapter.getItemAtPosition(0), firstHighSchool);
        assertEquals(adapter.getItemAtPosition(1), secondHighSchool);
    }
}