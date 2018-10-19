package com.wooplr.spotlight.target;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by jitender on 10/06/16.
 */
public class ViewTarget implements Target {

    private View view;

    private int[] mLastLocation = new int[2];

    public ViewTarget(View view) {
        this.view = view;
    }

    @Override
    public Point getPoint() {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        /*
         * 修复View在ListView中，在{@link com.wooplr.spotlight.SpotlightView#show(Activity)} 之后，
         * 再调用{@link android.widget.BaseAdapterr#notifyDataSetChanged} 之后，View被刷新后可能获取不到View的坐标的问题
         * */
        //可能没有绑定View显示到窗口
        if (location[0] == 0 && location[1] == 0) {
            location[0] = mLastLocation[0];
            location[1] = mLastLocation[1];
        } else {
            //保存上一次的坐标
            mLastLocation[0] = location[0];
            mLastLocation[1] = location[1];
        }
        return new Point(location[0] + (view.getWidth() / 2), location[1] + (view.getHeight() / 2));
    }

    @Override
    public Rect getRect() {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        /*
         * 修复View在ListView中，在{@link com.wooplr.spotlight.SpotlightView#show(Activity)} 之后，
         * 再调用{@link android.widget.BaseAdapterr#notifyDataSetChanged} 之后，View被刷新后可能获取不到View的坐标的问题
         * */
        //可能没有绑定View显示到窗口
        if (location[0] == 0 && location[1] == 0) {
            location[0] = mLastLocation[0];
            location[1] = mLastLocation[1];
        } else {
            //保存上一次的坐标
            mLastLocation[0] = location[0];
            mLastLocation[1] = location[1];
        }
        return new Rect(
                location[0],
                location[1],
                location[0] + view.getWidth(),
                location[1] + view.getHeight()
        );
    }


    @Override
    public View getView() {
        return view;
    }

    @Override
    public int getViewLeft() {
        return getRect().left;
    }

    @Override
    public int getViewRight() {
        return getRect().right;
    }

    @Override
    public int getViewBottom() {
        return getRect().bottom;
    }

    @Override
    public int getViewTop() {
        return getRect().top;
    }

    @Override
    public int getViewWidth() {
        return view.getWidth();
    }

    @Override
    public int getViewHeight() {
        return view.getHeight();
    }
}
