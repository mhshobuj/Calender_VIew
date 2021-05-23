package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CalendarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public final TextView dayOfMonth;
    private final CalendarAdapter.onItemListener onItemListener;

    public CalendarViewHolder(View itemView, CalendarAdapter.onItemListener onItemListener) {
        super(itemView);

        dayOfMonth = itemView.findViewById(R.id.monthOfDay);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onItemListener.onItemClick(getAdapterPosition(), (String) dayOfMonth.getText());
    }
}
