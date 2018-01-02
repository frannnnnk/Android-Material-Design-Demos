package com.itdog.materialdesigndemo.examples;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import com.itdog.materialdesigndemo.IndexListAdapter;
import com.itdog.materialdesigndemo.R;


public class CollapsingToolBarLayoutActivity extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout;

    private Toolbar toolbar;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.collapsing_toolbar_layout);

        initActionBar();
        initCollapsingToolBarLayout();
        initRecyclerView();
    }

    private void initActionBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initCollapsingToolBarLayout() {
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.ctl);
        collapsingToolbarLayout.setExpandedTitleColor(Color.RED);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.BLACK);
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new IndexListAdapter());
    }
}
