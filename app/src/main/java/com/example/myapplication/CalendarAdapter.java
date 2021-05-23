package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.PrimitiveIterator;
import java.util.Random;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder> {

    private final ArrayList<String> daysOfMonth;
    private final onItemListener onItemListener;
    private Context context;

    public CalendarAdapter(ArrayList<String> daysOfMonth, CalendarAdapter.onItemListener onItemListener) {
        this.daysOfMonth = daysOfMonth;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.calender_cell, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight() * 0.08);
        return new CalendarViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        holder.dayOfMonth.setText(daysOfMonth.get(position));
        holder.dayOfMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.dayOfMonth.setTextColor(Color.parseColor("#FFFFFF"));
                holder.dayOfMonth.setBackgroundResource(R.drawable.circle);
                holder.dayOfMonth.setGravity(Gravity.CENTER);
            }
        });
    }

    @Override
    public int getItemCount() {
        return daysOfMonth.size();
    }

    public interface onItemListener{
        void onItemClick(int position, String dayText);
    }
}
