package com.edukatrip.edukatrip.detailedutour;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.edukatrip.edukatrip.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {
    private Context context;
    private int[] data;
    private LayoutInflater inflater;

    public ImageAdapter(Context context, int[] data) {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.detail_edu_image_item,parent,false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
        Picasso.get()
                .load(data[position])
                .resize(250,250)
                .centerCrop().
                into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ImageHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.detail_edu_image_galery);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
