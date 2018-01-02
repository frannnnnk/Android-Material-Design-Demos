package com.itdog.materialdesigndemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itdog.materialdesigndemo.examples.BehaviorActivity;
import com.itdog.materialdesigndemo.examples.CollapsingToolBarLayoutActivity;
import com.itdog.materialdesigndemo.examples.FitSystemWindowActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/3 0003.
 */

public class MainActivity extends AppCompatActivity {

    private List<Pair<String, Class<? extends AppCompatActivity>>> exampleLists = new ArrayList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        setContentView(createRecyclerView());
    }

    private void initData() {
        exampleLists.add(new Pair<String, Class<? extends AppCompatActivity>>("CollapsingToolBarLayout", CollapsingToolBarLayoutActivity.class));
        exampleLists.add(new Pair<String, Class<? extends AppCompatActivity>>("自定义Behavior", BehaviorActivity.class));
        exampleLists.add(new Pair<String, Class<? extends AppCompatActivity>>("FitSystemWindow", FitSystemWindowActivity.class));
    }

    private RecyclerView createRecyclerView() {
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new RecyclerView.Adapter<ItemViewHolder>() {
            @Override
            public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                TextView tv = new TextView(MainActivity.this);
                tv.setTextSize(25);
                tv.setTextColor(Color.BLACK);
                tv.setGravity(Gravity.CENTER);
                tv.setBackgroundDrawable(MainActivity.this.getResources().getDrawable(R.drawable.index_item_bg));
                tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtils.dip2px(MainActivity.this, 50)));
                return new ItemViewHolder(tv);
            }

            @Override
            public void onBindViewHolder(ItemViewHolder holder, final int position) {
                holder.title.setText(exampleLists.get(position).first);
                holder.title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, exampleLists.get(position).second));
                    }
                });
            }

            @Override
            public int getItemCount() {
                return exampleLists.size();
            }
        });
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return recyclerView;
    }

    private static class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView title;

        public ItemViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView;
        }
    }
}
