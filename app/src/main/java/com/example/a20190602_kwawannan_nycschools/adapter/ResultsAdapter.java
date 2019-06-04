package com.example.a20190602_kwawannan_nycschools.adapter;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a20190602_kwawannan_nycschools.model.HighSchool;
import com.example.a20190602_kwawannan_nycschools.R;
import com.example.a20190602_kwawannan_nycschools.view.SatScoreActivity;

import java.util.HashMap;
import java.util.List;


/**
 * Created by Kwaw Annan on 5/1/2019.
 */

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.mVH> {

    public Context ctx;

    public HashMap<String, String> schoolNameToSize = new HashMap<String, String>();
    Toast toast;

    public ResultsAdapter(List<HighSchool> c) {

        this.c = c;


        putSizeToSchoolInMap(c);


    }

    private void putSizeToSchoolInMap(List<HighSchool> c) {
        for (HighSchool nycSchool : c) {
            schoolNameToSize.put(nycSchool.getSchoolName(), nycSchool.getTotalStudents());
        }
    }

    private String[] myData;

    public List<HighSchool> getC() {
        return c;
    }

    public void setC(List<HighSchool> c) {
        this.c = c;
    }

    private List<HighSchool> c;


    @Override
    public mVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ctx = parent.getContext();
        return new mVH(itemView);
    }

    @Override
    public void onBindViewHolder(mVH holder, final int position) {

        holder.mText.setText(c.get(position).getSchoolName());
        holder.distance.setText("Total Students : " + c.get(position).getTotalStudents());
        holder.website.setText("Website: " + c.get(position).getWebsite());
        holder.city.setText("City : " + c.get(position).getCity());
        Double d = Double.valueOf(c.get(position).getAttendanceRate());
        getRating(holder, d);

        final String schoolName = c.get(position).getSchoolName();
        final String schoolID = c.get(position).getDbn();

        holder.cLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Kwaw Annan", c.get(position).getSchoolName());
                Intent intent = new Intent(ctx, SatScoreActivity.class);
                intent.putExtra("schoolName", schoolName);
                intent.putExtra("schoolID", schoolID);
                Bundle extras = new Bundle();
                extras.putSerializable("ratios", schoolNameToSize);
                intent.putExtras(extras);
                ctx.startActivity(intent);
            }
        });

    }

    private void getRating(mVH holder, Double d) {
        if (d != null) {

            if (d > .95) {
                holder.ratingBar.setRating(new Float(5.0));
            } else if (d > .85) {
                holder.ratingBar.setRating(new Float(4.0));
            } else if (d > .75) {
                holder.ratingBar.setRating(new Float(3.0));
            } else if (d > .65) {
                holder.ratingBar.setRating(new Float(2.0));
            } else if (d > .55) {
                holder.ratingBar.setRating(new Float(1.0));
            }

            Log.d("Double", " " + d);

        }
    }

    public HighSchool getItemAtPosition(int position) {
        return c.get(position);
    }



    @Override
    public int getItemCount() {
        // return myData.length;s
        return c.size();
    }

    public class mVH extends RecyclerView.ViewHolder {

        public TextView mText;


        public RatingBar ratingBar;

        public TextView distance;

        public TextView website;

        public TextView city;

        public ConstraintLayout cLL;


        public mVH(View itemView) {
            super(itemView);
            mText = (TextView) itemView.findViewById(R.id.schoolName);
            city = (TextView) itemView.findViewById(R.id.city);
            cLL = (ConstraintLayout) itemView.findViewById(R.id.parentLayout);
            website = (TextView) itemView.findViewById(R.id.website);
            ratingBar = (RatingBar) itemView.findViewById(R.id.restaurantRating);
            distance = (TextView) itemView.findViewById(R.id.distance);
            LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
            stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        }
    }


    public void showAToast(String st) { //"Toast toast" is declared in the class
        try {
            toast.getView().isShown();     // true if visible
            toast.setText(st);
        } catch (Exception e) {         // invisible if exception
            toast = Toast.makeText(ctx, st, Toast.LENGTH_SHORT);
        }
        toast.show();  //finally display it
    }


}
