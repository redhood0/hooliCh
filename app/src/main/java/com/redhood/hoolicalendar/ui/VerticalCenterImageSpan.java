package com.redhood.hoolicalendar.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.util.Log;

import com.redhood.hoolicalendar.R;

import androidx.annotation.NonNull;

public class VerticalCenterImageSpan extends ImageSpan {
    public VerticalCenterImageSpan(@NonNull Drawable drawable) {
        super(drawable);
    }

    @Override
    public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
//        super.draw(canvas, text, start, end, x, top, y, bottom, paint);
        Drawable drawable = getDrawable();
        Paint.FontMetricsInt fm = paint.getFontMetricsInt();
        int translateY = (y + fm.ascent + y + fm.descent)/2 - drawable.getBounds().bottom/2;
//        canvas.scale((float) 0.5,(float)0.5);
        Log.e("width", "draw:canvas.getWidth() "+canvas.getWidth());
        Paint paint1 = new Paint();

        canvas.save();
        canvas.translate(x,translateY);
        drawable.draw(canvas);
        canvas.restore();
//        paint1.setARGB(255,0,255,255);
//        canvas.drawRect(new Rect(0,0,40,40),paint1);
    }
}
