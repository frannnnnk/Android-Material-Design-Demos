package com.itdog.materialdesigndemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/12/2 0002.
 */

public class IndexListAdapter extends RecyclerView.Adapter<IndexListAdapter.IndexItemViewHolder> {

    @Override
    public IndexItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.index_list_item_layout, null);
        return new IndexItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(IndexItemViewHolder holder, int position) {
        holder.title.setText("哈哈哈哈 " + position);
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public static class IndexItemViewHolder extends RecyclerView.ViewHolder {

        public TextView title;

        public IndexItemViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
