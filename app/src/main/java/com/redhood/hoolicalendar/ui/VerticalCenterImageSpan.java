package com.redhood.hoolicalendar.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

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
        canvas.save();
        canvas.translate(x,translateY);
        drawable.draw(canvas);
        canvas.restore();
    }
}
