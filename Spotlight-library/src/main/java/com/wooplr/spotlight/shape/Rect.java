package com.wooplr.spotlight.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;

import com.wooplr.spotlight.target.Target;

/**
 * @author chenKeSheng
 * @version V1.0
 * @date 2018-10-10 15:16
 */
public class Rect extends Shape {
    public Rect(Target target, int padding) {
        super(target, padding);
        this.calculateAdjustedRect();
    }

    RectF adjustedRect;

    public Rect(Target target) {
        this(target, 1);

    }

    @Override
    public void draw(Canvas canvas, Paint eraser, int padding) {
        calculateAdjustedRect();
        canvas.drawRoundRect(this.adjustedRect, (float) padding, (float) padding, eraser);
    }

    private void calculateAdjustedRect() {
        RectF rect = new RectF();
        rect.set(this.target.getRect());
        rect.left -= (float) this.padding;
        rect.top -= (float) this.padding;
        rect.right += (float) this.padding;
        rect.bottom += (float) this.padding;
        this.adjustedRect = rect;
    }


    public void reCalculateAll() {
        this.calculateAdjustedRect();
    }

    public Point getPoint() {
        return this.target.getPoint();
    }

    public int getHeight() {
        return (int) this.adjustedRect.height();
    }

    @Override
    public boolean isTouchOnFocus(double touchX, double touchY) {
        return adjustedRect.contains((float) touchX, (float) touchY);
    }
}
