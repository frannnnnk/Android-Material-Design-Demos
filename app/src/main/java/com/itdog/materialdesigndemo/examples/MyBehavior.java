package com.itdog.materialdesigndemo.examples;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.itdog.materialdesigndemo.R;

/**
 * Created by Administrator on 2017/12/3 0003.
 */

public class MyBehavior extends CoordinatorLayout.Behavior<View> {

    private static final String TAG = "MyBehavior";

    private int offsetTotal = 0;

    private boolean scrolling = false;

    public MyBehavior() {
        super();
    }

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        offset(child, dyConsumed);
    }

    public void offset(View child, int dy) {
        int old = offsetTotal;
        int top = offsetTotal - dy;
        top = Math.min(0, Math.max(top, -child.getHeight()));
        offsetTotal = top;
        if (old == offsetTotal) {
            scrolling = false;
            return;
        }
        int delta = offsetTotal - old;
        child.offsetTopAndBottom(delta);
        scrolling = true;

        Log.i(TAG, "offset: " + String.format("old = %d, dy = %d, new = %d.", old, dy, offsetTotal));
    }
}
