package com.edukatrip.edukatrip.detailwisata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.edukatrip.edukatrip.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class DetailReviewsAdapter extends RecyclerView.Adapter<DetailReviewsAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<Reviews> data;

    public DetailReviewsAdapter(Context context, List<Reviews> reviews) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.data = reviews;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.ratings_and_reviews_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtReview.setText(data.get(position).getReviews());
        holder.txtName.setText(data.get(position).getName());

        int star = data.get(position).getRate();
        holder.bintang.removeAllViews();
        for (int i=0;i<star;i++){
            ImageView imgBintang = new ImageView(context);
            imgBintang.setImageResource(R.drawable.star);

            int size = context.getResources().getDimensionPixelSize(R.dimen.star_size);
            int margin = context.getResources().getDimensionPixelSize(R.dimen.star_margin);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(size,size);
            marginLayoutParams.rightMargin = margin;
            imgBintang.setLayoutParams(marginLayoutParams);
            holder.bintang.addView(imgBintang);

        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtReview;
        TextView txtName;
        LinearLayout bintang;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtReview = (TextView)itemView.findViewById(R.id.reviews_text);
            txtName = (TextView)itemView.findViewById(R.id.reviews_name);
            bintang = (LinearLayout)itemView.findViewById(R.id.reviews_star);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
