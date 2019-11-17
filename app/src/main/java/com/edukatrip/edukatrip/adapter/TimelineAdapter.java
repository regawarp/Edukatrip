package com.edukatrip.edukatrip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.edukatrip.edukatrip.R;
import com.edukatrip.edukatrip.model.Timeline;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> {
    private List<Timeline> Data;
    private Context context;
    private LayoutInflater inflater;
    private Boolean custom = false;

    public TimelineAdapter(Context context, List<Timeline> data,Boolean custom) {
        this.Data = data;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.custom = custom;
    }
    public TimelineAdapter(Context context, List<Timeline> data) {
        this.Data = data;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.timeline_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (!custom){
            holder.edit.setVisibility(View.GONE);
        }

        holder.time.setText(Data.get(position).getDatetoText());
        holder.title.setText(Data.get(position).getDestination().getName());
        holder.location.setText(Data.get(position).getDestination().getLocation());
        holder.image.setImageResource(Data.get(position).getDestination().getImage());
        holder.description.setText(Data.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView time;
        TextView title;
        TextView location;
        ImageView image;
        TextView description;
        Button edit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            time = (TextView)itemView.findViewById(R.id.timeline_time);
            title = (TextView)itemView.findViewById(R.id.timeline_title);
            location = (TextView)itemView.findViewById(R.id.timeline_location);
            description = (TextView)itemView.findViewById(R.id.timeline_text);
            image = (ImageView)itemView.findViewById(R.id.timeline_image);
            edit = (Button)itemView.findViewById(R.id.timeline_edit);
        }
    }
}
