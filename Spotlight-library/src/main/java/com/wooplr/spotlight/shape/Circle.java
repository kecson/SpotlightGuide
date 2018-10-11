package com.wooplr.spotlight.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import com.wooplr.spotlight.target.Target;

/**
 * Created by jitender on 10/06/16.
 */
public class Circle extends Shape {

    //    Target target;
    int radius;
    Point circlePoint;

    public Circle(Target target) {
        this(target, 20);
    }

    public Circle(Target target, int padding) {
        super(target, padding);
    }

    public void draw(Canvas canvas, Paint eraser, int padding) {
        calculateRadius(padding);
        circlePoint = getFocusPoint();
        canvas.drawCircle(circlePoint.x, circlePoint.y, radius, eraser);
    }

    private Point getFocusPoint() {

        return target.getPoint();
    }

    public void reCalculateAll() {
        calculateRadius(padding);
        circlePoint = getFocusPoint();
    }

    private void calculateRadius(int padding) {
        int side;
        int minSide = Math.min(target.getRect().width() / 2, target.getRect().height() / 2);
        int maxSide = Math.max(target.getRect().width() / 2, target.getRect().height() / 2);
        side = (minSide + maxSide) / 2;
        radius = side + padding;
    }


    public Point getPoint() {
        return circlePoint;
    }

    @Override
    public int getHeight() {
        return 2 * radius;
    }

    @Override
    public boolean isTouchOnFocus(double touchX, double touchY) {
        int xV = circlePoint.x;
        int yV = circlePoint.y;
        double dx = Math.pow(touchX - xV, 2);
        double dy = Math.pow(touchY - yV, 2);

        boolean isTouchOnFocus = (dx + dy) <= Math.pow(radius, 2);
        return isTouchOnFocus;
    }
}
