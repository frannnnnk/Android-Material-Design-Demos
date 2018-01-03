package com.itdog.materialdesigndemo.examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.itdog.materialdesigndemo.R;
import com.itdog.materialdesigndemo.ScreenUtils;

/**
 * Created by Administrator on 2018/1/2 0002.
 */

public class FitSystemWindowActivity extends AppCompatActivity {

    private static final String TAG = "FitSystemWindowActivity";

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fit_system_window_test);

        getSupportActionBar().hide();

        // 获取状态栏高度
        linearLayout = (LinearLayout) findViewById(R.id.content);

        ViewCompat.setOnApplyWindowInsetsListener(linearLayout, new OnApplyWindowInsetsListener() {
            @Override
            public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
                Log.i(TAG, "onApplyWindowInsets: " + insets.getSystemWindowInsetTop());
                int topPadding = ScreenUtils.getStatusBarHeight(getApplicationContext());
                linearLayout.setPadding(insets.getSystemWindowInsetLeft(), topPadding,
                        insets.getSystemWindowInsetRight(), insets.getSystemWindowInsetBottom());
                return insets;
            }
        });
    }
}
