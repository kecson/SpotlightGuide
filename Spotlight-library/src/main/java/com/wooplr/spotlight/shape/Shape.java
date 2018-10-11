package com.wooplr.spotlight.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import com.wooplr.spotlight.target.Target;

/**
 * @author chenKeSheng
 * @version V1.0
 * @date 2018-10-10 16:12
 */
public abstract class Shape {
    protected Target target;
    protected int padding;

    public Shape(Target target) {
        this(target, 1);
    }

    public Shape(Target target, int padding) {
        this.target = target;
        this.padding = padding;
        reCalculateAll();
    }


    public abstract void draw(Canvas var1, Paint var2, int var3);


    public abstract void reCalculateAll();

    public Point getPoint() {return target.getPoint();}


    public abstract int getHeight();

    public abstract boolean isTouchOnFocus(double touchX, double touchY);
}
