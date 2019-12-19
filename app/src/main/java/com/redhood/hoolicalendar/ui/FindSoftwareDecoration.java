package com.redhood.hoolicalendar.ui;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FindSoftwareDecoration extends RecyclerView.ItemDecoration {
    private int space;
    public FindSoftwareDecoration(int space) {
        this.space = space;
    }
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int childCount = parent.getChildCount();

        if(childCount%2 != 0){
            outRect.right = space;
            Log.e("ss", "right: c"+childCount );
        }else {
            outRect.left = space;
            Log.e("ss", "left: c"+childCount );
        }
        outRect.bottom = space;
        outRect.top = space;
//        super.getItemOffsets(outRect, view, parent, state);
    }
}
