package com.edukatrip.edukatrip.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRandomGridView extends GridView {

    public CustomRandomGridView(Context context) {
        super(context);
    }

    public CustomRandomGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRandomGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomRandomGridView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = heightMeasureSpec;
        if (getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT){
            height = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        }
        super.onMeasure(widthMeasureSpec, height);
    }
}
